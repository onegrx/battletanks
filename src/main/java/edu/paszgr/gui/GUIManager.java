package edu.paszgr.gui;

import edu.paszgr.board.Field;
//import edu.paszgr.persistence.GameHistory;

public class GUIManager {
    private GameJFrame view = null;
    private GameJFrameController controller = null;

    public void createAndShowGUI() {
        this.view = new GameJFrame();
        this.controller = new GameJFrameController(view);
        // TODO
    }

    public void setBoardFields(Field[][] fields) {
        // TODO
    }

//    public void displayGameHistory(GameHistory gameHistory) {
//        // TODO
//    }
}
