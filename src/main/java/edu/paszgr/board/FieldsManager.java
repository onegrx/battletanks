package edu.paszgr.board;

import edu.paszgr.board.fields.NeutralField;
import edu.paszgr.board.fields.SandField;

import java.util.Random;

public class FieldsManager {

    Random rand = new Random();
    int randomNum = rand.nextInt();

    public Field[][] createFields(BoardSize boardSize) {
        Field[][] fields = new Field[boardSize.getXSize()][boardSize.getYSize()];
        for (int i = 0; i < boardSize.getXSize(); i++) {
            for (int j = 0; j < boardSize.getYSize(); j++) {
                int randomNum = rand.nextInt(10);
                if(randomNum<7)
                    fields[i][j] = new NeutralField();
                else
                    fields[i][j] = new SandField();
            }
        }
        return fields;
    }
}
