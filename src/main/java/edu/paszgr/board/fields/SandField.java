package edu.paszgr.board.fields;

import edu.paszgr.board.Field;

public class SandField implements Field {
    @Override
    public String getName() {
        return "Sand Field";
    }

    @Override
    public int gerEnterActionPointsCost() {
        return 2;
    }
}
