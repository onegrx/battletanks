package edu.paszgr.algo;

import edu.paszgr.board.StateInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TankActionList {
    private final StateInfo stateInfo;
    private final ActionPointsCostCalculator actionPointsCalculator = new ActionPointsCostCalculator();
    private List<TankAction> actions;
    private int remainingActionPoints;
    private int initialActionPoints;
    private TankActionListStateInfo currentListStateInfo;

    public TankActionList(StateInfo stateInfo, int initialActionPoints) {
        this.stateInfo = stateInfo;
        this.initialActionPoints = initialActionPoints;
        renew();
    }

    public void addAction(TankAction action) {
        TankActionListStateInfo newState = actionPointsCalculator.getPointsCost(
                stateInfo,
                action,
                currentListStateInfo
        );
        int actionPointsCost = newState.getLastActionPointsCost();
        if (actionPointsCost <= remainingActionPoints){
            actions.add(action);
            remainingActionPoints -= actionPointsCost;
            currentListStateInfo = newState;
        }
    }

    public List<TankAction> getActions() {
        // We must not return a reference to the actual list to be modified by the algorithm
        return new ArrayList<>(actions);
    }

    public int getRemainingActionPoints() {
        return remainingActionPoints;
    }

    public void renew() {
        actions = new LinkedList<>();
        remainingActionPoints = initialActionPoints;
        currentListStateInfo = new TankActionListStateInfo(
                stateInfo.getMyTankPosition(),
                0
        );
    }
}
