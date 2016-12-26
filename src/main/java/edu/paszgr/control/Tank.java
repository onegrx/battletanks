package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;

import java.awt.*;
import java.io.Serializable;

public class Tank implements Serializable {
    private final transient StateInfo stateInfo;
    private int lifePoints = 1;
    private Position position = null;
    private final Player player;
    private Color color;

    public Tank(Player player, Board board) {
        this.player = player;
        this.stateInfo = new StateInfo(this, board);
    }

    public Tank(Player player, Board board, int lifePoints, Position position, Color color) {
        this(player, board);
        this.lifePoints = lifePoints;
        this.position = position;
        this.color = color;
    }

    public StateInfo getStateInfo() {
        return stateInfo;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public String getTankName() {
        return this.player.getPlayerTankName();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isAlive() {
        return lifePoints > 0;
    }

    public Player getPlayer() {
        return player;
    }
}
