package edu.paszgr.control;

import edu.paszgr.algo.PlayStrategy;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final PlayStrategy playStrategy;
    private final String playerTankName;
    private List<RoundStatistics> statistics = new ArrayList<>();

    public Player(PlayStrategy playStrategy, String playerTankName) {
        this.playStrategy = playStrategy;
        this.playerTankName = playerTankName;
    }

    public void createRoundStatistics(int roundNumber) {
        this.statistics.add(
                new RoundStatistics(roundNumber)
        );
    }

    public RoundStatistics getRoundStatistics(int roundNumber) {

        return statistics.get(roundNumber-1);
    }

    public PlayStrategy getPlayStrategy() {
        return playStrategy;
    }

    public List<RoundStatistics> getStatistics() {
        return statistics;
    }
}
