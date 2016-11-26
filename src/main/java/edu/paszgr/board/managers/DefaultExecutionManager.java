package edu.paszgr.board.managers;

import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.Tank;

public class DefaultExecutionManager implements ExecutionManager {
    private Board board = null;
    private Tank tank = null;

    public void executeMovement(Movement movement) {
        System.out.println("Movement");
        // TODO
    }

    public void executeWeaponFire(WeaponFire weaponFire) {
        System.out.println("Firing");
        // TODO
    }

    /** Sets execution environment and calls appropriate action execution handler method
     * via visitor pattern interface in the TankAction class objects
     * */
    public void executeTankAction(TankAction action, Tank tank, Board board) {
        this.tank = tank;
        this.board = board;
        action.acceptExecutor(this);
    }
}
