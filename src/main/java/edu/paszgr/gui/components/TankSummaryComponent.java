package edu.paszgr.gui.components;

import edu.paszgr.control.Tank;

import javax.swing.*;
import java.awt.*;

public class TankSummaryComponent extends JComponent {
    private Tank tank = null;

    @Override
    protected void paintComponent(Graphics g) {
        if (tank != null) {
            paintTankSummary(g, getSize());
        } else {
            paintTankNotSet(g, getSize());
        }
    }

    private void paintTankSummary(Graphics g, Dimension size) {
        // TODO
    }

    private void paintTankNotSet(Graphics g, Dimension size) {
        // TODO
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
        repaint();
    }
}
