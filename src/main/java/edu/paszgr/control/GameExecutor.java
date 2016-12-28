package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;

import java.util.List;

public class GameExecutor {
    private final TanksManager tanksManager = new TanksManager();
    private final PlayersManager playersManager = new PlayersManager();
    private List<Player> players = null;
    private final String fieldsFileName;
    private final String gameStateFileName;

    public GameExecutor(String fieldsFileName, String gameStateFileName) {
        this.fieldsFileName = fieldsFileName;
        this.gameStateFileName = gameStateFileName;
    }

    public void executeGame(ExecutionManager executionManager, BoardSize boardSize, int numberOfRounds) {
        System.out.println("Starting game.\n");
        this.players = playersManager.createPlayers();
        Board board = new Board(boardSize);

        // TODO - save board fields

        RoundManager roundManager = new RoundManager(board, executionManager, gameStateFileName);

        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {

            board.setTanks(tanksManager.createTanks(this.players, board));

            for (Tank tank: board.getAllTanks()) {
                tank.getPlayer().getStatistics().setStatisticsForRound(new RoundStatistics(roundNumber), roundNumber);
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
            System.out.println("Killed: " + player.getStatistics().getStatisticsForRound(roundNumber).getKills() + " enemies");
            System.out.println("Shot: " + player.getStatistics().getStatisticsForRound(roundNumber).getShots() + " times");
            System.out.println("Moved: " + player.getStatistics().getStatisticsForRound(roundNumber).getMoves() + " times");
            System.out.println("HP left: " + player.getStatistics().getStatisticsForRound(roundNumber).getLifePointsLeft());
            System.out.println();
        }
    }

    private void presentSummedUpStatistics() {

        System.out.println("\n\n ***** FINAL STATISTICS *****\n");

        for (Player player : players) {
            List<RoundStatistics> statistics = player.getStatistics().getAllRoundStatistics();

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
