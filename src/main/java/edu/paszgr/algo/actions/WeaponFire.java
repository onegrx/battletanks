package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.TankActionVisitor;
import edu.paszgr.algo.WeaponFireVisitor;

public abstract class WeaponFire implements TankAction {
    private final Direction direction;
    private static final int POINTS_COST = 5;

    public WeaponFire(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void accept(TankActionVisitor visitor) {
        visitor.visitWeaponFire(this);
    }

    @Override
    public int getActionPointsBasicCost() {
        return POINTS_COST;
    }

    public abstract int getSpeed();
    public abstract int getLifePointsDamage();
    public abstract void acceptWeaponFireVisitor(WeaponFireVisitor visitor);
}
