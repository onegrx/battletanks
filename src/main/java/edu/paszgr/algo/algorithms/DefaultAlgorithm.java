package edu.paszgr.algo.algorithms;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.PlayStrategy;
import edu.paszgr.algo.TankActionList;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.board.BoardSize;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;

import java.util.List;

public class DefaultAlgorithm implements PlayStrategy {
    @Override
    public String getStrategyName() {
        return "DefaultAlgorithm implementation for PlayStrategy";
    }

    @Override
    public TankActionList createTankActionList(StateInfo info) {
        TankActionList list = new TankActionList();

        Position myPosition = info.getMyTankPosition();
        List<Position> enemiesPositions = info.getEnemiesPositions();

        if (enemiesPositions.size() > 0) {
            list.addAction(
                    new WeaponFire(Direction.LEFT)
            );
            list.addAction(
                    new Movement(Direction.DOWN)
            );
        } else if (myPosition.getX() > 3) {
            list.addAction(
                    new Movement(Direction.LEFT)
            );
        } else if (myPosition.getX() <= 3) {
            list.addAction(
                    new WeaponFire(Direction.UP)
            );
        } else {
            list.addAction(
                    new WeaponFire(Direction.RIGHT)
            );
        }


        return list;
    }
}
