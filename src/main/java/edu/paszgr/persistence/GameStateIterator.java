package edu.paszgr.persistence;

import java.util.NoSuchElementException;

public interface GameStateIterator {
    /**
     * @return true - if the GameStateIterator.next method returns a not-null value without throwing an exception
     *         false - otherwise
     * */
    boolean hasNext();

    /**
     * @return  GameState - if there is a following GameState object to return
     * @throws NoSuchElementException - if there is no following GameState object
     * */
    GameState next() throws NoSuchElementException;

    /**
     * @return true - if the GameStateIterator.previous method returns a not-null value without throwing an exception
     *         false - otherwise
     * */
    boolean hasPrevious();

    /**
     * @return  GameState - if there is a previous GameState object to return
     * @throws NoSuchElementException - if there is no previous GameState object
     * */
    GameState previous() throws NoSuchElementException;

    /**
     * @return true - if the GameStateIterator.seekAfter method would execute successfully without throwing an exception
     *         false - otherwise
     * */
    boolean isReachable(GameState state);

    /**
     * Sets this GameStateIterator's current pointer after the given GameState object
     * So that this GameStateIterator.previous method will return the specified GameStateObject
     * @param state - GameState object after which this GameStateIterator's current pointer is to be set
     * @throws NoSuchElementException - if there is no such GameState object as specified
     * */
    void seekAfter(GameState state) throws NoSuchElementException;
}
