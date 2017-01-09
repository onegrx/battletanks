package edu.paszgr.board;

import edu.paszgr.algo.Direction;

import java.io.Serializable;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x << 17;   // each coordinate on 17 bits
        result = result + y;
        return result;
    }

    public Position getNeighbor(Direction direction) {
        return new Position(
                x + direction.getxDirection(),
                y + direction.getyDirection()
        );
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
