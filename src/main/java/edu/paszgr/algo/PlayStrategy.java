package edu.paszgr.algo;

import edu.paszgr.board.StateInfo;

public interface PlayStrategy {
    String getStrategyName();
    void scheduleTankActionList(StateInfo stateInfo, TankActionList actionList);
}
