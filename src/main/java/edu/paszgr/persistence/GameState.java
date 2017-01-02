package edu.paszgr.persistence;

import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {

    private int id;
    private int roundNumber;
    private int turnNumber;
    private int tankTurnNumber;
    private TankDescriptor currentTank;
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

    public TankDescriptor getCurrentTank() {
        return currentTank;
    }

    public List<TankDescriptor> getAllTanks() {
        return allTanks;
    }

    public int getId() {
        return id;
    }

    public GameState(int id, int roundNumber, int turnNumber, int tankTurnNumber, TankDescriptor currentTank, List<TankDescriptor> allTanks) {
        this.id = id;
        this.roundNumber = roundNumber;
        this.turnNumber = turnNumber;
        this.tankTurnNumber = tankTurnNumber;
        this.currentTank = currentTank;
        this.allTanks = allTanks;
    }
}
