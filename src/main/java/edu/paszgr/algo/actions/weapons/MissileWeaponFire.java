package edu.paszgr.algo.actions.weapons;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.WeaponFireVisitor;
import edu.paszgr.algo.actions.WeaponFire;

public class MissileWeaponFire extends WeaponFire {
    public MissileWeaponFire(Direction direction) {
        super(direction);
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public int getLifePointsDamage() {
        return 10;
    }

    @Override
    public void acceptWeaponFireVisitor(WeaponFireVisitor visitor) {
        visitor.visitMissileWeaponFire(this);
    }
}
