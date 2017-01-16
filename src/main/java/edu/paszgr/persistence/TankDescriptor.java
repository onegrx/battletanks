package edu.paszgr.persistence;

import java.util.List;

/**
 * Created by onegrx on 01.01.17.
 */

public class TankDescriptor {
    private int lifePoints;
    private int xPos;
    private int yPos;
    private String playerTankName;
    private int color;
    private List<TankDispatchedEntityDescriptor> entities;

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

    public List<TankDispatchedEntityDescriptor> getEntities() {
        return entities;
    }

    public TankDescriptor(int lifePoints, int xPos, int yPos, String playerTankName, int color, List<TankDispatchedEntityDescriptor> entities) {
        this.lifePoints = lifePoints;
        this.xPos = xPos;
        this.yPos = yPos;
        this.playerTankName = playerTankName;
        this.color = color;
        this.entities = entities;
    }
}

