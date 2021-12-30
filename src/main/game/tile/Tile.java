package main.game.tile;

import main.game.response.TileResponse;
import main.game.util.Position;

public abstract class Tile {
    protected boolean collision = false;
    protected String type;
    protected Position pos;

    public Tile(Position pos) {
        this.pos = pos;
    }

    public TileResponse getResponse() {
        return new TileResponse(this.type, this.pos);
    }

    public boolean hasCollision() {
        return this.collision;
    }
}
