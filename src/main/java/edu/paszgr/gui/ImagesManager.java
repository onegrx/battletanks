package edu.paszgr.gui;

import edu.paszgr.board.Field;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImagesManager {
    private static final Map<Class<? extends Field>, Image> fieldImagesMap = new HashMap<>();
    private static final Map<Color, Image> tankColorImageMap = new HashMap<>();

    private Image tankDefault = null;

    private Image fieldDefault = null;
    private Image fieldNull = null;

    private static boolean initialized = false;


    public static Image getFieldImage(Class<? extends Field> fieldClass) {
        ensureInit();
        Image result = fieldImagesMap.get(fieldClass);

        return result;
    }

    public static Image getTankImage(Color tankColor) {
        ensureInit();
        Image result = tankColorImageMap.get(tankColor);



        return result;
    }

    private static void ensureInit() {
        if (!initialized) {
            init();
            initialized = true;
        }
    }

    private static void init() {
        // TODO
    }
}
