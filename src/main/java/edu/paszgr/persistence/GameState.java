package edu.paszgr.persistence;

import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {

    private int roundNumber;
    private int turnNumber;
    private int tankTurnNumber;
    private TankDescriptor currentTant;
    private List<TankDescriptor> allTanks;

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public int getTankTurnNumber() {
        return tankTurnNumber;
    }

    public TankDescriptor getCurrentTant() {
        return currentTant;
    }

    public List<TankDescriptor> getAllTanks() {
        return allTanks;
    }
}
