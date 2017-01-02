package edu.paszgr.gui;

import edu.paszgr.board.Field;
//import edu.paszgr.persistence.GameHistory;

public class GUIManager {
    private GameJFrame view = null;
    private GameJFrameController controller = null;

    public void createAndShowGUI() {
        this.view = new GameJFrame();
        this.controller = new GameJFrameController(view);
    }

    public void setBoardFields(Field[][] fields) {
        controller.setBoardFields(fields);
    }

//    public void displayGameHistory(GameHistory gameHistory) {
//        // TODO
//    }
}
