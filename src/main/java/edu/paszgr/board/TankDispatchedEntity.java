package edu.paszgr.board;

import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.control.Tank;

public class TankDispatchedEntity {
    private final WeaponFire sourceAction;
    private final Tank sourceTank;
    Position position = null;

    public TankDispatchedEntity(WeaponFire sourceAction, Tank sourceTank, Position position) {
        this.position = position;
        this.sourceAction = sourceAction;
        this.sourceTank = sourceTank;
    }

    public TankDispatchedEntity(WeaponFire sourceAction, Tank sourceTank) {
        this.sourceAction = sourceAction;
        this.sourceTank = sourceTank;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public WeaponFire getSourceAction() {
        return sourceAction;
    }

    public Tank getSourceTank() {
        return sourceTank;
    }
}
