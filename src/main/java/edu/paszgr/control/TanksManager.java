package edu.paszgr.control;

import edu.paszgr.algo.algorithms.DefaultAlgorithm;
import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;
import edu.paszgr.board.Board;

import java.util.ArrayList;
import java.util.List;

public class TanksManager {

    public List<Tank> createTanks(Board board) {
        List<Tank> tanks = new ArrayList<>();
        tanks.add(new Tank(new OnlyMoveAlgorithm(), board, "M1 Abrams"));
        tanks.add(new Tank(new OnlyMoveAlgorithm(), board, "Tiger"));
        return tanks;
    }

}
