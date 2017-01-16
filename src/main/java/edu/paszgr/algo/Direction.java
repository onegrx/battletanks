package edu.paszgr.algo;

public enum Direction {
    LEFT(-1,0),
    RIGHT(1,0),
    UP(0,-1),
    DOWN(0,1),
    DOWN_LEFT(-1,1),
    DOWN_RIGHT(1,1),
    UP_LEFT(-1,-1),
    UP_RIGHT(1,-1);

    private final int xDirection;
    private final int yDirection;

    Direction(int xDirection, int yDirection) {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    @Override
    public String toString() {
        return "xDirection=" + xDirection +
                ", yDirection=" + yDirection;
    }

    public static Direction get(int x, int y) {
        for(Direction d : Direction.values()) {
            if(d.getxDirection() == x && d.getyDirection() == y) {
                return d;
            }
        }
        return null;
    }
}
