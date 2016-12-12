package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;

public class Tank {
    private final Player player;
    private final StateInfo stateInfo;
    private int lifePoints = 1;
    private Position position = null;

    public Tank(Player player, Board board) {
        this.player = player;
        this.stateInfo = new StateInfo(this, board);
    }

    public Tank(Player player, Board board, int lifePoints, Position position) {
        this(player, board);
        this.lifePoints = lifePoints;
        this.position = position;
    }

    public StateInfo getStateInfo() {
        return stateInfo;
    }

    public String getTankName() {
        return this.player.getPlayerTankName();
    }

    public void increaseLifePoints(int amount) {
        this.lifePoints += amount;
    }

    public void decreaseLifePoints(int amount) {

        this.lifePoints -= amount;
        player.currentRound().setLifePointsLeft(lifePoints);
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public boolean isAlive() {
        return lifePoints > 0;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Player getPlayer() {
        return player;
    }
}
