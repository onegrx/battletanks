package edu.paszgr;

import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.GameExecutor;
import edu.paszgr.control.GameInfoLogger;

public class Main {
    public static void main(String[] args) {
        int numberOfRound = 3;
        GameInfoLogger gameInfoLogger = new GameInfoLogger("log.txt");

        GameExecutor gameExecutor = new GameExecutor("", "", gameInfoLogger);

        BoardSize boardSize = new BoardSize(20, 20);
        ExecutionManager executionManager = new ExecutionManager(gameInfoLogger);
        gameExecutor.executeGame(executionManager, boardSize, numberOfRound);

    }
}
