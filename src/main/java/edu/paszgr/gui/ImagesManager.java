package edu.paszgr.gui;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.board.Field;
import edu.paszgr.board.fields.NeutralField;
import edu.paszgr.board.fields.SandField;
import edu.paszgr.persistence.TankDescriptor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImagesManager {
    private static final Map<Class<? extends Field>, Image> fieldImagesMap = new HashMap<>();
    private static final Map<Class<? extends WeaponFire>, Image> weaponFireImagesMap = new HashMap<>();

    private static BufferedImage tankDefault = null;
    private static BufferedImage fieldDefault = null;
    private static BufferedImage fieldNull = null;

    private static BufferedImage weaponFireDefault = null;

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

        BufferedImage image = new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);

        replaceColor(image, GUIConstants.RESOURCE_TANK_DEFAULT_TEMP_COLOR, tankColor);

        return image;
    }

    public static Image getWeaponFireImage(
            Class<? extends WeaponFire> weaponFireClass,
            Direction direction,
            TankDescriptor sourceTank) {
return null;
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

    private static BufferedImage rotateImage(BufferedImage bufferedImage, Direction direction) {
        AffineTransform tx = new AffineTransform();
        double degrees = getDirectionDegrees(direction);
        tx.rotate(Math.toRadians(degrees), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(bufferedImage, null);
    }

    private static double getDirectionDegrees(Direction direction) {
        switch (direction) {
            case UP:
                return 90;
            case DOWN:
                return 270;
            case DOWN_LEFT:
                return 225;
            case DOWN_RIGHT:
                return 315;
            case LEFT:
                return 180;
            case RIGHT:
                return 0;
            case UP_LEFT:
                return 135;
            case UP_RIGHT:
                return 45;
        }
        return 0;
    }

    private static void replaceColor(BufferedImage image, Color replacedColor, Color newColor) {
        int width = image.getWidth();
        int height = image.getHeight();
        int minX = image.getMinX();
        int minY = image.getMinY();
        int replacedRGB = newColor.getRGB();
        int newRGB = newColor.getRGB();
        for (int x = minX; x < minX + width; x++) {
            for (int y = minY; y < minY + height; y++) {
                if (image.getRGB(x, y) == replacedRGB) {
                    image.setRGB(x, y, newRGB);
                }
            }
        }
    }
}
