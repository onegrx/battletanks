package edu.paszgr;

import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.GameExecutor;
import edu.paszgr.persistence.MongoDao;

public class Main {
    public static void main(String[] args) {
        int numberOfRound = 3;

        MongoDao.dropCollection();
        GameExecutor gameExecutor = new GameExecutor("", "");

        BoardSize boardSize = new BoardSize(20, 20);
        ExecutionManager executionManager = new ExecutionManager();
        gameExecutor.executeGame(executionManager, boardSize, numberOfRound);
    }
}
