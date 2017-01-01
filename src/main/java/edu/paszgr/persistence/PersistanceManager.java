package edu.paszgr.persistence;

import edu.paszgr.board.Field;

import java.io.*;
import java.util.List;

public class PersistanceManager {

    public void saveGameStateToFile(GameState state, String fileName, boolean append) {
        // TODO
    }

    public List<GameState> readGameStatesFromFile(String fileName) {
        // TODO
        return null;
    }

    public void saveFieldsToFile(Field[][] fields, String fileName, boolean append) {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(fields);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Field[][] readFieldsFromFile(String fileName) {

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
