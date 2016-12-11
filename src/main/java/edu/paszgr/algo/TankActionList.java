package edu.paszgr.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TankActionList {
    private List<TankAction> actions = new LinkedList<>();
    private int remainingActionPoints = 10;

    public void addAction(TankAction action) {
        // TODO
    }

    public List<TankAction> getActions() {
        // We must not return a reference to the actual list to be modified by the algorithm
        return new ArrayList<>(actions);
    }

    public int getRemainingActionPoints() {
        return remainingActionPoints;
    }
}
