package edu.paszgr.control;

import edu.paszgr.algo.algorithms.DefaultAlgorithm;
import edu.paszgr.board.Board;

import java.util.ArrayList;
import java.util.List;

public class TanksManager {
    public List<Tank> createTanks(Board board) {
        List<Tank> tanks = new ArrayList<Tank>();

        tanks.add(
                new Tank(
                        new DefaultAlgorithm(),
                        board
                )
        );

        tanks.add(
                new Tank(
                        new DefaultAlgorithm(),
                        board
                )
        );

        return tanks;
    }
}
