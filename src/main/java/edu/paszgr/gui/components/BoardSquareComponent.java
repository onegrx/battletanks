package edu.paszgr.gui.components;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.weapons.MissileWeaponFire;
import edu.paszgr.algo.actions.weapons.TankPiercingWeaponFire;
import edu.paszgr.board.Field;
import edu.paszgr.gui.GUIConstants;
import edu.paszgr.gui.ImagesManager;
import edu.paszgr.persistence.TankDescriptor;
import edu.paszgr.persistence.TankDispatchedEntityDescriptor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class BoardSquareComponent extends JComponent {
    private TankDescriptor tank = null;
    private List<TankDispatchedEntityDescriptor> entities = new LinkedList<>();
    private Field field = null;

    public BoardSquareComponent(Field field, TankDescriptor tank) {
        this.field = field;
        this.tank = tank;
        setSize(GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.getSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        setSize(GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.getSize());
        paintField(g);
        if (tank != null) {
            paintTank(g);
        }

        if (entities.size() > 0) {
            paintWeaponFireEntities(g);
        }
        paintSquareBorder(g, getWidth(), getHeight());
    }

    private void paintWeaponFireEntities(Graphics g) {
        g.setColor(Color.black);
        g.drawString("fires: " + entities.size(),
                GUIConstants.BOARD_SQUARE_BORDER_INSETS.left + 2,
                GUIConstants.STRING_HEIGHT + GUIConstants.BOARD_SQUARE_BORDER_INSETS.top + 2);
        TankDispatchedEntityDescriptor entity = entities.get(0);
        BufferedImage image = ImagesManager.getWeaponFireImage(
                entity.getWeaponFireClassName(),
                entity.getDirection(),
                entity.getRgb()
        );
        image = ImagesManager.resizeImage(image, new Rectangle(getSize().width, getSize().height));
        g.drawImage(image, 0, 0, null);
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

    private void paintField(Graphics g) {
        BufferedImage fieldImage = ImagesManager.getFieldImage(field.getClass());
        g.drawImage(ImagesManager.resizeImage(fieldImage, new Rectangle(getSize().width, getSize().height)), 0, 0, null);
    }

    private void paintTank(Graphics g) {
        BufferedImage tankImage = ImagesManager.resizeImage(
                ImagesManager.getTankImage(new Color(tank.getColor())),
                new Rectangle(getSize().width, getSize().height)
        );
        g.drawImage(tankImage, 0, 0, null);
        g.setColor(Color.black);
        g.drawString(
                "(" + tank.getxPos() + "," + tank.getyPos() + ")",
                GUIConstants.BOARD_SQUARE_BORDER_INSETS.left + 1,
                getSize().height - GUIConstants.BOARD_SQUARE_BORDER_INSETS.bottom - 1);
        g.drawString(
                "HP: " + String.valueOf(tank.getLifePoints()),
                getSize().width - 50,
                GUIConstants.STRING_HEIGHT + GUIConstants.BOARD_SQUARE_BORDER_INSETS.top + 1
        );
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

    public List<TankDispatchedEntityDescriptor> getEntities() {
        return entities;
    }

    public void setEntities(List<TankDispatchedEntityDescriptor> entities) {
        this.entities = entities;
    }
}
