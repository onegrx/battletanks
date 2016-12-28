package edu.paszgr.board;

import java.io.Serializable;

public interface Field extends Serializable {
    String getName();
    int gerEnterActionPointsCost();
}
