package edu.paszgr.board.fields;

import edu.paszgr.board.Field;

public class NeutralField implements Field {
    @Override
    public String getName() {
        return "Neutral Field";
    }

    @Override
    public int gerEnterActionPointsCost() {
        return 0;
    }
}
