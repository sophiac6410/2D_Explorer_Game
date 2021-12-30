package main.game.tile;

import main.Skins;
import main.game.util.Position;

public class Tree extends Tile {
    
    public Tree(Position pos) {
        super(pos);
        super.type = Skins.TREE;
        super.collision = true;
    }
}
