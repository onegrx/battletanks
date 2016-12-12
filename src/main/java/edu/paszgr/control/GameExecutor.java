package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;

import java.util.List;

public class GameExecutor {
    private TanksManager tanksManager;
    private RoundManager roundManager;
    private PlayersManager playersManager;
    private List<Player> players = null;
    private int numberOfRounds = 0;

    public GameExecutor(TanksManager tanksManager, PlayersManager playersManager) {
        this.tanksManager = tanksManager;
        this.playersManager = playersManager;
    }

    public void executeGame(ExecutionManager executionManager, BoardSize boardSize, int numberOfRounds) {
        System.out.println("Starting game.");
        this.players = playersManager.createPlayers();
        Board board = new Board(boardSize);
        this.numberOfRounds = numberOfRounds;

        this.roundManager = new RoundManager(
                board,
                executionManager
        );

        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber ++) {
            board.setTanks(
                    tanksManager.createTanks(
                            this.players,
                            board
                    )
            );

            roundManager.executeNextRound();
            this.presentRoundStatistics(roundNumber);
        }
        System.out.println("Game ended");
        this.presentSummedUpStatistics();
    }

    private void presentRoundStatistics(int roundNumber) {
        // TODO
    }

    private void presentSummedUpStatistics() {
        // TODO
    }
}
