package edu.paszgr.control;

import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

public class RoundManager {
    private final Board board;
    private ExecutionManager executionManager;
    private int currentTurn = 0;
    private static final int TURN_MAX = 10;
    private GameInfoLogger logger;

    public RoundManager(Board board, ExecutionManager executionManager, GameInfoLogger logger) {
        this.board = board;
        this.executionManager = executionManager;
        this.logger = logger;
    }

    public void executeNextRound(int roundNumber) {
        logger.log("\n *** ROUND " + roundNumber + " ***\n");
        while (!this.roundEndReached()) {
            this.executeNextTurn(roundNumber);
        }
    }

    private boolean roundEndReached() {
        int survivors = board.getAllTanks().stream()
                .filter(Tank::isAlive)
                .collect(Collectors.toList())
                .size();
        //TODO: survivors == 0 allows the only remaining tank to move and fire, even though it is alone
        //TODO: consider changing to 1
        if (survivors == 0 || currentTurn > TURN_MAX) {
            currentTurn = 0;
            return true;
        } else {
            currentTurn++;
            return false;
        }
    }

    private void executeNextTurn(int roundNumber) {
        List<Tank> tanks = board.getAllTanks();
        // tankTurnNumber is needed for the persistence of GameState
        for (int tankTurnNumber = 0; tankTurnNumber < tanks.size(); tankTurnNumber++) {
            Tank tank = tanks.get(tankTurnNumber);
            if (tank.isAlive()) {

                TankActionList actionList = new TankActionList(tank.getStateInfo(), 10);
                tank.getPlayer().getStrategy().scheduleTankActionList(tank.getStateInfo(), actionList);

                actionList.getActions().forEach(tankAction ->
                        executionManager.executeTankAction(tankAction, tank, board, roundNumber)
                );

                removeKilledTanks();

                PersistanceManager.saveGameState(board, tank, roundNumber, currentTurn, tankTurnNumber);


            }
        }
        logger.log("");
    }

    private void removeKilledTanks() {
        board.getAllTanks().removeIf(tank -> !tank.isAlive());
    }
}
