package edu.paszgr.board;

import edu.paszgr.control.Tank;

import java.util.List;

public class StateInfo {
    private Tank tank;
    private Board board;

    public StateInfo(Tank tank, Board board) {
        this.tank = tank;
        this.board = board;
    }

    public List<Position> getEnemiesPositions() {
        //return board.getTankPosition(tank);
        return null;
    }

    public Position getMyTankPosition() {
        // TODO
        return null;
    }

    public BoardSize getBoardSize() {
        // TODO
        return null;
    }
}
