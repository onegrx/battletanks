package edu.paszgr.board;

public class Position {
    private int x;
    private int y;

    private Position() {}

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
}
