package edu.paszgr.board;

import edu.paszgr.control.Tank;
import java.util.List;
import java.util.stream.Collectors;

public class StateInfo {
    private final Tank tank;
    private final Board board;

    public StateInfo(Tank tank, Board board) {
        this.tank = tank;
        this.board = board;
    }

    public List<Position> getEnemiesPositions() {
        return board.getAllTanks().stream()
                .filter(tankFromBoard -> tankFromBoard != tank)
                .map(Tank::getPosition)
                .collect(Collectors.toList());
    }

    public BoardSize getBoardSize() {
        return this.board.getSize();
    }

    public Position getMyTankPosition() {
        return this.tank.getPosition();
    }

    public Field getField(Position position) {
        return board.getField(position);
    }

    public boolean positionIsValid(Position position) {
        int x = position.getX();
        int y = position.getY();
        int sizex = board.getSize().getXSize();
        int sizey = board.getSize().getXSize();

        if (x < 0 || x > sizex - 1 || y < 0 || y > sizey) {
            return false;
        }
        return true;
    }
}
