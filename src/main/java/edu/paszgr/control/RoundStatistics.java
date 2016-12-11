package edu.paszgr.control;

public class RoundStatistics {
    private int kills = 0;
    private int lifePointsLeft = -1;
    private final int roundNumber;
    private int shots;
    private int moves;


    public RoundStatistics(int roundNumber) {
        this.roundNumber = roundNumber;
    }


    public void addKill(int i) {
        this.kills += i;
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

    public int getShots() {
        return shots;
    }

    public void addShot() {
        this.shots++;
    }

    public int getMoves() {
        return moves;
    }

    public void addMove() {
        this.moves++;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
