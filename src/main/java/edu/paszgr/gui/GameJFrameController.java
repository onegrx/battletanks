package edu.paszgr.gui;

import edu.paszgr.board.Field;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.GameStateIterator;
import edu.paszgr.persistence.history.GameHistory;

import java.util.ListIterator;

public class GameJFrameController {
    private final GameJFrame view;
    private GameHistory gameHistory = null;
    private GameStateIterator gameStatesIterator = null;
    private Field[][] fields = null;

    public GameJFrameController(GameJFrame view) {
        this.view = view;
    }

    public void displayGameHistory(GameHistory history) {
        // TODO
    }

    public void setBoardFields(Field[][] fields) {
        // TODO
    }
}
