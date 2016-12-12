package edu.paszgr.control;

import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

import java.util.stream.Collectors;

public class RoundManager {
    private final Board board;
    private ExecutionManager executionManager;
    private int currentRound = 1;
    private static final int ROUND_MAX = 10;
//    private int turnCount = 0;

    public RoundManager(Board board, ExecutionManager executionManager) {
        this.board = board;
        this.executionManager = executionManager;
    }

    public void executeNextRound() {
        System.out.println("Round start");
        while (!this.roundEndReached()) {
            this.executeNextTurn();
        }
    }

    private boolean roundEndReached() {

        int survivors = board.getAllTanks().stream()
                .filter(Tank::isAlive)
                .collect(Collectors.toList())
                .size();


        if (survivors == 0 || currentRound == ROUND_MAX) {
            return true;
        } else {
            currentRound++;
            return false;
        }

    }

    private void executeNextTurn() {
        board.getAllTanks().forEach(tank -> {

            TankActionList actionList = tank.getPlayer().getPlayStrategy()
                    .createTankActionList(tank.getStateInfo());
            
            actionList.getActions().forEach(tankAction -> 
                executionManager.executeTankAction(tankAction, tank, board)
            );

        });

        removeKilledTanks();
        
    }

    private void removeKilledTanks() {
        board.getAllTanks().removeIf(tank -> !tank.isAlive());
    }

}
