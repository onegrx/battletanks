package edu.paszgr.algo.algorithms;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.PlayStrategy;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.board.StateInfo;

import java.util.Random;

/**
 * Created by onegrx on 28.11.16.
 */
public class OnlyMoveAlgorithm implements PlayStrategy {

    private Random rnd = new Random();

    @Override
    public String getStrategyName() {
        return "Only moving";
    }

    public void scheduleTankActionList(StateInfo info, TankActionList actionList) {
        Direction[] directions = Direction.values();
        actionList.addAction(new Movement(directions[rnd.nextInt(4)]));
        actionList.addAction(new LaserWeaponFire(directions[rnd.nextInt(4)]));
    }
}
