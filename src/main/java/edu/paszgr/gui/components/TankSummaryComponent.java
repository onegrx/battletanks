package edu.paszgr.gui.components;

import edu.paszgr.gui.GUIConstants;
import edu.paszgr.gui.ImagesManager;
import edu.paszgr.persistence.TankDescriptor;

import javax.swing.*;
import java.awt.*;

public class TankSummaryComponent extends JComponent {
    private TankDescriptor tank = null;

    public TankSummaryComponent() {
        setPreferredSize(GUIConstants.TANK_VISUALIZATION_PREFERRED_SIZE.getSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (tank != null) {
            paintTankSummary(g);
        } else {
            paintTankNotSet(g);
        }
    }

    private void paintTankSummary(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Last tank:", 0 , GUIConstants.STRING_HEIGHT);
        g.drawString("Life points: " + tank.getLifePoints(), 0, GUIConstants.STRING_HEIGHT*2);
        g.drawString("Position: (" + tank.getxPos() + ", " + tank.getyPos() + ")", 0, GUIConstants.STRING_HEIGHT*3);

        Image tankImage = ImagesManager.getTankImage(new Color(tank.getColor()));
        g.drawImage(
                tankImage,
                GUIConstants.TANK_VISUALIZATION_PREFERRED_SIZE.width
                        - GUIConstants.BOARD_SQUARE_PREFERRED_SIZE.width,
                0,
                null
        );

        g.drawString(tank.getPlayerTankName(), 0, GUIConstants.TANK_VISUALIZATION_PREFERRED_SIZE.height - GUIConstants.STRING_HEIGHT);
    }

    private void paintTankNotSet(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("No current tank to describe", 0, 10);
    }

    public TankDescriptor getTank() {
        return tank;
    }

    public void setTank(TankDescriptor tank) {
        this.tank = tank;
        repaint();
    }
}
