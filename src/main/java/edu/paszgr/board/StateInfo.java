package edu.paszgr.board;

import edu.paszgr.control.Tank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StateInfo {
    private final Tank tank;
    private final Board board;

    public StateInfo(Tank tank, Board board) {
        this.tank = tank;
        this.board = board;
    }

    public List<Position> getEnemiesPositions() {
        List<Position> positionsOfEnemies = new ArrayList<>();
        for (Tank tankFromBoard: board.getAllTanks()) {
            if(tankFromBoard!=tank){
                positionsOfEnemies.add(tankFromBoard.getPosition());
            }

        }
        return null;
    }

    public Position getMyTankPosition() {
        return this.tank.getPosition();
    }

    public BoardSize getBoardSize() {
        return this.board.getBoardSize();
    }
}
