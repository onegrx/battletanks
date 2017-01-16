package edu.paszgr.algo;

import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.algo.actions.weapons.MineWeaponFire;
import edu.paszgr.algo.actions.weapons.MissileWeaponFire;
import edu.paszgr.algo.actions.weapons.TankPiercingWeaponFire;

public interface WeaponFireVisitor {
    public void visitLaserWeaponFire(LaserWeaponFire laserWeaponFire);
    public void visitMissileWeaponFire(MissileWeaponFire missileWeaponFire);
    public void visitTankPiercingWeaponFire(TankPiercingWeaponFire tankPiercingWeaponFire);
    public void visitMineWeaponFire(MineWeaponFire mineWeaponFire);
}
