package edu.paszgr.gui.components;

import javax.swing.*;

public class NumberRangeChoiceComponent extends JComboBox<Integer> {
    private int min;
    private int max;

    public NumberRangeChoiceComponent() {
        super();
        setEditable(true);
        this.min = 1;
        this.max = 1;
    }

    public NumberRangeChoiceComponent(int min, int max) {
        this();
        setDomain(min, max);
    }

    public void setDomain(int min, int max) {
        validateInterval(min, max);
        this.min = min;
        this.max = max;
        removeAllItems();
        Integer[] items = getIntervalArray(min, max);
        for (Integer item : items) {
            addItem(item);
        }
    }

    private void validateInterval(int min, int max) throws IllegalArgumentException {
        if (min > max) {
            throw new IllegalArgumentException("min value greater than the max value");
        }
    }

    private Integer[] getIntervalArray(int min, int max) {
        Integer[] items = new Integer[max - min + 1];
        for (int value = min; value <= max; value++) {
            items[value] = value;
        }
        return items;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
