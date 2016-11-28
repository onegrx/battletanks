package edu.paszgr;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.control.GameExecutor;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        GameExecutor gameExecutor = new GameExecutor(board);
        gameExecutor.executeGame();

//        ExecutionManager executor = new ExecutionManager();
//
//        TankAction action1 = new Movement(Direction.DOWN);
//        TankAction action2 = new WeaponFire(Direction.DOWN);
//
//        executor.executeTankAction(action1, null, null);
//        executor.executeTankAction(action2, null, null);
    }
}
