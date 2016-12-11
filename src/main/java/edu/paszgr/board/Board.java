package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.control.Tank;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.Math.abs;

public class Board {
    private final BoardSize boardSize;
    private List<Tank> tanks;

    public Board(BoardSize boardSize) {
        this.boardSize = boardSize;
    }

    public List<Tank> getTanksOnPosition(Position position) {
        return this.tanks.stream()
                .filter(tank -> tank.getPosition() == position)
                .collect(Collectors.toList());
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


    public Position getPositionOfTank(Tank tank) {
        return tank.getPosition();
    }

    public List<Tank> getAllTanks() {
        return tanks;
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }
}
