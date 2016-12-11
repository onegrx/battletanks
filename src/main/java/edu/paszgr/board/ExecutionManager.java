package edu.paszgr.board;

import edu.paszgr.algo.Direction;
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
        // TODO
//        Position oldPosition = board.getPositionOfTank(currentTank);
//        Position newPosition = getNewPosition(movement.getDirection(), oldPosition);
//        board.setNewTankPosition(currentTank, newPosition);
//        System.out.println("Tank " + currentTank.getTankName() + " has already moved to ("
//                + newPosition.getX() + ", " + newPosition.getY() + ")");
    }

    @Override
    public void executeWeaponFire(WeaponFire weaponFire) {
        // TODO
//        System.out.println("Tank " + currentTank.getTankName() + " has already fired.");
    }

//    private Position getNewPosition(Direction direction, Position oldPosition) {
//        switch (direction) {
//            case DOWN: return new Position(oldPosition.getX() - 1, oldPosition.getY());
//            case UP: return new Position(oldPosition.getX() + 1, oldPosition.getY());
//            case LEFT: return new Position(oldPosition.getX(), oldPosition.getY() - 1);
//            case RIGHT: return new Position(oldPosition.getX(), oldPosition.getY() + 1);
//            default: return oldPosition; //should not happen todo fix in future
//        }
//    }
}
