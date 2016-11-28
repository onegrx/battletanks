package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.board.TankActionExecutor;

public class WeaponFire implements TankAction {
    private Direction direction;

    public WeaponFire(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void acceptExecutor(TankActionExecutor executor) {
        executor.executeWeaponFire(this);
    }
}
