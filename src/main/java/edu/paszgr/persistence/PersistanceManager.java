package edu.paszgr.persistence;

import edu.paszgr.board.Field;

import java.io.*;
import java.util.List;

public class PersistanceManager {

    //use it pls todo
//    public void saveGameState(Board..., String collection) {
//
//    }

    public static GameState getGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        return MongoDao.readGameState(roundNumber, turnNumber, tankTurnNumber, "col");
    }

    public static GameState getNextGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        return null;
    }

    public static GameState getPrevGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        return null;
    }

    //todo return null if not found


    //todo filename fix xD
    public static Field[][] getFields() {
        return readFieldsFromFile("");
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

    public void saveFieldsToFile(Field[][] fields, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(fields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
