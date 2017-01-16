package edu.paszgr.control;

import edu.paszgr.GameConstants;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.persistence.PersistanceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundManager {
    private final Board board;
    private ExecutionManager executionManager;
    private int currentTurn = GameConstants.STARTING_TURN_NUMBER;
    private static final int TURN_MAX = GameConstants.TURNS_NUMBER_LIMIT;

    private GameInfoLogger logger;

    public RoundManager(Board board, ExecutionManager executionManager, GameInfoLogger logger) {
        this.board = board;
        this.executionManager = executionManager;
        this.logger = logger;
    }

    public void executeNextRound(int roundNumber) {
        currentTurn = GameConstants.STARTING_TURN_NUMBER;
        logger.log("\n *** ROUND " + roundNumber + " ***\n");
        while (!this.roundEndReached()) {
            this.executeNextTurn(roundNumber);
            currentTurn++;
        }
    }

    private boolean roundEndReached() {
        int survivors = board.getAllTanks().stream()
                .filter(Tank::isAlive)
                .collect(Collectors.toList())
                .size();
        //TODO: survivors == 0 allows the only remaining tank to move and fire, even though it is alone
        //TODO: consider changing to 1
        if (survivors < 2 || currentTurn > TURN_MAX) {
            return true;
        } else {
            return false;
        }
    }

    private void executeNextTurn(int roundNumber) {
        List<Tank> tanks = board.getAllTanks();
        List<Tank> stillAliveTanks = new ArrayList<>(tanks.size());
        stillAliveTanks.addAll(tanks);
        int tankTurnNumber = GameConstants.STARTING_TANK_TURN_NUMBER;
        for (Tank tank : tanks) {
            if (tank.isAlive()) {
                int accumulatedActionPoints = tank.getAccumulatedActionPoints();
                int actionPointsForThisTurn = accumulatedActionPoints + GameConstants.ACTION_POINTS_PER_TURN;

                TankActionList actionList = new TankActionList(tank.getStateInfo(), actionPointsForThisTurn);


                tank.getPlayer().getStrategy().scheduleTankActionList(tank.getStateInfo(), actionList);

                actionList.getActions().forEach(tankAction ->
                        executionManager.executeTankAction(tankAction, tank, board, roundNumber)
                );

                tank.setAccumulatedActionPoints(actionList.getRemainingActionPoints());

                removeKilledTanks(stillAliveTanks);

                PersistanceManager.saveGameState(board, tank, roundNumber, currentTurn, tankTurnNumber);

            }
            tankTurnNumber++;
        }
        board.setTanks(stillAliveTanks);
        logger.log("");
    }

    private void removeKilledTanks(List<Tank> stillAliveTanks) {
        stillAliveTanks.removeIf(tank -> !tank.isAlive());
    }
}
