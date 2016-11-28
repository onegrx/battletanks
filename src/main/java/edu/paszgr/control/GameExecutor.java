package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.board.Position;

import java.util.List;
import java.util.Random;

public class GameExecutor {
    private TanksManager tanksManager = new TanksManager();
    private RoundManager roundManager;
    private Random rnd = new Random();

    public GameExecutor(Board board) {
        List<Tank> tanks = tanksManager.createTanks(board);

        this.roundManager =
                new RoundManager(tanks, board, new ExecutionManager());


        tanks.forEach(tank ->
                board.putTankOnPosition(tank, new Position(rnd.nextInt(10), rnd.nextInt(10)))
        );
    }


    public void executeGame() {
        System.out.println("Starting game.");
        while (!roundManager.gameEndReached()) {
            roundManager.executeNextRound();
        }
        System.out.println("Game ended");
    }
}
