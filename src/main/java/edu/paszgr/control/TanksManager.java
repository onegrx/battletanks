package edu.paszgr.control;

import edu.paszgr.GameConstants;
import edu.paszgr.board.Board;
import edu.paszgr.board.Position;

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
        return new Tank(
                player,
                board,
                GameConstants.INITIAL_TANK_LIFE_POINTS,
                new Position(
                        random.nextInt(board.getSize().getXSize()),
                        random.nextInt(board.getSize().getYSize())
                )
        );
    }
}