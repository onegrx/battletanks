package edu.paszgr.algo.algorithms;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.PlayStrategy;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.algo.actions.weapons.MineWeaponFire;
import edu.paszgr.algo.actions.weapons.MissileWeaponFire;
import edu.paszgr.algo.actions.weapons.TankPiercingWeaponFire;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;

public class SmartAlgorithm implements PlayStrategy {
    private boolean reachedCorner = false;

    @Override
    public String getStrategyName() {
        return "Smart strategy";
    }

    @Override
    public void scheduleTankActionList(StateInfo stateInfo, TankActionList actionList) {
        actionList.addAction(new MineWeaponFire(Direction.LEFT));
        Position myPosition = stateInfo.getMyTankPosition();
        for (Position enemy : stateInfo.getEnemiesPositions()) {
            if (enemy.getX() == myPosition.getX()) {
                if (enemy.getY() > myPosition.getY()) {
                    actionList.addAction(new TankPiercingWeaponFire(Direction.DOWN));
                } else {
                    actionList.addAction(new LaserWeaponFire(Direction.UP));
                }
            } else if (enemy.getY() == myPosition.getY()) {
                if (enemy.getX() > myPosition.getX()) {
                    actionList.addAction(new MissileWeaponFire(Direction.RIGHT));
                } else {
                    actionList.addAction(new MineWeaponFire(Direction.LEFT));
                }
            }
        }
        if (myPosition.getX() == 0 && myPosition.getY() == 0) {
            reachedCorner = true;
        } else if (myPosition.getY() == stateInfo.getBoardSize().getYSize()-1) {
            reachedCorner = false;
        }
        if (!reachedCorner) {
            if (myPosition.getX() > 0) {
                actionList.addAction(new Movement(Direction.LEFT));
            }
            if (myPosition.getY() > 0) {
                actionList.addAction(new Movement(Direction.UP));
            }
        } else {
            actionList.addAction(new Movement(Direction.DOWN));
        }
    }
}
