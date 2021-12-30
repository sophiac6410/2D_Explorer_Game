package main.game.tile;

import main.Skins;
import main.game.util.Position;

public class Earth extends Tile {
    
    public Earth(Position pos) {
        super(pos);
        super.type = Skins.EARTH;
    }
}
