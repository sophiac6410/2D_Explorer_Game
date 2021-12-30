package main.game.tile;

import main.Skins;
import main.game.util.Position;

public class Grass extends Tile {

    public Grass(Position pos) {
        super(pos);
        super.type = Skins.GRASS;
    }
}
