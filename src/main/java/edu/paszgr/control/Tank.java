package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;
import edu.paszgr.board.TankDispatchedEntity;

import java.util.LinkedList;
import java.util.List;

public class Tank {
    private final StateInfo stateInfo;
    private int lifePoints = 1;
    private Position position = null;
    private final Player player;
    private List<TankDispatchedEntity> entities = new LinkedList<>();
    private int accumulatedActionPoints = 0;

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

    public boolean isAlive() {
        return lifePoints > 0;
    }

    public Player getPlayer() {
        return player;
    }

    public int getAccumulatedActionPoints() {
        return accumulatedActionPoints;
    }

    public void setAccumulatedActionPoints(int accumulatedActionPoints) {
        this.accumulatedActionPoints = accumulatedActionPoints;
    }

    public List<TankDispatchedEntity> getEntities() {
        return entities;
    }
}
