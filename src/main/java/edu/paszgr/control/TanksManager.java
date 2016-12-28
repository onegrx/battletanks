package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.Position;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TanksManager {

    Random random = new Random();

    public List<Tank> createTanks(List<Player> players, Board board) {
//        Color[] colors = createColorsRange(players.size());

        // TODO - include colors assignment
//        return players.stream()
//                .map(player -> this.createTank(player, board))
//                .collect(Collectors.toList());

        return null;
    }

    private Tank createTank(Player player, Board board, Color tankColor) {
        return new Tank(
                player,
                board,
                1,
                new Position(
                        random.nextInt(board.getSize().getXSize()),
                        random.nextInt(board.getSize().getYSize())
                ),
                tankColor
        );
    }

//    private Color[] createColorsRange(int tanksNumber) {
//        // TODO - example solution to tank colors assignment problem
//        return null;
//    }
}
