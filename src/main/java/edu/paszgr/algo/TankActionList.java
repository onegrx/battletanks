package edu.paszgr.algo;

import java.util.LinkedList;
import java.util.List;

public class TankActionList {
    private List<TankAction> actions = new LinkedList<>();

    public void addAction(TankAction action) {
        actions.add(action);
    }

    public List<TankAction> getActions() {
        return actions;
    }
}
