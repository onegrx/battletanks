package edu.paszgr.control;

import edu.paszgr.board.Board;

import java.util.List;

public interface TanksManager {
    List<Tank> createTanks(Board board);
}
