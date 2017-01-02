package edu.paszgr.control;

import java.util.*;

public class StatisticsManager {
    private Map<Integer, RoundStatistics> roundStatisticsMap = new LinkedHashMap<>();

    public RoundStatistics getStatisticsForRound(int roundNumber) {
        RoundStatistics result =  roundStatisticsMap.get(roundNumber);

        if (result == null) {
            result = new RoundStatistics(roundNumber);
        }

        return result;
    }

    public void setStatisticsForRound(RoundStatistics statistics, int roundNumber) {
        roundStatisticsMap.put(roundNumber, statistics);
    }

    public List<RoundStatistics> getAllRoundStatistics() {
        Collection<RoundStatistics> collectedStatistics = roundStatisticsMap.values();
        return new ArrayList<>(collectedStatistics);
    }
}
