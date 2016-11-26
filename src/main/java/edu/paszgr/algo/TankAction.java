package edu.paszgr.algo;

import edu.paszgr.board.TankActionExecutor;

public interface TankAction {

    /** in order to bind every implementation of TankAction
     * to it's appropriate execution method in TankActionExecutor
     * */
    void acceptExecutor(TankActionExecutor executor);
}
