package edu.paszgr.control.managers;

import edu.paszgr.algo.algorithms.DefaultAlgorithm;
import edu.paszgr.board.Board;
import edu.paszgr.control.Tank;
import edu.paszgr.control.TanksManager;

import java.util.LinkedList;
import java.util.List;

public class DefaultTankManager implements TanksManager {

    @Override
    public List<Tank> createTanks(Board board) {
        List<Tank> tanks = new LinkedList<Tank>();

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
