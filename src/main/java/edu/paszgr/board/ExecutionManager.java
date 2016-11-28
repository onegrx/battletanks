package edu.paszgr.board;

import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.control.Tank;

public class ExecutionManager implements TankActionExecutor {
    private Tank currentTank = null;
    private Board board = null;

    public void executeTankAction(TankAction action, Tank tank, Board board) {
        this.board = board;
        this.currentTank = tank;
        action.acceptExecutor(this);
    }

    @Override
    public void executeMovement(Movement movement) {
        System.out.println("Moved");
        // TODO
    }

    @Override
    public void executeWeaponFire(WeaponFire weaponFire) {
        System.out.println("Fired");
        // TODO
    }
}
