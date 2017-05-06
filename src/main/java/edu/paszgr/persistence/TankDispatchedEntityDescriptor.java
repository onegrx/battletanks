package edu.paszgr.persistence;

import edu.paszgr.algo.Direction;

/**
 * Created by Piotr on 2017-01-16.
 */
public class TankDispatchedEntityDescriptor {
    private int xPos;
    private int yPos;
    private Direction direction;

    /**
     *  When saving, use weaponFire.class.getName()
     *  When retrieving, use Class.forName(savedName)
     * */
    private String weaponFireClassName;
    private int rgb;


    public TankDispatchedEntityDescriptor(int xPos, int yPos, Direction direction, String weaponFireClassName) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
        this.weaponFireClassName = weaponFireClassName;
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

    public int getRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
