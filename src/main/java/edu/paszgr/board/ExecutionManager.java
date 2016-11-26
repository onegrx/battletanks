package edu.paszgr.board;

import edu.paszgr.algo.TankAction;
import edu.paszgr.control.Tank;

public interface ExecutionManager extends TankActionExecutor {
    void executeTankAction(TankAction action, Tank tank, Board board);
}
