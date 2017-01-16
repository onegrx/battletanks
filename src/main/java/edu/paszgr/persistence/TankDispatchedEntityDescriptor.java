package edu.paszgr.persistence;

import edu.paszgr.algo.Direction;

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
    private String weaponFireClassName;
    private Direction direction = null;

    public TankDispatchedEntityDescriptor(int xPos, int yPos, String weaponFireClassName, TankDescriptor sourceTank) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.weaponFireClassName = weaponFireClassName;
    }

    public TankDispatchedEntityDescriptor(int xPos, int yPos, String weaponFireClassName, TankDescriptor sourceTank, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.weaponFireClassName = weaponFireClassName;
        this.direction = direction;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String getWeaponFireClassName() {
        return weaponFireClassName;
    }

    public Direction getDirection() {
        return direction;
    }
}
