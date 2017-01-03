package edu.paszgr;

import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.GameExecutor;
import edu.paszgr.persistence.MongoDao;
import edu.paszgr.control.GameInfoLogger;

public class MainSimulation {
    private static final String LOG_FILE = "log.txt";

    public static void main(String[] args) {

        MongoDao.dropCollection();
        GameInfoLogger gameInfoLogger = new GameInfoLogger(LOG_FILE);
        GameExecutor gameExecutor = new GameExecutor(gameInfoLogger);

        BoardSize boardSize = GameConstants.BOARD_SIZE_DEFAULT;
        ExecutionManager executionManager = new ExecutionManager(gameInfoLogger);
        gameExecutor.executeGame(executionManager, boardSize, GameConstants.ROUNDS_NUMBER);

    }
}
