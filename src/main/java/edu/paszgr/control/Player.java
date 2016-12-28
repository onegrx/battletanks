package edu.paszgr.control;

import edu.paszgr.algo.PlayStrategy;

import java.awt.*;
import java.io.Serializable;

public class Player implements Serializable {
    private final transient PlayStrategy strategy;
    private final transient StatisticsManager statistics = new StatisticsManager();
    private final String playerTankName;
    private Color color;

    public Player(PlayStrategy strategy, String playerTankName, Color color) {
        this.strategy = strategy;
        this.playerTankName = playerTankName;
        this.color = color;
    }

    public PlayStrategy getStrategy() {
        return strategy;
    }

    public StatisticsManager getStatistics() {
        return statistics;
    }

    public String getPlayerTankName() {
        return playerTankName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
