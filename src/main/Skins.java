package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Skins {
    public static final String EARTH = "earth";
    public static final String GRASS = "grass";
    public static final String SAND = "sand";
    public static final String TREE = "tree";
    public static final String WALL = "wall";
    public static final String WATER = "water";
    public static final String PLAYER_UP_1 = "player_up_1";
    public static final String PLAYER_UP_2 = "player_up_2";
    public static final String PLAYER_DOWN_1 = "player_down_1";
    public static final String PLAYER_DOWN_2 = "player_down_2";
    public static final String PLAYER_LEFT_1 = "player_left_1";
    public static final String PLAYER_LEFT_2 = "player_left_2";
    public static final String PLAYER_RIGHT_1 = "player_right_1";
    public static final String PLAYER_RIGHT_2 = "player_right_2";

    /**
     * skins with the paths
     */
    private static final Map<String, String> skins;
    static {
        Map<String, String> defaultSkins = new HashMap<>();
        defaultSkins.put(EARTH, "src/resources/tile/earth.png");
        defaultSkins.put(GRASS, "src/resources/tile/grass.png");
        defaultSkins.put(SAND, "src/resources/tile/sand.png");
        defaultSkins.put(TREE, "src/resources/tile/tree.png");
        defaultSkins.put(WALL, "src/resources/tile/wall.png");
        defaultSkins.put(WATER, "src/resources/tile/water.png");
        defaultSkins.put(PLAYER_UP_1, "src/resources/player/girl_up_1.png");
        defaultSkins.put(PLAYER_UP_2, "src/resources/player/girl_up_2.png");
        defaultSkins.put(PLAYER_LEFT_1, "src/resources/player/girl_left_1.png");
        defaultSkins.put(PLAYER_LEFT_2, "src/resources/player/girl_left_2.png");
        defaultSkins.put(PLAYER_RIGHT_1, "src/resources/player/girl_right_1.png");
        defaultSkins.put(PLAYER_RIGHT_2, "src/resources/player/girl_right_2.png");
        defaultSkins.put(PLAYER_DOWN_1, "src/resources/player/girl_down_1.png");
        defaultSkins.put(PLAYER_DOWN_2, "src/resources/player/girl_down_2.png");
        skins = Collections.unmodifiableMap(defaultSkins);
    }

    /**
     * skins with the buffered images
     */
    private static final Map<String, BufferedImage> images;
    static {
        Map<String, BufferedImage> defaultImages = new HashMap<>();
        try {
            defaultImages.put(EARTH, ImageIO.read(new File(skins.get(EARTH))));
            defaultImages.put(GRASS, ImageIO.read(new File(skins.get(GRASS))));
            defaultImages.put(SAND, ImageIO.read(new File(skins.get(SAND))));
            defaultImages.put(TREE, ImageIO.read(new File(skins.get(TREE))));
            defaultImages.put(WALL, ImageIO.read(new File(skins.get(WALL))));
            defaultImages.put(WATER, ImageIO.read(new File(skins.get(WATER))));
            defaultImages.put(PLAYER_UP_1, ImageIO.read(new File(skins.get(PLAYER_UP_1))));
            defaultImages.put(PLAYER_UP_2, ImageIO.read(new File(skins.get(PLAYER_UP_2))));
            defaultImages.put(PLAYER_LEFT_1, ImageIO.read(new File(skins.get(PLAYER_LEFT_1))));
            defaultImages.put(PLAYER_LEFT_2, ImageIO.read(new File(skins.get(PLAYER_LEFT_2))));
            defaultImages.put(PLAYER_RIGHT_1, ImageIO.read(new File(skins.get(PLAYER_RIGHT_1))));
            defaultImages.put(PLAYER_RIGHT_2, ImageIO.read(new File(skins.get(PLAYER_RIGHT_2))));
            defaultImages.put(PLAYER_DOWN_1, ImageIO.read(new File(skins.get(PLAYER_DOWN_1))));
            defaultImages.put(PLAYER_DOWN_2, ImageIO.read(new File(skins.get(PLAYER_DOWN_2))));
        } catch (IOException e) {
            e.printStackTrace();
        } 
        images = Collections.unmodifiableMap(defaultImages);
    }

    public static BufferedImage getImage(String type) {
        return images.get(type);
    }
}
