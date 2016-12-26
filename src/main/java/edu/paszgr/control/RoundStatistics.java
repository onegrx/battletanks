package edu.paszgr.control;

public class RoundStatistics {
    private int lifePointsLeft = -1;
    private final int roundNumber;
    private int kills = 0;
    private int shots = 0;
    private int moves = 0;


    public RoundStatistics(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
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

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
}
