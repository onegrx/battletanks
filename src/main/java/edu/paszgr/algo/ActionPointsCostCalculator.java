package edu.paszgr.algo;

import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.board.Field;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;

public class ActionPointsCostCalculator implements TankActionVisitor {
    private StateInfo stateInfo = null;
    private TankActionListStateInfo currentActionListState = null;
    private TankActionListStateInfo ifExecutedActionListStateInfo = null;

    public TankActionListStateInfo getPointsCost(StateInfo info, TankAction action, TankActionListStateInfo listInfo) {
        this.stateInfo = info;
        this.currentActionListState = listInfo;
        action.accept(this);
        return ifExecutedActionListStateInfo;
    }

    @Override
    public void visitMovement(Movement movement) {
        Position targetPosition = currentActionListState.getCurrentPosition().getNeighbor(movement.getDirection());

        if (!stateInfo.positionIsValid(targetPosition)) {
            ifExecutedActionListStateInfo = new TankActionListStateInfo(
                    currentActionListState.getCurrentPosition(),
                    movement.getActionPointsBasicCost()
            );

            return;
        }

        Field targetField = stateInfo.getField(targetPosition);
        int actionPointsCost = movement.getActionPointsBasicCost() + targetField.gerEnterActionPointsCost();
        ifExecutedActionListStateInfo = new TankActionListStateInfo(
                targetPosition,
                actionPointsCost
        );
    }

    @Override
    public void visitWeaponFire(WeaponFire weaponFire) {
        ifExecutedActionListStateInfo = new TankActionListStateInfo(
                currentActionListState.getCurrentPosition(),
                weaponFire.getActionPointsBasicCost()
        );
    }
}
