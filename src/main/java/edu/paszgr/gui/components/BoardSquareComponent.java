package edu.paszgr.gui.components;

import edu.paszgr.board.Field;
import edu.paszgr.gui.GUIConstants;
import edu.paszgr.gui.ImagesManager;
import edu.paszgr.persistence.TankDescriptor;

import javax.swing.*;
import java.awt.*;

public class BoardSquareComponent extends JComponent {
    private TankDescriptor tank = null;
    private Field field = null;

    public BoardSquareComponent(Field field, TankDescriptor tank) {
        this.field = field;
        this.tank = tank;
        setPreferredSize(GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.getSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        paintField(g, getWidth(), getHeight());
        if (tank != null) {
            paintTank(g, getWidth(), getHeight());
        }
        paintSquareBorder(g, getWidth(), getHeight());
    }

    private void paintSquareBorder(Graphics g, int width, int height) {
        g.setColor(GUIConstants.BOARD_SQUARE_BORDER_COLOR);
        
        Insets insets = GUIConstants.BOARD_SQUARE_BORDER_INSETS;

        paintSquareBorderEdge(g, 0, 0, 0, height-1, insets.left, 1, 0);
        paintSquareBorderEdge(g, width-1, 0, width-1, height-1, insets.right, -1, 0);
        paintSquareBorderEdge(g, 0, 0, width-1, 0, insets.top, 0, 1);
        paintSquareBorderEdge(g, 0, height-1, width-1, height-1, insets.bottom, 0, -1);
    }
    
    private void paintSquareBorderEdge(Graphics g, int xStart, int yStart, int xEnd, int yEnd, int lineWidth, int xVector, int yVector) {
        for (int i=0; i<lineWidth; i++) {
            int x1 = xStart + i * xVector;
            int y1 = yStart + i * yVector;
            int x2 = xEnd + i * xVector;
            int y2 = yEnd + i * yVector;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void paintField(Graphics g, int width, int height) {
        Image fieldImage = ImagesManager.getFieldImage(field.getClass());
        g.drawImage(fieldImage, 0, 0, null);
    }

    private void paintTank(Graphics g, int width, int height) {
        Image tankImage = ImagesManager.getTankImage(new Color(tank.getColor()));
        g.drawImage(tankImage, 0, 0, null);
        g.setColor(Color.black);
        g.drawString("(" + tank.getxPos() + "," + tank.getyPos() + ")", 0, GUIConstants.STRING_HEIGHT);
    }


    public TankDescriptor getTank() {
        return tank;
    }

    public void setTank(TankDescriptor tank) {
        this.tank = tank;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
