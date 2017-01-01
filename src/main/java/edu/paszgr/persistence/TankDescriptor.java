package edu.paszgr.persistence;

/**
 * Created by onegrx on 01.01.17.
 */

public class TankDescriptor {

    private int lifePoints;
    private int xPos;
    private int yPos;
    private String playerTankName;
    private int color;

    public int getLifePoints() {
        return lifePoints;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String getPlayerTankName() {
        return playerTankName;
    }

    public int getColor() {
        return color;
    }

    public TankDescriptor(int lifePoints, int xPos, int yPos, String playerTankName, int color) {
        this.lifePoints = lifePoints;
        this.xPos = xPos;
        this.yPos = yPos;
        this.playerTankName = playerTankName;
        this.color = color;
    }
}

