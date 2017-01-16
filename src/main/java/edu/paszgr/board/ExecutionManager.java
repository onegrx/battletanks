package edu.paszgr.board;

import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.TankActionVisitor;
import edu.paszgr.algo.WeaponFireVisitor;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.algo.actions.weapons.MineWeaponFire;
import edu.paszgr.algo.actions.weapons.MissileWeaponFire;
import edu.paszgr.algo.actions.weapons.TankPiercingWeaponFire;
import edu.paszgr.control.GameInfoLogger;
import edu.paszgr.control.RoundStatistics;
import edu.paszgr.control.Tank;

public class ExecutionManager implements TankActionVisitor, WeaponFireVisitor {
    private Tank currentTank = null;
    private Board board = null;
    private int roundNumber = -1;
    private GameInfoLogger logger;
    private TankDispatchedEntity entity = null;

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
        TankDispatchedEntity entity = new TankDispatchedEntity(weaponFire, currentTank, currentTank.getPosition());
        currentTank.getEntities().add(entity);
        handleTankDispatchedEntity(entity, roundNumber);
//        Position position = currentTank.getPosition();
//        List<Tank> onTargetLine = board.getTanksOnTargetLine(position, weaponFire.getDirection());
//
//        logger.log("Tank " + currentTank.getTankName() + " has already fired in direction: " + weaponFire.getDirection().toString());
//
//        onTargetLine.forEach(tank -> {
//            logger.log("Tank " + tank.getTankName() + " fragged");
//            tank.getPlayer().getStatistics().getStatisticsForRound(roundNumber).setLifePointsLeft(0);
//        });
//
//        onTargetLine.forEach(tank -> tank.setLifePoints(tank.getLifePoints() - 1));
//
//        RoundStatistics statistics = currentTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber);
//
//        statistics.setKills(statistics.getKills() + onTargetLine.size());
//        statistics.setShots(statistics.getShots() + 1);
    }

    public void handleTankDispatchedEntity(TankDispatchedEntity entity, int roundNumber) {
        this.roundNumber = roundNumber;
        this.entity = entity;
        entity.getSourceAction().acceptWeaponFireVisitor(this);
    }

    @Override
    public void visitLaserWeaponFire(LaserWeaponFire laserWeaponFire) {
        TankDispatchedEntity entity = this.entity;
        Tank sourceTank = entity.getSourceTank();
        // TODO
    }

    @Override
    public void visitMissileWeaponFire(MissileWeaponFire missileWeaponFire) {
        // TODO
    }

    @Override
    public void visitTankPiercingWeaponFire(TankPiercingWeaponFire tankPiercingWeaponFire) {
        // TODO
    }

    @Override
    public void visitMineWeaponFire(MineWeaponFire mineWeaponFire) {
        // TODO
    }
}
