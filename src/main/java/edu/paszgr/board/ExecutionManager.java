package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.TankActionVisitor;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.control.GameInfoLogger;
import edu.paszgr.control.RoundStatistics;
import edu.paszgr.control.Tank;

import java.util.List;

public class ExecutionManager implements TankActionVisitor {
    private Tank currentTank = null;
    private Board board = null;
    private int roundNumber = -1;
    private GameInfoLogger logger;

    public ExecutionManager(GameInfoLogger logger) {
        this.logger = logger;
    }

    public void executeTankAction(TankAction action, Tank tank, Board board, int roundNumber) {
        this.board = board;
        this.currentTank = tank;
        this.roundNumber = roundNumber;
        action.accept(this);
    }

    @Override
    public void visitMovement(Movement movement) {
        Position oldPosition = currentTank.getPosition();

        RoundStatistics statistics = currentTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber);
        statistics.setMoves(statistics.getMoves() + 1);

        Position newPosition = oldPosition.getNeighbor(movement.getDirection());

        if (!board.positionIsValid(newPosition)) {
            newPosition = oldPosition;
        }

        currentTank.setPosition(newPosition);

        logger.log("Tank " + currentTank.getTankName() + " has already moved to ("
                + newPosition.getX() + ", " + newPosition.getY() + ")");
    }

    @Override
    public void visitWeaponFire(WeaponFire weaponFire) {
        Position position = currentTank.getPosition();
        List<Tank> onTargetLine = board.getTanksOnTargetLine(position, weaponFire.getDirection());

        logger.log("Tank " + currentTank.getTankName() + " has already fired.");
        onTargetLine.forEach(tank ->
                logger.log("Tank " + tank.getTankName() + " fragged"));

        onTargetLine.forEach(tank -> tank.setLifePoints(tank.getLifePoints() - 1));

        RoundStatistics statistics = currentTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber);

        statistics.setKills(statistics.getKills() + onTargetLine.size());
        statistics.setShots(statistics.getShots() + 1);
    }
}
