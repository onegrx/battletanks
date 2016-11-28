package edu.paszgr.algo.algorithms;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.PlayStrategy;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.board.StateInfo;

/**
 * Created by onegrx on 28.11.16.
 */
public class OnlyMoveAlgorithm implements PlayStrategy {

    @Override
    public String getStrategyName() {
        return "Only moving";
    }

    @Override
    public TankActionList createTankActionList(StateInfo info) {
        TankActionList list = new TankActionList();
        list.addAction(new Movement(Direction.DOWN));
        return list;
    }
}
