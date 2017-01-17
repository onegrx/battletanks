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

import java.util.List;

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

        List<TankDispatchedEntity> entities = board.getEnemiesWeaponFiresOnPosition(newPosition, currentTank);
        int damage = 0;
        for (TankDispatchedEntity entity: entities) {
            damage += entity.getSourceAction().getLifePointsDamage();
            entity.getSourceTank().getEntities().remove(entity);
        }
        currentTank.setLifePoints(currentTank.getLifePoints()- damage);
        currentTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber).setLifePointsLeft(currentTank.getLifePoints());
        if(currentTank.getLifePoints() == 0 && !entities.isEmpty()) {
            RoundStatistics statistics2 = entities.get(0).getSourceTank().getPlayer().getStatistics().getStatisticsForRound(roundNumber);
            statistics2.setKills(statistics.getKills() + 1);
            logger.log("Tank " + currentTank.getTankName() + " fragged");
        }
        else {
            logger.log("Tank " + currentTank.getTankName() + " has already moved to ("
                    + newPosition.getX() + ", " + newPosition.getY() + ")");
        }

    }

    @Override
    public void visitWeaponFire(WeaponFire weaponFire) {
        TankDispatchedEntity entity = new TankDispatchedEntity(weaponFire, currentTank, currentTank.getPosition());
        currentTank.getEntities().add(entity);
        handleTankDispatchedEntity(entity, roundNumber);
        logger.log("Tank " + currentTank.getTankName() + " has already fired in direction: " + weaponFire.getDirection().toString());
        RoundStatistics statistics = currentTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber);
        statistics.setShots(statistics.getShots() + 1);
    }

    public void handleTankDispatchedEntity(TankDispatchedEntity entity, int roundNumber) {
        this.roundNumber = roundNumber;
        this.entity = entity;
        entity.getSourceAction().acceptWeaponFireVisitor(this);
    }

    @Override
    public void visitLaserWeaponFire(LaserWeaponFire laserWeaponFire) {
        doEntityMove();
    }

    @Override
    public void visitMissileWeaponFire(MissileWeaponFire missileWeaponFire) {
        doEntityMove();
    }

    @Override
    public void visitTankPiercingWeaponFire(TankPiercingWeaponFire tankPiercingWeaponFire) {
        doEntityMove();
    }

    @Override
    public void visitMineWeaponFire(MineWeaponFire mineWeaponFire) {
        doEntityMove();
    }

    private void doEntityMove(){
        TankDispatchedEntity entity = this.entity;
        Tank sourceTank = entity.getSourceTank();
        Tank hitTank = board.moveTankDispatchedEntity(entity);
        if(hitTank!=null){
            sourceTank.getEntities().remove(entity);
            logger.log("Tank " + hitTank.getTankName() + " fragged");
            hitTank.setLifePoints(hitTank.getLifePoints() - entity.getSourceAction().getLifePointsDamage());
            hitTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber).setLifePointsLeft(hitTank.getLifePoints());
            if(hitTank.getLifePoints() == 0) {
                RoundStatistics statistics = sourceTank.getPlayer().getStatistics().getStatisticsForRound(roundNumber);
                statistics.setKills(statistics.getKills() + 1);
            }
        }
    }
}
