package edu.paszgr.persistence;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.WeaponFire;

/**
 * Created by Piotr on 2017-01-16.
 */
public class TankDispatchedEntityDescriptor {
    private int xPos;
    private int yPos;
    /**
     *  When saving, use weaponFire.class.getName()
     *  When retrieving, use Class.forName(savedName)
     * */
    private Class<? extends WeaponFire> weaponFireClass;
    private Direction direction = null;
    private TankDescriptor sourceTank;

    public TankDispatchedEntityDescriptor(int xPos, int yPos, Class<? extends WeaponFire> weaponFireClass, TankDescriptor sourceTank) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.weaponFireClass = weaponFireClass;
        this.sourceTank = sourceTank;
    }

    public TankDispatchedEntityDescriptor(int xPos, int yPos, Class<? extends WeaponFire> weaponFireClass, TankDescriptor sourceTank, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.weaponFireClass = weaponFireClass;
        this.sourceTank = sourceTank;
        this.direction = direction;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Class<? extends WeaponFire> getWeaponFireClass() {
        return weaponFireClass;
    }

    public TankDescriptor getSourceTank() {
        return sourceTank;
    }

    public Direction getDirection() {
        return direction;
    }
}
