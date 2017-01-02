package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.control.Tank;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.Math.abs;

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
        return this.tanks.stream()
                .filter(tank -> tank.getPosition() == position)
                .collect(Collectors.toList());
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
        switch (direction) {
            case UP:
                return tanks.stream()
                        .filter(t -> t.getPosition().getX() > p.getX() && t.getPosition().getY() == p.getY())
                        .collect(Collectors.toList());
            case DOWN:
                return tanks.stream()
                        .filter(t -> t.getPosition().getX() < p.getX() && t.getPosition().getY() == p.getY())
                        .collect(Collectors.toList());
            case LEFT:
                return tanks.stream()
                        .filter(t -> t.getPosition().getY() < p.getY() && t.getPosition().getX() == p.getX())
                        .collect(Collectors.toList());
            case RIGHT:
                return tanks.stream()
                        .filter(t -> t.getPosition().getY() > p.getY() && t.getPosition().getX() == p.getX())
                        .collect(Collectors.toList());
            case UP_LEFT:
                return tanks.stream()
                        .filter(t -> t.getPosition().getX() > p.getX() && t.getPosition().getY() < p.getY())
                        .filter(t -> abs(t.getPosition().getX() - p.getX()) == abs(t.getPosition().getY() - p.getY()))
                        .collect(Collectors.toList());
            case UP_RIGHT:
                return tanks.stream()
                        .filter(t -> t.getPosition().getX() > p.getX() && t.getPosition().getY() > p.getY())
                        .filter(t -> abs(t.getPosition().getX() - p.getX()) == abs(t.getPosition().getY() - p.getY()))
                        .collect(Collectors.toList());
            case DOWN_LEFT:
                return tanks.stream()
                        .filter(t -> t.getPosition().getX() < p.getX() && t.getPosition().getY() < p.getY())
                        .filter(t -> abs(t.getPosition().getX() - p.getX()) == abs(t.getPosition().getY() - p.getY()))
                        .collect(Collectors.toList());
            case DOWN_RIGHT:
                return tanks.stream()
                        .filter(t -> t.getPosition().getX() < p.getX() && t.getPosition().getY() > p.getY())
                        .filter(t -> abs(t.getPosition().getX() - p.getX()) == abs(t.getPosition().getY() - p.getY()))
                        .collect(Collectors.toList());
            default:
                return Collections.emptyList();
        }
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
}
