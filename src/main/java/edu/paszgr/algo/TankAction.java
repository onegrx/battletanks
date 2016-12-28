package edu.paszgr.algo;

public interface TankAction {
    void accept(TankActionVisitor visitor);
    int getActionPointsBasicCost();
}
