package edu.paszgr.algo;

import edu.paszgr.board.Position;

public class TankActionListStateInfo {
    private Position currentPosition;
    private int lastActionPointsCost;

    public TankActionListStateInfo(Position currentPosition, int lastActionPointsCost) {
        this.currentPosition = currentPosition;
        this.lastActionPointsCost = lastActionPointsCost;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getLastActionPointsCost() {
        return lastActionPointsCost;
    }
}
