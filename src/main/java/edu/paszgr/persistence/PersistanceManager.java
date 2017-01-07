package edu.paszgr.persistence;

import edu.paszgr.GameConstants;
import edu.paszgr.board.Board;
import edu.paszgr.board.Field;
import edu.paszgr.control.Tank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersistanceManager {
    public static final String COLLECTION_NAME = "gamestates";

    public static Field[][] getFields() {
        return readFieldsFromFile(GameConstants.FIELDS_FILE_NAME);
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
        GameState gameState = getGameState(roundNumber, turnNumber, tankTurnNumber);
        if (gameState == null) {
            return null;
        }
        int id = gameState.getId();
        return getGameStateById(id + 1);
    }

    public static GameState getPrevGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        GameState gameState = getGameState(roundNumber, turnNumber, tankTurnNumber);
        if (gameState == null) {
            return null;
        }
        int id = gameState.getId();
        return getGameStateById(id - 1);
    }

    public static void saveFieldsToFile(Field[][] fields, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(fields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveGameState(Board board, Tank tank, int roundNumber, int turnNumber, int tankTurnNumber) {

        TankDescriptor tankDescriptor = new TankDescriptor(
                tank.getLifePoints(), tank.getPosition().getX(), tank.getPosition().getY(), tank.getTankName(), tank.getPlayer().getColor().getRGB()
        );

        List<TankDescriptor> allTanks = new ArrayList<>();

        board.getAllTanks().forEach(boardTank -> allTanks.add(new TankDescriptor(
                boardTank.getLifePoints(), boardTank.getPosition().getX(), boardTank.getPosition().getY(), boardTank.getTankName(), boardTank.getPlayer().getColor().getRGB()
        )));

        GameState gameState = new GameState(IdGenerator.next(), roundNumber, turnNumber, tankTurnNumber, tankDescriptor, allTanks);
        MongoDao.saveGamestate(gameState, COLLECTION_NAME);
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


    public static int getRoundsNumber() {
        return GameConstants.ROUNDS_NUMBER;
    }

    public static int getTurnsNumber(int roundNumber) {
        return MongoDao.getTurnsNumber(roundNumber);
    }

    public static int getTankTurnsNumber(int roundNumber, int turnNumber) {
        return MongoDao.getTankTurnsNumber(roundNumber, turnNumber);
    }
}
