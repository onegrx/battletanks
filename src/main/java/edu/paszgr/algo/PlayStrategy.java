package edu.paszgr.algo;

import edu.paszgr.board.StateInfo;

public interface PlayStrategy {
    String getStrategyName();
    TankActionList createTankActionList(StateInfo info);
}
