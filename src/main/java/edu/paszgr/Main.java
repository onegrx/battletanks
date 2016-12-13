package edu.paszgr;

import edu.paszgr.board.Board;
import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.GameExecutor;
import edu.paszgr.control.PlayersManager;
import edu.paszgr.control.TanksManager;

public class Main {
    public static void main(String[] args) {
        int numberOfRound = 3;
        TanksManager tanksManager = new TanksManager();
        PlayersManager playersManager = new PlayersManager();
        GameExecutor gameExecutor = new GameExecutor(tanksManager, playersManager);

        BoardSize boardSize = new BoardSize(20, 20);
        ExecutionManager executionManager = new ExecutionManager();
        gameExecutor.executeGame(executionManager, boardSize, numberOfRound);
    }
}
