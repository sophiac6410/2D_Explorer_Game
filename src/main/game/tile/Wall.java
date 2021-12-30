package main.game.tile;

import main.Skins;
import main.game.util.Position;

public class Wall extends Tile {
    public Wall(Position pos) {
        super(pos);
        super.type = Skins.WALL;
        super.collision = true;
    }
}
