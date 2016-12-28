package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.TankActionVisitor;

public class Movement implements TankAction {
    private static final int POINTS_COST = 5;
    private Direction direction;

    public Movement(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void accept(TankActionVisitor visitor) {
        visitor.visitMovement(this);
    }

    @Override
    public int getActionPointsBasicCost() {
        return POINTS_COST;
    }
}
