package edu.paszgr.control;

import edu.paszgr.algo.TankActionList;
import edu.paszgr.board.Board;
import edu.paszgr.board.ExecutionManager;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.MongoDao;
import edu.paszgr.persistence.TankDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundManager {
    private final Board board;
    private ExecutionManager executionManager;
    private int currentTurn = 1;
    private static final int TURN_MAX = 10;
    private final String gameStateFileName;
    private GameInfoLogger logger;

    public RoundManager(Board board, ExecutionManager executionManager, String gameStateFileName, GameInfoLogger logger) {
        this.board = board;
        this.executionManager = executionManager;
        this.gameStateFileName = gameStateFileName;
        this.logger = logger;
    }

    public void executeNextRound(int roundNumber) {
        logger.log("\n *** ROUND " + roundNumber + " ***\n");
        while (!this.roundEndReached()) {
            this.executeNextTurn(roundNumber);
        }
    }

    private boolean roundEndReached() {
        int survivors = board.getAllTanks().stream()
                .filter(Tank::isAlive)
                .collect(Collectors.toList())
                .size();
        //TODO: survivors == 0 allows the only remaining tank to move and fire, even though it is alone
        //TODO: consider changing to 1
        if (survivors == 0 || currentTurn > TURN_MAX) {
            currentTurn = 1;
            return true;
        } else {
            currentTurn++;
            return false;
        }
    }

    private void executeNextTurn(int roundNumber) {
        List<Tank> tanks = board.getAllTanks();
        // tankTurnNumber is needed for the persistence of GameState
        for (int tankTurnNumber = 0; tankTurnNumber<tanks.size(); tankTurnNumber++) {
            Tank tank = tanks.get(tankTurnNumber);
            if (tank.isAlive()) {

                TankActionList actionList = new TankActionList(tank.getStateInfo(), 10);
                tank.getPlayer().getStrategy().scheduleTankActionList(tank.getStateInfo(), actionList);

                actionList.getActions().forEach(tankAction ->
                        executionManager.executeTankAction(tankAction, tank, board, roundNumber)
                );

                removeKilledTanks();

                TankDescriptor tankDescriptor = new TankDescriptor(
                    tank.getLifePoints(), tank.getPosition().getX(), tank.getPosition().getY(), tank.getTankName(), tank.getPlayer().getColor().getRGB()
                );

                List<TankDescriptor> allTanks = new ArrayList<>();

                board.getAllTanks().forEach(boardTank -> {
                    allTanks.add(new TankDescriptor(
                            boardTank.getLifePoints(), boardTank.getPosition().getX(), boardTank.getPosition().getY(), boardTank.getTankName(), boardTank.getPlayer().getColor().getRGB()
                    ));
                });

            //    GameState gameState = new GameState(roundNumber, currentTurn, tankTurnNumber, tankDescriptor, allTanks);
             //   MongoDao.saveGamestate(gameState, "col");
                // TODO - save state after each tank's actions - to this.gameStateFileName file

                //TODO !!! extract to PERSITENCE MANAGER

                //DEBUG BELOW
              //  GameState gameState1 = MongoDao.readGameState(roundNumber, currentTurn, tankTurnNumber, "col");
             //   System.out.println(gameState1.getCurrentTank().getPlayerTankName() + "HURA");
             //   System.out.println(gameState1.getCurrentTank().getxPos() + "wow");
            }
        }
        logger.log("");
    }

    private void removeKilledTanks() {
        board.getAllTanks().removeIf(tank -> !tank.isAlive());
    }
}
