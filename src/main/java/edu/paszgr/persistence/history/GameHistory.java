package edu.paszgr.persistence.history;

import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.GameStateIterable;
import edu.paszgr.persistence.GameStateIterator;

import java.util.*;

public class GameHistory implements GameStateIterable {
    private final Map<Integer, RoundHistory> roundsHistoryMap = new HashMap<>();

    public void insertGameState(GameState state) {
        // TODO
    }

    public GameState getGameState(int roundNumber, int turnNumber, int tankTurnNumber) {
        // TODO
        return null;
    }

    @Override
    public GameStateIterator gameStateIterator() {
        return new GameHistoryGameStateIterator(this);
    }

    // TODO - implement iterator
    private class GameHistoryGameStateIterator implements GameStateIterator {
        private final GameHistory gameHistory;

        private GameHistoryGameStateIterator(GameHistory gameHistory) {
            this.gameHistory = gameHistory;
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
