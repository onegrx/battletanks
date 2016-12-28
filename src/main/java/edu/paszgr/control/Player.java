package edu.paszgr.control;

import edu.paszgr.algo.PlayStrategy;

import java.io.Serializable;

public class Player implements Serializable {
    private final transient PlayStrategy strategy;
    private final transient StatisticsManager statistics = new StatisticsManager();
    private final String playerTankName;

    public Player(PlayStrategy strategy, String playerTankName) {
        this.strategy = strategy;
        this.playerTankName = playerTankName;
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
}
