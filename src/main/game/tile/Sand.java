package main.game.tile;

import main.Skins;
import main.game.util.Position;

public class Sand extends Tile {
    
    public Sand(Position pos) {
        super(pos);
        super.type = Skins.SAND;
    }
}
