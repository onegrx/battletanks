package edu.paszgr.control;

import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

import java.util.List;

public class RoundManager {
    private List<Tank> tanks;
    private final Board board;
    private ExecutionManager executionManager;

    private int roundCount = 0;

    public RoundManager(List<Tank> tanks, Board board, ExecutionManager executionManager) {
        this.tanks = tanks;
        this.board = board;
        this.executionManager = executionManager;
    }

    public void executeNextRound() {
        for(Tank tank: tanks) {
            //executionManager.setCurrentTank(tank);
            TankActionList tankActions = tank.getStrategy().createTankActionList(tank.getStateInfo());
            List<TankAction> tankActionList = tankActions.getActions();
            tankActionList.forEach(tankAction -> executionManager.executeTankAction(tankAction, tank, board));
        }
        roundCount += 1;
    }

    public boolean gameEndReached() {
        return roundCount > 6;
    }
}
