package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;

import java.util.List;

public class GameExecutor {
    private TanksManager tanksManager;
    private PlayersManager playersManager;
    private List<Player> players = null;

    public GameExecutor(TanksManager tanksManager, PlayersManager playersManager) {
        this.tanksManager = tanksManager;
        this.playersManager = playersManager;
    }

    public void executeGame(ExecutionManager executionManager, BoardSize boardSize, int numberOfRounds) {
        System.out.println("Starting game.\n");
        this.players = playersManager.createPlayers();
        Board board = new Board(boardSize);

        RoundManager roundManager = new RoundManager(board, executionManager);

        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {

            for (Tank tank: board.getAllTanks()) {
                tank.getPlayer().createRoundStatistics(roundNumber);
            }

            roundManager.executeNextRound(roundNumber);
            this.presentRoundStatistics(roundNumber);
        }
        this.presentSummedUpStatistics();
        System.out.println("Game finished.");
    }

    private void presentRoundStatistics(int roundNumber) {
        System.out.println("ROUND " + roundNumber + " STATISTICS: \n");
        for (Player player : players) {
            System.out.println("Player: " + player.getPlayerTankName());
            System.out.println("Killed: " + player.getRoundStatistics(roundNumber).getKills() + " enemies");
            System.out.println("Shot: " + player.getRoundStatistics(roundNumber).getShots() + " times");
            System.out.println("Moved: " + player.getRoundStatistics(roundNumber).getMoves() + " times");
            System.out.println("HP left: " + player.getRoundStatistics(roundNumber).getLifePointsLeft());
            System.out.println();
        }

    }

    private void presentSummedUpStatistics() {

        System.out.println("\n\n ***** FINAL STATISTICS *****\n");

        for (Player player : players) {
            List<RoundStatistics> statistics = player.getStatistics();

            int allKills = 0;
            int allShots = 0;
            int allMoves = 0;

            for (RoundStatistics roundStatistic : statistics) {
                allKills += roundStatistic.getKills();
                allShots += roundStatistic.getShots();
                allMoves += roundStatistic.getMoves();
            }

            System.out.println("Player: " + player.getPlayerTankName());
            System.out.println("Killed: " + allKills + " enemies");
            System.out.println("Shot: " + allShots + " times");
            System.out.println("Moved: " + allMoves + " times");
            System.out.println();
        }
    }
}
