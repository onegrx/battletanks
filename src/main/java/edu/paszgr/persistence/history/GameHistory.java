package edu.paszgr.persistence.history;

import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.ListIterable;

import java.util.*;

public class GameHistory implements ListIterable<GameState> {
    private final Map<Integer, RoundHistory> roundsHistoryMap = new HashMap<>();

    public void insertGameState(GameState state) {
        // TODO
    }

    public GameState getGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        // TODO
        return null;
    }

    @Override
    public ListIterator<GameState> listIterator() {
        // TODO
        return null;
    }
}
