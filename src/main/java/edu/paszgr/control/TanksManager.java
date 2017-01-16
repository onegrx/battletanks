package edu.paszgr.control;

import edu.paszgr.GameConstants;
import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.board.Board;
import edu.paszgr.board.Position;
import edu.paszgr.board.TankDispatchedEntity;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TanksManager {
    Random random = new Random();

    public List<Tank> createTanks(List<Player> players, Board board) {
        return players.stream()
                .map(player -> this.createTank(player, board))
                .collect(Collectors.toList());
    }

    private Tank createTank(Player player, Board board) {
        Tank tank = new Tank(
                player,
                board,
                GameConstants.INITIAL_TANK_LIFE_POINTS,
                new Position(
                        random.nextInt(board.getSize().getXSize()),
                        random.nextInt(board.getSize().getYSize())
                )
        );

        tank.getEntities().add(
                new TankDispatchedEntity(
                        new LaserWeaponFire(Direction.DOWN),
                        tank,
                        new Position(1, 1)
                )
        );

        return tank;
    }
}