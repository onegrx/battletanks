package edu.paszgr.gui.components;

import edu.paszgr.gui.GUIConstants;
import edu.paszgr.gui.ImagesManager;
import edu.paszgr.persistence.TankDescriptor;

import javax.swing.*;
import java.awt.*;

public class TankSummaryComponent extends JComponent {
    private TankDescriptor tank = null;

    @Override
    protected void paintComponent(Graphics g) {
        if (tank != null) {
            paintTankSummary(g, getSize());
        } else {
            paintTankNotSet(g, getSize());
        }
    }

    private void paintTankSummary(Graphics g, Dimension size) {
        g.setColor(Color.BLACK);
        g.drawString("Last tank:", 0 ,0);

        Image tankImage = ImagesManager.getTankImage(new Color(tank.getColor()));
        g.drawImage(
                tankImage,
                GUIConstants.TANK_VISUALIZATION_PREFERRED_SIZE.width
                        - GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.width,
                0,
                null
        );

        g.drawString(tank.getPlayerTankName(), 0, GUIConstants.TANK_VISUALIZATION_PREFERRED_SIZE.height/2);
    }

    private void paintTankNotSet(Graphics g, Dimension size) {
        g.setColor(Color.BLACK);
        g.drawString("No tank to describe", 0, 0);
    }

    public TankDescriptor getTank() {
        return tank;
    }

    public void setTank(TankDescriptor tank) {
        this.tank = tank;
        repaint();
    }
}
