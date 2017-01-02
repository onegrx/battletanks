package edu.paszgr.persistence;

import edu.paszgr.board.Board;
import edu.paszgr.board.Field;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class PersistanceManager {

    public static final String COLLECTION_NAME = "gamestates";
    public static final String FIELDS_FILE_NAME = "fields.ser";

    public static Field[][] getFields() {
        return readFieldsFromFile(FIELDS_FILE_NAME);
    }

    public static GameState getGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        return MongoDao.readGameState(roundNumber, turnNumber, tankTurnNumber, COLLECTION_NAME);
    }

    private static GameState getGameStateById(int id) {
        return MongoDao.readGameStateById(id, COLLECTION_NAME);
    }

    //Alternative implementation, should return the same
    public static GameState getNextGameState2(int roundNumber, int turnNumber, int tankTurnNumber) {

        Optional<GameState> nextState =
                getOptionalGameState(roundNumber, turnNumber, tankTurnNumber + 1);

        return nextState
                .orElse(getOptionalGameState(roundNumber, turnNumber + 1, 1)
                        .orElse(getOptionalGameState(roundNumber + 1, 1, 1)
                                .orElse(null)));

    }

    public static GameState getNextGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        int id = getGameState(roundNumber, turnNumber, tankTurnNumber).getId();
        return getGameStateById(id + 1);
    }


    public static GameState getPrevGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        int id = getGameState(roundNumber, turnNumber, tankTurnNumber).getId();
        return getGameStateById(id - 1);
    }

    public void saveFieldsToFile(Field[][] fields, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(fields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGameState(Board board, String collection) {
        //TODO
    }

    private static Optional<GameState> getOptionalGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        return Optional.ofNullable(getGameState(roundNumber, turnNumber, tankTurnNumber));
    }

    private static Field[][] readFieldsFromFile(String fileName) {
        Field[][] fields = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream iis = new ObjectInputStream(fis);
            fields = (Field[][]) iis.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fields;
    }


}
