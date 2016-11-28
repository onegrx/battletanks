package edu.paszgr.control;

import edu.paszgr.algo.PlayStrategy;
import edu.paszgr.board.Board;
import edu.paszgr.board.StateInfo;

public class Tank {
    private final PlayStrategy strategy;
    private final StateInfo stateInfo;
    private final String tankName;

    public Tank(PlayStrategy strategy, Board board, String tankName) {
        this.strategy = strategy;
        this.stateInfo = new StateInfo(this, board);
        this.tankName = tankName;
    }

    public PlayStrategy getStrategy() {
        return strategy;
    }

    public StateInfo getStateInfo() {
        return stateInfo;
    }
}
