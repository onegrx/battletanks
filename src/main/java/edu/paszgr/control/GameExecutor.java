package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

public class GameExecutor {
    private TanksManager tanksManager = new TanksManager();
    private RoundManager roundManager;

    public GameExecutor(Board board) {
        this.roundManager =
                new RoundManager(tanksManager.createTanks(board), board, new ExecutionManager());
    }

    public void executeGame() {
        System.out.println("Starting game.");
        while (!roundManager.gameEndReached()) {
            roundManager.executeNextRound();
        }
        System.out.println("Game ended");
    }
}
