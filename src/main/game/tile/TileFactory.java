package main.game.tile;

import main.game.util.Position;

public class TileFactory {
    final static int GRASS = 0;
    final static int WALL = 1;
    final static int WATER = 2;
    final static int EARTH = 3;
    final static int TREE = 4;
    final static int SAND = 5;

    public static Tile loadFromMap(int id, int x, int y) {
        switch (id) {
            case GRASS:
                return TileFactory.createGrass(new Position(x, y));
            case WALL:
                return TileFactory.createWall(new Position(x, y));
            case WATER:
                return TileFactory.createWater(new Position(x, y));
            case EARTH:
                return TileFactory.createEarth(new Position(x, y));
            case TREE:
                return TileFactory.createTree(new Position(x, y));
            case SAND:
                return TileFactory.createSand(new Position(x, y));
            default:
                return null;
        }
    }

    public static Grass createGrass(Position pos) {
        return new Grass(pos);
    }

    public static Wall createWall(Position pos) {
        return new Wall(pos);
    }

    public static Water createWater(Position pos) {
        return new Water(pos);
    }

    public static Sand createSand(Position pos) {
        return new Sand(pos);
    }

    public static Tree createTree(Position pos) {
        return new Tree(pos);
    }

    public static Earth createEarth(Position pos) {
        return new Earth(pos);
    } 
}
