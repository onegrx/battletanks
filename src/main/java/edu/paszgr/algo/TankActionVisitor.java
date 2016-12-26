package edu.paszgr.algo;

import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;

public interface TankActionVisitor {
    void visitMovement(Movement movement);
    void visitWeaponFire(WeaponFire weaponFire);
}
