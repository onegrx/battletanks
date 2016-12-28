package edu.paszgr.persistence.history;

import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.GameStateIterable;
import edu.paszgr.persistence.GameStateIterator;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class RoundHistory implements GameStateIterable {
    private final Map<Integer, TurnHistory> turnsHistoryMap = new HashMap<>();
    private final int roundNumber;

    public RoundHistory(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public GameState getGameState(int turnNumber, int tankTurnNumber) {
        // TODO
        return null;
    }

    public void insertGameState(GameState state) {
        // TODO
    }

    @Override
    public GameStateIterator gameStateIterator() {
        return new RoundHistoryGameStateIterator(this);
    }


    // TODO - implement iterator
    private class RoundHistoryGameStateIterator implements GameStateIterator {
        private final RoundHistory roundHistory;

        private RoundHistoryGameStateIterator(RoundHistory roundHistory) {
            this.roundHistory = roundHistory;
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
