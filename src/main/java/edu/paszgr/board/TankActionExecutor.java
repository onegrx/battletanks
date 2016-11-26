package edu.paszgr.board;

import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;

public interface TankActionExecutor {
    void executeMovement(Movement movement);
    void executeWeaponFire(WeaponFire weaponFire);
}
