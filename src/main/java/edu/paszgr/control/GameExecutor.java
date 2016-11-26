package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.managers.DefaultExecutionManager;
import edu.paszgr.control.managers.DefaultTankManager;

public class GameExecutor {
    private TanksManager tanksManager;
    private RoundManager roundManager;

    public GameExecutor(Board board) {
        this.tanksManager = new DefaultTankManager();
        this.roundManager = new RoundManager(
                tanksManager.createTanks(board),
                board,
                new DefaultExecutionManager()
        );
    }

    public void initializeGame() {
        roundManager.initialize();
    }

    public void executeGame() {
        while (!roundManager.gameEndReached()) {
            roundManager.executeNextRound();
        }
    }
}
