package edu.paszgr.gui.components;

import javax.swing.*;

public class NumberRangeChoiceComponent extends JComboBox<Integer> {
    private int min;
    private int max;

    public NumberRangeChoiceComponent() {
        super(new Integer[0]);
        setEditable(true);
        this.min = 1;
        this.max = 1;
    }

    public NumberRangeChoiceComponent(int min, int max) {
        validateInterval(min, max);
        this.min = min;
        this.max = max;
        for (int v = min; v <= max; v++) {
            addItem(new Integer(v));
        }
        setEditable(true);
    }

    public void setDomain(int min, int max) {
        // TODO
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    private void validateInterval(int min, int max) throws IllegalArgumentException {
        if (min > max) {
            throw new IllegalArgumentException("min value greater than the max value");
        }
    }

    private Integer[] getIntervalArray(int min, int max) {
        // TODO
        return null;
    }
}
