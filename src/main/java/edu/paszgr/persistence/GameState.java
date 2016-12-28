package edu.paszgr.persistence;

import edu.paszgr.board.Board;
import edu.paszgr.control.Tank;

import java.io.Serializable;

public class GameState implements Serializable {
    private final int roundNumber;
    private final int turnNumber;
    private final int tankTurnNumber;
    private final Tank latestTank;
    private final Board board;


    public GameState(int roundNumber, int turnNumber, int tankTurnNumber, Tank latestTank, Board board) {
        this.roundNumber = roundNumber;
        this.turnNumber = turnNumber;
        this.tankTurnNumber = tankTurnNumber;
        this.latestTank = latestTank;
        this.board = board;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public Tank getLatestTank() {
        return latestTank;
    }

    public Board getBoard() {
        return board;
    }

    public int getTankTurnNumber() {
        return tankTurnNumber;
    }
}
