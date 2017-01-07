package edu.paszgr.persistence;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBList;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;


/**
 * Created by onegrx on 31.12.16.
 */
public class MongoDao {

    private static final String DATABASE_NAME = "battletanks";
    private static final MongoClient mongoClient = new MongoClient("localhost", 27017);
    private static final MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

    public static void saveGamestate(GameState gs, String collectionName) {

        MongoCollection<Document> collection = database.getCollection(collectionName);

        Document gameState = new Document();
        gameState.put("id", gs.getId());
        gameState.put("roundNumber", gs.getRoundNumber());
        gameState.put("turnNumber", gs.getTurnNumber());
        gameState.put("tankTurnNumber", gs.getTankTurnNumber());
        gameState.put("currentTank", tankDescriptorToDoc(gs.getCurrentTank()));
        gameState.put("allTanks", tankDescriptorsToDoc(gs.getAllTanks()));

        collection.insertOne(gameState);

    }

    public static GameState readGameState(int roundNumber, int turnNumber, int tankTurnNumber, String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document gs = collection.find(
                and(
                        eq("roundNumber", roundNumber),
                        eq("turnNumber", turnNumber),
                        eq("tankTurnNumber", tankTurnNumber)
                )
        ).first();

        return documentToGamestate(gs);
    }

    public static GameState readGameStateById(int id, String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document gs = collection.find(
                eq("id", id)
        ).first();

        return documentToGamestate(gs);

    }

    public static void dropCollection() {
        database.getCollection(PersistanceManager.COLLECTION_NAME).drop();
    }

    public static int getTankTurnsNumber(int roundNumber, int turnNumber) {
        MongoCollection<Document> collection = database.getCollection(PersistanceManager.COLLECTION_NAME);

        Document matchDoc = new Document();
        matchDoc.put("roundNumber", roundNumber);
        matchDoc.put("turnNumber", turnNumber);

        Document match = new Document(
                "$match", matchDoc
        );

        Document group = new Document(
                "$group", new Document("_id", "$tankTurnNumber")
        );

        List<Document> pipeline = Lists.newArrayList(match, group);

        AggregateIterable<Document> aggregate = collection.aggregate(pipeline);
        return Iterators.size(aggregate.iterator());

    }

    public static int getTurnsNumber(int roundNumber) {
        MongoCollection<Document> collection = database.getCollection(PersistanceManager.COLLECTION_NAME);

        Document match = new Document(
                "$match", new Document("roundNumber", roundNumber)
        );

        Document group = new Document(
                "$group", new Document("_id", "$turnNumber")
        );

        List<Document> pipeline = Lists.newArrayList(match, group);

        AggregateIterable<Document> aggregate = collection.aggregate(pipeline);
        return Iterators.size(aggregate.iterator());
    }

    private static GameState documentToGamestate(Document gs) {
        if (gs == null) {
            return null;
        }
        Document tankDescriptorDoc = (Document) gs.get("currentTank");
        BasicDBList list = new BasicDBList();
        list.addAll((List<Document>) gs.get("allTanks"));

        return new GameState(
                gs.getInteger("id"),
                gs.getInteger("roundNumber"),
                gs.getInteger("turnNumber"),
                gs.getInteger("tankTurnNumber"),
                docToTankDescriptor(tankDescriptorDoc),
                docListToTankDescriptors(list)
        );
    }

    private static Document tankDescriptorToDoc(TankDescriptor desc) {
        Document doc = new Document();
        doc.put("lifePoints", desc.getLifePoints());
        doc.put("xPos", desc.getxPos());
        doc.put("yPos", desc.getyPos());
        doc.put("playerTankName", desc.getPlayerTankName());
        doc.put("color", desc.getColor());
        return doc;
    }

    private static BasicDBList tankDescriptorsToDoc(List<TankDescriptor> tankDescriptors) {
        return tankDescriptors.stream().map(MongoDao::tankDescriptorToDoc).collect(Collectors.toCollection(BasicDBList::new));
    }

    private static TankDescriptor docToTankDescriptor(Document doc) {
        return new TankDescriptor(
                doc.getInteger("lifePoints"), doc.getInteger("xPos"), doc.getInteger("yPos"), doc.getString("playerTankName"), doc.getInteger("color")
        );
    }

    private static List<TankDescriptor> docListToTankDescriptors(BasicDBList list) {
        return list.stream().map(tankDescDoc -> docToTankDescriptor((Document) tankDescDoc)).collect(Collectors.toList());
    }

}

