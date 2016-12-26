package edu.paszgr.persistence.history;

import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.ListIterable;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Consumer;

public class RoundHistory implements ListIterable<GameState> {
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
    public ListIterator<GameState> listIterator() {
        return new RoundHistoryListIterator(this);
    }


    // TODO - implement iterator
    private class RoundHistoryListIterator implements ListIterator<GameState> {
        private final RoundHistory roundHistory;

        private RoundHistoryListIterator(RoundHistory roundHistory) {
            this.roundHistory = roundHistory;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public GameState next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public GameState previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super GameState> action) {

        }

        @Override
        public void set(GameState state) {

        }

        @Override
        public void add(GameState state) {

        }
    }
}
