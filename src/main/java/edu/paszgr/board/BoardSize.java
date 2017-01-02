package edu.paszgr.board;

import java.io.Serializable;

public class BoardSize implements Serializable {
    private final int xSize;
    private final int ySize;

    public BoardSize(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    @Override
    public String toString() {
        return "BoardSize(" + xSize + "," + ySize + ")";
    }
}
