package edu.paszgr.control;

public class RoundStatistics {
    private int kills = 0;
    private int lifePointsLeft = -1;
    private final int roundNumber;

    public RoundStatistics(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void addKills(int killsCount) {
        this.kills += killsCount;
    }

    /**
     * @return -1 if lifePointsLeft not previously set
     * */
    public int getLifePointsLeft() {
        return lifePointsLeft;
    }

    public void setLifePointsLeft(int lifePointsLeft) {
        this.lifePointsLeft = lifePointsLeft;
    }

    public int getKills() {
        return kills;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
