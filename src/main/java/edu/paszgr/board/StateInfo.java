package edu.paszgr.board;

import edu.paszgr.control.Tank;

import java.util.List;

public class StateInfo {
    private final Tank tank;
    private final Board board;

    public StateInfo(Tank tank, Board board) {
        this.tank = tank;
        this.board = board;
    }

    public List<Position> getEnemiesPositions() {
        // TODO
        return null;
    }

    public Position getMyTankPosition() {
        return this.tank.getPosition();
    }

    public BoardSize getBoardSize() {
        return this.board.getBoardSize();
    }
}
