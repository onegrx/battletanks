package edu.paszgr.control;

import edu.paszgr.algo.PlayStrategy;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final PlayStrategy playStrategy;
    private List<RoundStatistics> statistics = new ArrayList<>();

    public Player(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }

    public void createRoundStatistics(int roundNumber) {
        this.statistics.add(
                new RoundStatistics(roundNumber)
        );
    }

    public RoundStatistics getRoundStatistics(int roundNumber) {
        // TODO
        return null;
    }

    public PlayStrategy getPlayStrategy() {
        return playStrategy;
    }

    public List<RoundStatistics> getStatistics() {
        return statistics;
    }
}
