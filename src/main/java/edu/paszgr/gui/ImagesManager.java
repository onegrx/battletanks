package edu.paszgr.gui;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.algo.actions.weapons.MineWeaponFire;
import edu.paszgr.algo.actions.weapons.MissileWeaponFire;
import edu.paszgr.algo.actions.weapons.TankPiercingWeaponFire;
import edu.paszgr.board.Field;
import edu.paszgr.board.fields.NeutralField;
import edu.paszgr.board.fields.SandField;

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
    private static final Map<Class<? extends Field>, BufferedImage> fieldImagesMap = new HashMap<>();
    private static final Map<String, Map<String, BufferedImage>> weaponFireImagesMap = new HashMap<>();

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

    public static BufferedImage getFieldImage(Class<? extends Field> fieldClass) {
        if (fieldClass == null) {
            return fieldNull;
        }
        BufferedImage result = fieldImagesMap.get(fieldClass);
        if (result == null) {
            return fieldDefault;
        }
        return result;
    }

    public static BufferedImage getTankImage(Color tankColor) {
        BufferedImage image = copyImage(tankDefault);
        replaceColor(image, GUIConstants.RESOURCE_TANK_DEFAULT_TEMP_COLOR, tankColor);
        return image;
    }

    public static BufferedImage getWeaponFireImage(
            String weaponFireClassName,
            Direction direction,
            int rgb) {

            Map<String, BufferedImage> weaponMap = weaponFireImagesMap.get(weaponFireClassName);
            if (weaponMap == null) {
                return weaponFireDefault;
            }

            BufferedImage result = weaponMap.get(direction.toString());
            if (result == null) {
                return weaponFireDefault;
            }

            result = copyImage(result);
            replaceColor(result, GUIConstants.RESOURCE_WEAPON_DEFAULT_TEMP_COLOR, new Color(rgb));
            System.out.println(rgb);
            return result;
    }

    public static BufferedImage resizeImage(BufferedImage image, Rectangle newSize) {
        if (image.getWidth() == newSize.width && image.getHeight() == newSize.height) {
            return image;
        }
        BufferedImage newImage = new BufferedImage(newSize.width, newSize.height, image.getType());
        Graphics2D g = newImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.drawImage(image, 0, 0, newSize.width, newSize.height, null);
        g.dispose();
        return newImage;
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

        BufferedImage missileImage = readImage(GUIConstants.RESOURCE_WEAPON_MISSILE);
        BufferedImage mineImage = readImage(GUIConstants.RESOURCE_WEAPON_MINE);
        BufferedImage piercingImage = readImage(GUIConstants.RESOURCE_WEAPON_PIERCING);
        BufferedImage laserImage = readImage(GUIConstants.RESOURCE_WEAPON_LASER);

        weaponFireImagesMap.put(MissileWeaponFire.class.getSimpleName(), getImagesDirectedMap(missileImage));
        weaponFireImagesMap.put(MineWeaponFire.class.getSimpleName(), getImagesDirectedMap(mineImage));
        weaponFireImagesMap.put(TankPiercingWeaponFire.class.getSimpleName(), getImagesDirectedMap(piercingImage));
        weaponFireImagesMap.put(LaserWeaponFire.class.getSimpleName(), getImagesDirectedMap(laserImage));
    }

    private static Map<String, BufferedImage> getImagesDirectedMap(BufferedImage image) {
        Map<String, BufferedImage> map = new HashMap<>();
        for (Direction direction : directions()) {
            map.put(direction.toString(), rotateImage(image, direction));
        }
        return map;
    }

    private static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(
                ImagesManager.class.getClassLoader().getResourceAsStream(path)
        );
    }

    private static BufferedImage rotateImage(BufferedImage bufferedImage, Direction direction) {
        if (direction == Direction.RIGHT) {
            return bufferedImage;
        }
        AffineTransform tx = new AffineTransform();
        double degrees = getDirectionDegrees(direction);
        tx.rotate(Math.toRadians(degrees), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(bufferedImage, null);
    }

    private static double getDirectionDegrees(Direction direction) {
        switch (direction) {
            case UP:
                return 270;
            case DOWN:
                return 90;
            case DOWN_LEFT:
                return 135;
            case DOWN_RIGHT:
                return 45;
            case LEFT:
                return 180;
            case RIGHT:
                return 0;
            case UP_LEFT:
                return 225;
            case UP_RIGHT:
                return 315;
        }
        return 0;
    }

    private static void replaceColor(BufferedImage image, Color replacedColor, Color newColor) {
        int width = image.getWidth();
        int height = image.getHeight();
        int minX = image.getMinX();
        int minY = image.getMinY();
        int replacedRGB = replacedColor.getRGB();
        int newRGB = new Color(newColor.getRed(), newColor.getGreen(), newColor.getBlue(), 255).getRGB();
        for (int x = minX; x < minX + width; x++) {
            for (int y = minY; y < minY + height; y++) {
                if (image.getRGB(x, y) == replacedRGB) {
                    image.setRGB(x, y, newRGB);
                }
            }
        }
    }

    private static Direction[] directions() {
        return new Direction[] {
                Direction.UP,
                Direction.DOWN,
                Direction.LEFT,
                Direction.RIGHT,
                Direction.DOWN_LEFT,
                Direction.DOWN_RIGHT,
                Direction.UP_LEFT,
                Direction.UP_RIGHT
        };
    }

    private static BufferedImage copyImage(BufferedImage image) {
        ColorModel colorModel = image.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);

        return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
    }
}
