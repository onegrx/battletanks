package edu.paszgr.control;

import edu.paszgr.GameConstants;
import edu.paszgr.board.Board;
import edu.paszgr.board.BoardSize;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.persistence.PersistanceManager;

import java.util.List;

public class GameExecutor {
    private final TanksManager tanksManager = new TanksManager();
    private final PlayersManager playersManager = new PlayersManager();
    private List<Player> players = null;

    private GameInfoLogger logger;

    public GameExecutor(GameInfoLogger logger) {
        this.logger = logger;
    }

    public void executeGame(ExecutionManager executionManager, BoardSize boardSize, int numberOfRounds) {
        logger.log("Starting game.\n");
        this.players = playersManager.createPlayers();
        Board board = new Board(boardSize);

        PersistanceManager.saveFieldsToFile(board.getFields(), GameConstants.FIELDS_FILE_NAME);

        RoundManager roundManager = new RoundManager(board, executionManager, logger);

        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {

            board.setTanks(tanksManager.createTanks(this.players, board));

            for (Tank tank : board.getAllTanks()) {
                tank.getPlayer().getStatistics().setStatisticsForRound(new RoundStatistics(roundNumber), roundNumber);
            }

            roundManager.executeNextRound(roundNumber);

            for (Tank tank : board.getAllTanks()) {
                tank.getPlayer().getStatistics().getStatisticsForRound(roundNumber).setLifePointsLeft(tank.getLifePoints());
            }

            this.presentRoundStatistics(roundNumber);
        }
        this.presentSummedUpStatistics();
        logger.log("Game finished.");
    }

    private void presentRoundStatistics(int roundNumber) {
        logger.log("ROUND " + roundNumber + " STATISTICS: \n");
        for (Player player : players) {
            logger.log("Player: " + player.getPlayerTankName());
            logger.log("Killed: " + player.getStatistics().getStatisticsForRound(roundNumber).getKills() + " enemies");
            logger.log("Shot: " + player.getStatistics().getStatisticsForRound(roundNumber).getShots() + " times");
            logger.log("Moved: " + player.getStatistics().getStatisticsForRound(roundNumber).getMoves() + " times");
            logger.log("HP left: " + player.getStatistics().getStatisticsForRound(roundNumber).getLifePointsLeft());
            logger.log("");
        }
    }

    private void presentSummedUpStatistics() {

        logger.log("\n\n ***** FINAL STATISTICS *****\n");

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

            logger.log("Player: " + player.getPlayerTankName());
            logger.log("Killed: " + allKills + " enemies");
            logger.log("Shot: " + allShots + " times");
            logger.log("Moved: " + allMoves + " times");
            logger.log("");
        }
    }
}
