package edu.paszgr.control;

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
        return new Tank(player, board, 1, new Position(random.nextInt(20), random.nextInt(20)));
    }
}
