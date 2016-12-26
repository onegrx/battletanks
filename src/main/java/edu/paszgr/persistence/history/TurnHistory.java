package edu.paszgr.persistence.history;

import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.ListIterable;

import java.util.*;
import java.util.function.Consumer;

public class TurnHistory implements ListIterable<GameState> {
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
    public ListIterator<GameState> listIterator() {
        return new TurnHistoryListIterator(this);
    }



    // TODO - implement iterator
    private class TurnHistoryListIterator implements ListIterator<GameState> {
        private final TurnHistory turnHistory;

        public TurnHistoryListIterator(TurnHistory turnHistory) {
            this.turnHistory = turnHistory;
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
