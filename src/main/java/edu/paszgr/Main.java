package edu.paszgr;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.board.TankActionExecutor;
import edu.paszgr.board.managers.DefaultExecutionManager;

public class Main {
    public static void main(String[] args) {
        ExecutionManager executor = new DefaultExecutionManager();
        TankAction action1 = new Movement(Direction.DOWN);
        TankAction action2 = new WeaponFire(Direction.DOWN);

        executor.executeTankAction(action1, null, null);
        executor.executeTankAction(action2, null, null);
    }
}
