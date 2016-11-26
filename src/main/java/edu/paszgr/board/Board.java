package edu.paszgr.board;

import edu.paszgr.control.Tank;

import java.util.List;

public interface Board {
    void addTank();
    void removeTank(Tank tank);
    List<Tank> getTanks(Position position);
    Position getTankPosition(Tank tank);
    List<Tank> getAllTanks();
    Position getSize();
}
