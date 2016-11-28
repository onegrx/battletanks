package edu.paszgr.algo;

import edu.paszgr.board.StateInfo;

// PLAYER MUST IMPLEMENT THIS

public interface PlayStrategy {
    String getStrategyName();
    TankActionList createTankActionList(StateInfo info);
}
