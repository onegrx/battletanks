package edu.paszgr;

import edu.paszgr.board.BoardSize;

public class GameConstants {
    public static final int ROUNDS_NUMBER = 4;
    public static final int TURNS_NUMBER_LIMIT = 100;
    public static final String FIELDS_FILE_NAME = "Fields.ser";

    public static final int STARTING_ROUND_NUMBER = 1;
    public static final int STARTING_TURN_NUMBER = 1;
    public static final int STARTING_TANK_TURN_NUMBER = 1;

    public static final BoardSize BOARD_SIZE_DEFAULT = new BoardSize(8, 8);

    public static final int ACTION_POINTS_PER_TURN = 10;
    public static final int INITIAL_TANK_LIFE_POINTS = 30;
}
