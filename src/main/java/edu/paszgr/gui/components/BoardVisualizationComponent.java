package edu.paszgr.gui.components;

import edu.paszgr.board.BoardSize;
import edu.paszgr.board.Field;
import edu.paszgr.persistence.GameState;

import javax.swing.*;

public class BoardVisualizationComponent extends JPanel {
    private BoardSquareComponent[][] squareComponents = null;

    public void displayEmptyBoard() {
        // TODO
    }

    public void setFields(Field[][] fields) {
        // TODO
    }

    public void displayGameState(GameState state) {
//        BoardSize boardSize = state.getBoard().getSize();
//        if (boardSize.getXSize() != squareComponents.length
//                || boardSize.getYSize() != squareComponents[0].length) {
//            throw new IllegalArgumentException("Fields size and game state boardSize mismatch");
//        }
//        // TODO
    }
}
