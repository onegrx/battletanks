package edu.paszgr.control;

import edu.paszgr.board.Board;

import java.util.ArrayList;
import java.util.List;

public class TanksManager {
    public List<Tank> createTanks(List<Player> players, Board board) {
        List<Tank> tanks = new ArrayList<>(players.size());
        for (Player player : players) {
            tanks.add(
                    this.createTank(player, board)
            );
        }
        return tanks;
    }

    public Tank createTank(Player player, Board board) {
//        List<Tank> tanks = new ArrayList<>(players.size());
//        tanks.add(new Tank(new OnlyMoveAlgorithm(), board, "M1 Abrams"));
//        tanks.add(new Tank(new OnlyMoveAlgorithm(), board, "Tiger"));
        // TODO - create tanks and Assign them a Position!
        return null;
    }
}
