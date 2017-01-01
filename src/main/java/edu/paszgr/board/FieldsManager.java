package edu.paszgr.board;

import edu.paszgr.board.fields.NeutralField;

public class FieldsManager {

    public Field[][] createFields(BoardSize boardSize) {
        Field[][] fields = new Field[boardSize.getXSize()][boardSize.getYSize()];
        for (int i = 0; i < boardSize.getXSize(); i++) {
            for (int j = 0; j < boardSize.getYSize(); j++) {
                fields[i][j] = new NeutralField();
            }
        }
        return fields;
    }
}
