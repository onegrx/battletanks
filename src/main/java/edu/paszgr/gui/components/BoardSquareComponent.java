package edu.paszgr.gui.components;

import edu.paszgr.board.Field;
import edu.paszgr.control.Tank;

import javax.swing.*;
import java.awt.*;

public class BoardSquareComponent extends JComponent {
    private Tank tank = null;
    private Field field = null;

    public BoardSquareComponent(Field field, Tank tank) {
        this.field = field;
        this.tank = tank;
    }

    @Override
    protected void paintComponent(Graphics g) {
        paintSquareBorder(g, getSize());
        if (field != null) {
            paintField(g, getSize());
        }
        if (tank != null) {
            paintTank(g, getSize());
        }
    }

    private void paintSquareBorder(Graphics g, Dimension size) {
        // TODO
    }

    private void paintField(Graphics g, Dimension size) {
        // TODO
    }

    private void paintTank(Graphics g, Dimension size) {
        // TODO
    }


    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
        repaint();
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
        repaint();
    }
}
