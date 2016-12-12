package edu.paszgr.control;

import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

import java.util.List;

public class RoundManager {
    private final Board board;
    private ExecutionManager executionManager;
//    private int turnCount = 0;

    public RoundManager(Board board, ExecutionManager executionManager) {
        this.board = board;
        this.executionManager = executionManager;
    }

    public void executeNextRound() {
        // TODO - verify correctness
        System.out.println("Rount start");
        while(!this.roundEndReached()) {
            this.executeNextTurn();
        }
    }

    private boolean roundEndReached() {
        int survivors = 0;
        List<Tank> tanks = board.getAllTanks();
        for (Tank tank : tanks) {
            if (tank.getLifePoints()!=0)
                survivors++;
        }
        return survivors==0;
    }

    private void executeNextTurn() {
        List<Tank> tanks = board.getAllTanks();
        for (Tank tank : tanks) {
            TankActionList actions = tank
                    .getPlayer()
                    .getPlayStrategy()
                    .createTankActionList(
                            tank.getStateInfo()
                    );
            // TODO - execute tank action
            for (TankAction action: actions.getActions()) {
                action.acceptExecutor(executionManager);
            }
        }
    }


}
