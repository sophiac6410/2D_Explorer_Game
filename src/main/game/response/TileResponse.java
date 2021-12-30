package main.game.response;

import main.game.util.Position;

public class TileResponse {
    private String type;
    private Position pos;

    public TileResponse(String type, Position pos) {
        this.type = type;
        this.pos = pos;
    }
    
    public String getType() {
        return this.type;
    }
    public Position getPos() {
        return this.pos;
    }
}
