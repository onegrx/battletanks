package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.board.TankActionExecutor;

public class Movement implements TankAction {
    private Direction direction;

    private Movement() {}

    public Movement(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void acceptExecutor(TankActionExecutor executor) {
        executor.executeMovement(this);
    }
}
