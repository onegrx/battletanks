package edu.paszgr.algo.actions.weapons;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.WeaponFireVisitor;
import edu.paszgr.algo.actions.WeaponFire;

public class MineWeaponFire extends WeaponFire {
    public MineWeaponFire(Direction direction) {
        super(direction);
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getLifePointsDamage() {
        return 5;
    }

    @Override
    public void acceptWeaponFireVisitor(WeaponFireVisitor visitor) {
        visitor.visitMineWeaponFire(this);
    }
}
