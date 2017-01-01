package edu.paszgr;

import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.GameExecutor;

public class Main {
    public static void main(String[] args) {
        int numberOfRound = 3;

        GameExecutor gameExecutor = new GameExecutor("", "");

        BoardSize boardSize = new BoardSize(200, 200);
        ExecutionManager executionManager = new ExecutionManager();
        gameExecutor.executeGame(executionManager, boardSize, numberOfRound);
    }
}
