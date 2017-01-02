package edu.paszgr.gui.components;

import edu.paszgr.board.Field;
import edu.paszgr.gui.GUIConstants;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.TankDescriptor;

import javax.swing.*;
import java.awt.*;

public class BoardVisualizationComponent extends JScrollPane {
    private final JPanel content = new JPanel();
    private BoardSquareComponent[][] squareComponents = null;

    public BoardVisualizationComponent() {
        super();
        JLabel label = new JLabel("Empty Board");
        content.add(label);
        setViewportView(content);
        setPreferredSize(GUIConstants.BOARD_PREFERRED_SIZE.getSize());
    }

    public void setFields(Field[][] fields) {
        if (fields == null) {
            throw new IllegalArgumentException("Passed null array of fields");
        }

        int xSize = fields.length;
        int ySize = fields[0].length;

        content.removeAll();
        content.setLayout(new GridLayout(ySize, xSize, 0, 0));
        setPreferredSize(
                new Dimension(
                        xSize * GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.width + getVerticalScrollBar().getMaximumSize().width,
                        ySize * GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.height + getHorizontalScrollBar().getMaximumSize().height
                )
        );

        squareComponents = new BoardSquareComponent[xSize][ySize];
        for (int y=0; y<ySize; y++) {
            for (int x=0; x<xSize; x++) {
                BoardSquareComponent squareComponent = new BoardSquareComponent(fields[x][y], null);
                squareComponents[x][y] = squareComponent;
                content.add(squareComponent);
            }
        }
    }

    public void displayGameState(GameState state) {
        if (squareComponents == null) {
            throw new IllegalStateException("Attempt to display game state without prior setting fields");
        }
        try {
            for (TankDescriptor tank : state.getAllTanks()) {
                int x = tank.getxPos();
                int y = tank.getyPos();

                BoardSquareComponent squareComponent = squareComponents[x][y];

                squareComponent.setTank(tank);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Tank position exceeds board bounds", e);
        }
    }
}
