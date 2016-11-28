package edu.paszgr.board;

import edu.paszgr.control.Tank;

import java.util.List;
import java.util.Map;

public class Board {
    private BoardSize size;
    private Map<Position, List<Tank>> postionTanksMap;
    private Map<Tank, Position> tankPositionMap;

    public void addTank(Tank tank, Position position) {
        // TODO
    }

    public void removeTank(Tank tank) {
        // TODO
    }

    // !!! Important: Needs to return a copy of the internally stored list because the
    // caller of that method may apply any modifications to the returned list
    public List<Tank> getTanks(Position position) {
        // TODO
        return null;
    }

    public Position getTankPosition(Tank tank) {
        // TODO
        return null;
    }

    // !!! Important: Needs to return a copy of the internally stored list because the
    // caller of that method may apply any modifications to the returned list
    public List<Tank> getAllTanks() {
        // TODO
        return null;
    }

    public Position getSize() {
        // TODO
        return null;
    }
}
