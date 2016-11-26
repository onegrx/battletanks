package edu.paszgr.algo.actions;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.board.TankActionExecutor;

public class WeaponFire implements TankAction {
    private Direction direction;

    private WeaponFire() {}

    public WeaponFire(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void acceptExecutor(TankActionExecutor executor) {
        executor.executeWeaponFire(this);
    }
}
