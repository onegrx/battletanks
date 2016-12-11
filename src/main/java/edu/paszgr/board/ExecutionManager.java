package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.control.Tank;
import java.util.List;

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
        Position oldPosition = currentTank.getPosition();
        Position newPosition = getNewPosition(movement.getDirection(), oldPosition, 1);
        currentTank.setPosition(newPosition);

        System.out.println("Tank " + currentTank.getTankName() + " has already moved to ("
                + newPosition.getX() + ", " + newPosition.getY() + ")");

    }

    @Override
    public void executeWeaponFire(WeaponFire weaponFire) {
        Position position = currentTank.getPosition();
        List<Tank> onTargetLine = board.getTanksOnTargetLine(position, weaponFire.getDirection());

        System.out.println("Tank " + currentTank.getTankName() + " has already fired.");
        onTargetLine.forEach(tank ->
                System.out.println("Tank " + tank.getTankName() + " fragged"));

        onTargetLine.forEach(tank -> tank.decreaseLifePoints(1));
        //Currently assuming each tank has 1 HP
        board.getAllTanks().removeAll(onTargetLine);
    }

    private Position getNewPosition(Direction direction, Position oldPosition, int steps) {
        switch (direction) {
            case DOWN: return new Position(oldPosition.getX(), oldPosition.getY() - steps);
            case UP: return new Position(oldPosition.getX(), oldPosition.getY() + steps);
            case LEFT: return new Position(oldPosition.getX() - steps, oldPosition.getY());
            case RIGHT: return new Position(oldPosition.getX() + steps, oldPosition.getY());
            default: return oldPosition;
        }
    }
}
