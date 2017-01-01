package edu.paszgr.gui.components;

import edu.paszgr.board.Field;
import edu.paszgr.persistence.TankDescriptor;

import javax.swing.*;
import java.awt.*;

public class BoardSquareComponent extends JComponent {
    private TankDescriptor tank = null;
    private Field field = null;

    public BoardSquareComponent(Field field, TankDescriptor tank) {
        this.field = field;
        this.tank = tank;
    }

    @Override
    protected void paintComponent(Graphics g) {
        paintSquareBorder(g, getSize());
        paintField(g, getSize());
        if (tank != null) {
            paintTank(g, getSize());
        }
    }

    private void paintSquareBorder(Graphics g, Dimension size) {
        g.drawImage(null, 1, 2, null);
        // TODO
    }

    private void paintField(Graphics g, Dimension size) {
        // TODO
    }

    private void paintTank(Graphics g, Dimension size) {
        // TODO
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
