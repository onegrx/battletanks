package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;

import java.util.List;

public class RoundManager {
    private List<Tank> tanks;
    private final Board board;
    private ExecutionManager executionManager;

    private int roundCount = -1;

    public RoundManager(List<Tank> tanks, Board board, ExecutionManager executionManager) {
        this.tanks = tanks;
        this.board = board;
        this.executionManager = executionManager;
    }


    public void initialize() {
        // TODO
        roundCount = 0;
    }

    public void executeNextRound() {
        // TODO
        roundCount += 1;
    }

    public boolean gameEndReached() {
        // TODO
        return false;
    }
}
