package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.board.TankActionExecutor;

public class WeaponFire implements TankAction {
    private final Direction direction;
    private static final int POINTS_COST = 5;

    public WeaponFire(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void acceptExecutor(TankActionExecutor executor) {
        executor.executeWeaponFire(this);
    }

    @Override
    public int getActionPointsCost() {
        return this.POINTS_COST;
    }

    public Direction getDirection() {
        return direction;
    }
}
