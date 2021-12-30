package main.game.tile;

import main.Skins;
import main.game.util.Position;

public class Water extends Tile {
    public Water(Position pos) {
        super(pos);
        super.type = Skins.WATER;
        super.collision = true;
    }
}
