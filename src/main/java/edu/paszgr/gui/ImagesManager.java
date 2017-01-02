package edu.paszgr.gui;

import edu.paszgr.board.Field;
import edu.paszgr.board.fields.NeutralField;
import edu.paszgr.board.fields.SandField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImagesManager {
    private static final Map<Class<? extends Field>, Image> fieldImagesMap = new HashMap<>();

    private static BufferedImage tankDefault = null;
    private static BufferedImage fieldDefault = null;
    private static BufferedImage fieldNull = null;

    static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image getFieldImage(Class<? extends Field> fieldClass) {
        if (fieldClass == null) {
            return fieldNull;
        }
        Image result = fieldImagesMap.get(fieldClass);
        if (result == null) {
            return fieldDefault;
        }
        return result;
    }

    public static Image getTankImage(Color tankColor) {
        ColorModel colorModel = tankDefault.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = tankDefault.copyData(null);

        BufferedImage result = new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);

        int width = result.getWidth();
        int height = result.getHeight();
        int minX = result.getMinX();
        int minY = result.getMinY();
        int tankColorRGB = tankColor.getRGB();
        for (int x = minX; x < minX + width; x++) {
            for (int y = minY; y < minY + height; y++) {
                if (result.getRGB(x, y) == GUIConstants.RESOURCE_TANK_DEFAULT_TEMP_COLOR.getRGB()) {
                    result.setRGB(x, y, tankColorRGB);
                }
            }
        }

        return result;
    }

    private static void init() throws IOException {
        tankDefault = readImage(GUIConstants.RESOURCE_TANK_DEFAULT);
        fieldNull = readImage(GUIConstants.RESOURCE_FIELD_NULL);
        fieldDefault = readImage(GUIConstants.RESOURCE_FIELD_DEFAULT);

        fieldImagesMap.put(
                SandField.class,
                readImage(GUIConstants.RESOURCE_FIELD_SAND)
        );

        fieldImagesMap.put(
                NeutralField.class,
                readImage(GUIConstants.RESOURCE_FIELD_NEUTRAL)
        );
    }

    private static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(
                ImagesManager.class.getClassLoader().getResourceAsStream(path)
        );
    }
}
