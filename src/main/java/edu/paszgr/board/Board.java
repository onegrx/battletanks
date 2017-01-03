package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.control.Tank;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Board implements Serializable {
    private final transient FieldsManager fieldsManager = new FieldsManager();
    private final BoardSize size;
    private List<Tank> tanks = null;
    private transient Field[][] fields;

    public Board(BoardSize boardSize) {
        this.size = boardSize;
        this.fields = fieldsManager.createFields(boardSize);
    }

    public List<Tank> getTanksOnPosition(Position position) {
        List<Tank> tanksOnPos = new LinkedList<>();
        this.tanks.forEach(tank -> {
          if (tank.getPosition().equals(position)) {
              tanksOnPos.add(tank);
          }
        });
        return tanksOnPos;
    }

    public Position getPositionOfTank(Tank tank) {
        return tank.getPosition();
    }

    public List<Tank> getAllTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }

    /**
     * @return  List of consecutive tanks on a path
     *          from given position (inclusively)
     *          and along the direction until the end of board
     * */
    public List<Tank> getTanksOnTargetLine(Position p, Direction direction) {
        Position next = p.getNeighbor(direction);

        List<Tank> tanks = new LinkedList<>();

        while (positionIsValid(next)) {
            getTanksOnPosition(next).forEach(tanks::add);
            next = next.getNeighbor(direction);
        }

        return tanks;
    }

    public boolean positionIsValid(Position position) {
        if (position == null) {
            return false;
        }
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < size.getXSize() && y >= 0 && y < size.getYSize();
    }

    public BoardSize getSize() {
        return size;
    }

    public Field getField(Position position) {
        return fields[position.getX()][position.getY()];
    }

    public Field[][] getFields() {
        return fields;
    }
}
