package edu.paszgr.persistence.history;

import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.GameStateIterable;
import edu.paszgr.persistence.GameStateIterator;

import java.util.*;

public class TurnHistory implements GameStateIterable {
    private final Map<Integer, GameState> tankTurnStatesMap = new HashMap<>();
    private final int turnNumber;

    public TurnHistory(int turnNumber) {
        this.turnNumber = turnNumber;
    }


    public int getTurnNumber() {
        return turnNumber;
    }

    public GameState getGameState(int tankTurnNumber) {
        // TODO
        return null;
    }

    public void insertGameState(GameState state) {
        // TODO
    }

    @Override
    public GameStateIterator gameStateIterator() {
        return new TurnHistoryListIterator(this);
    }


    // TODO - implement iterator
    private class TurnHistoryListIterator implements GameStateIterator {
        private final TurnHistory turnHistory;

        private TurnHistoryListIterator(TurnHistory turnHistory) {
            this.turnHistory = turnHistory;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public GameState next() throws NoSuchElementException {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public GameState previous() throws NoSuchElementException {
            return null;
        }

        @Override
        public boolean isReachable(GameState state) {
            return false;
        }

        @Override
        public void seekAfter(GameState state) throws NoSuchElementException {

        }
    }
}
