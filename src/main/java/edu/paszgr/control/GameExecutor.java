package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

public class GameExecutor {
    private TanksManager tanksManager;
    private RoundManager roundManager;

    public GameExecutor(Board board) {
        this.tanksManager = new TanksManager();
        this.roundManager = new RoundManager(
                tanksManager.createTanks(board),
                board,
                new ExecutionManager()
        );
    }

    public void initializeGame() {
        roundManager.initialize();
    }

    public void executeGame() {
        // TODO
        while (!roundManager.gameEndReached()) {
            roundManager.executeNextRound();
        }
    }
}
