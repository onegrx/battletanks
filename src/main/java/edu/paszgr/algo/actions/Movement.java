package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.board.TankActionExecutor;

public class Movement implements TankAction {
    private Direction direction;
    private static final int POINTS_COST = 5;

    public Movement(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void acceptExecutor(TankActionExecutor executor) {
        executor.executeMovement(this);
    }

    @Override
    public int getActionPointsCost() {
        return this.POINTS_COST;
    }

    public Direction getDirection() {
        return direction;
    }
}
