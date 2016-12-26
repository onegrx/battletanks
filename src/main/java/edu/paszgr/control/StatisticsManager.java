package edu.paszgr.control;

import java.util.*;

public class StatisticsManager {
    private Map<Integer, RoundStatistics> roundStatisticsMap = new LinkedHashMap<>();

    public RoundStatistics getStatisticsForRound(int roundNumber) {
        return roundStatisticsMap.get(roundNumber);
    }

    public void setStatisticsForRound(RoundStatistics statistics, int roundNumber) {
        roundStatisticsMap.put(roundNumber, statistics);
    }

    public List<RoundStatistics> getAllRoundStatistics() {
        Collection<RoundStatistics> collectedStatistics = roundStatisticsMap.values();
        return new ArrayList<>(collectedStatistics);
    }
}
