package edu.paszgr.gui.components;

import edu.paszgr.board.Field;
import edu.paszgr.gui.GUIConstants;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.TankDescriptor;
import edu.paszgr.persistence.TankDispatchedEntityDescriptor;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class BoardVisualizationComponent extends JScrollPane {
    private final JPanel content = new JPanel();
    private BoardSquareComponent[][] squareComponents = null;

    public BoardVisualizationComponent() {
        super();
        JLabel label = new JLabel("Empty Board");
        content.add(label);
        setViewportView(content);
    }

    public void setFields(Field[][] fields) {
        if (fields == null) {
            throw new IllegalArgumentException("Passed null array of fields");
        }

        content.getClass();

        int xSize = fields.length;
        int ySize = fields[0].length;

        content.removeAll();
        content.setLayout(new GridLayout(ySize, xSize, 0, 0));
        Dimension preferredSize = new Dimension(
                xSize * GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.width + getVerticalScrollBar().getMaximumSize().width,
                ySize * GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.height + getHorizontalScrollBar().getMaximumSize().height
        );

        squareComponents = new BoardSquareComponent[xSize][ySize];
        for (int y=0; y<ySize; y++) {
            for (int x=0; x<xSize; x++) {
                BoardSquareComponent squareComponent = new BoardSquareComponent(fields[x][y], null);
                squareComponents[x][y] = squareComponent;
                content.add(squareComponent);
            }
        }

        int squaresWidth = xSize * GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.width;
        int squaresHeight = ySize * GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.height;
        boolean setWidth = getSize().width > squaresWidth;
        boolean setHeight = getSize().height > squaresHeight;
        if (setWidth || setHeight) {
            int width = getSize().width;
            int height = getSize().height;
            if (setHeight) {
                height = squaresHeight;
            }
            if (setWidth) {
                width = squaresWidth;
            }
            setPreferredSize(new Dimension(width, height));
        }
    }

    public void displayGameState(GameState state) {
        if (squareComponents == null) {
            throw new IllegalStateException("Attempt to display game state without prior setting fields");
        }
        try {
            resetSquareComponents();
            for (TankDescriptor tank : state.getAllTanks()) {
                for (TankDispatchedEntityDescriptor entity : tank.getEntities()) {
                    entity.setRgb(tank.getColor());
                    int x = entity.getxPos();
                    int y = entity.getyPos();
                    squareComponents[x][y].getEntities().add(entity);
                }
                int x = tank.getxPos();
                int y = tank.getyPos();

                BoardSquareComponent squareComponent = squareComponents[x][y];

                squareComponent.setTank(tank);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Tank position exceeds board bounds", e);
        }
    }

    private void resetSquareComponents() {
        if (squareComponents == null) {
            return;
        }
        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[0].length; j++) {
                squareComponents[i][j].setTank(null);
                squareComponents[i][j].setEntities(new LinkedList<>());
                repaint();
            }
        }
    }
}
