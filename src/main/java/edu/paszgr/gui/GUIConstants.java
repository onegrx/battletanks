package edu.paszgr.gui;

import java.awt.*;

public class GUIConstants {
    public static final Rectangle GUI_SIZE = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    public static final Rectangle BOARD_SQUARE_PREFERRED_SIZE = new Rectangle(100, 100);
//    public static final Rectangle BOARD_SQUARE_
    public static final Insets BOARD_SQUARE_BORDER_INSETS = new Insets(2, 2, 2, 2);
    public static final Color BOARD_SQUARE_BORDER_COLOR = new Color(0, 0, 0);

    public static final Rectangle TANK_VISUALIZATION_PREFERRED_SIZE = new Rectangle(200, 50);

    public static final Rectangle BOARD_MAX_SIZE = GUI_SIZE;

    public static final int STRING_HEIGHT = 11;

    public static final String RESOURCE_TANK_DEFAULT = "gui/tanks/tank_transparent.png";
    public static final String RESOURCE_FIELD_DEFAULT = "gui/fields/field_default.png";

    public static final String RESOURCE_FIELD_NULL = "gui/fields/field_null.png";
    public static final String RESOURCE_FIELD_SAND = "gui/fields/field_sand.png";
    public static final String RESOURCE_FIELD_NEUTRAL = "gui/fields/field_neutral.png";

    public static final String RESOURCE_WEAPON_LASER = "gui/weapons/laser.png";
    public static final String RESOURCE_WEAPON_MINE = "gui/weapons/mine.png";
    public static final String RESOURCE_WEAPON_MISSILE = "gui/weapons/missile.png";
    public static final String RESOURCE_WEAPON_PIERCING = "gui/weapons/piercing.png";

    public static final Color RESOURCE_IMAGE_DEFAULT_TEMP_COLOR = new Color(0, 0, 0, 255);
}
