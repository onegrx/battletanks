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
        System.out.println(" In round " + roundNumber + ":");
        for (Player player: players) {
            System.out.println("Player: " + player.getPlayerTankName());
            System.out.println("Kiled: " + player.getRoundStatistics(roundNumber).getKills() + " enemies");
            System.out.println("Shot: " + player.getRoundStatistics(roundNumber).getShots() + " times");
            System.out.println("Moved: " + player.getRoundStatistics(roundNumber).getMoves() + " times");
            System.out.println("End with: " + player.getRoundStatistics(roundNumber).getLifePointsLeft() + " points of life left");
            System.out.println("*************************************");
        }

    }

    private void presentSummedUpStatistics() {
        System.out.println(" In round this game:");
        for (Player player: players) {
            List<RoundStatistics> statistics = player.getStatistics();
            int allKills = 0;
            int allShots = 0;
            int allMoves = 0;
            for (RoundStatistics roundStatistic: statistics) {
                allKills+=roundStatistic.getKills();
                allShots+=roundStatistic.getShots();
                allMoves+=roundStatistic.getMoves();

            }
            System.out.println("Player: " + player.getPlayerTankName());
            System.out.println("Kiled: " + allKills + " enemies");
            System.out.println("Shot: " + allShots + " times");
            System.out.println("Moved: " + allMoves + " times");
            System.out.println("*************************************");
        }
    }
}
