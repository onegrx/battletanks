package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.control.Tank;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private BoardSize boardSize = null;
    private List<Tank> tanks = null;

    public Board(BoardSize boardSize, List<Tank> tanks) {
        this.boardSize = boardSize;
        this.tanks = tanks;
    }


    public List<Tank> getTanksOnPosition(Position position) {
        // TODO
        return null;
    }

    /**
     * @return  List of consecutive tanks on a path
     *          from given position (inclusively)
     *          and along the direction until the end of board
     * */
    public List<Tank> getTanksOnTargetLine(Position position, Direction direction) {
        // TODO
        return null;
    }

    public Position getPositionOfTank(Tank tank) {
        return tank.getPosition();
    }

    public List<Tank> getAllTanks() {
        // TODO
        return null;
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }
}
