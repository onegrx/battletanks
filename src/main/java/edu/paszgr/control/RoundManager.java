package edu.paszgr.control;

import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

import java.util.stream.Collectors;

public class RoundManager {
    private final Board board;
    private ExecutionManager executionManager;
    private int currentTurn = 1;
    private static final int TURN_MAX = 3;

    public RoundManager(Board board, ExecutionManager executionManager) {
        this.board = board;
        this.executionManager = executionManager;
    }

    public void executeNextRound(int roundNumber) {
        System.out.println("\n *** ROUND " + roundNumber + " ***\n");
        while (!this.roundEndReached()) {
            this.executeNextTurn();
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
            currentTurn = 1;
            return true;
        } else {
            currentTurn++;
            return false;
        }
    }

    private void executeNextTurn() {
        board.getAllTanks().forEach(tank -> {

            if (tank.isAlive()) {

                TankActionList actionList = tank.getPlayer().getPlayStrategy()
                        .createTankActionList(tank.getStateInfo());

                actionList.getActions().forEach(tankAction ->
                        executionManager.executeTankAction(tankAction, tank, board)
                );
            }

        });

        removeKilledTanks();

        System.out.println();

    }

    private void removeKilledTanks() {
        board.getAllTanks().removeIf(tank -> !tank.isAlive());
    }

}
