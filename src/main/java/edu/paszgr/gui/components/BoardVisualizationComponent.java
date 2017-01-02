package edu.paszgr.gui.components;

import edu.paszgr.board.Field;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.TankDescriptor;

import javax.swing.*;
import java.awt.*;

public class BoardVisualizationComponent extends JPanel {
    private BoardSquareComponent[][] squareComponents = null;
    private final JScrollPane scrollPane = new JScrollPane();

    public BoardVisualizationComponent() {
        setLayout(new BorderLayout(0, 0));
        add(scrollPane, BorderLayout.CENTER);
        JLabel label = new JLabel("Empty Board");
        scrollPane.add(label);
    }

    public void setFields(Field[][] fields) {
        if (fields == null) {
            throw new IllegalArgumentException("Passed null array of fields");
        }

        int xSize = fields.length;
        int ySize = fields[0].length;

        scrollPane.removeAll();
        scrollPane.setLayout(new GridLayout(ySize, xSize, 0, 0));

        squareComponents = new BoardSquareComponent[xSize][ySize];
        for (int y=0; y<ySize; y++) {
            for (int x=0; x<xSize; x++) {
                BoardSquareComponent squareComponent = new BoardSquareComponent(fields[x][y], null);
                squareComponents[x][y] = squareComponent;
                scrollPane.add(squareComponent);
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
