package main.game.response;

import main.game.util.Position;

public class EntityResponse {
    private String type;
    private Position worldPos;
    private Position screenPos;

    public EntityResponse(String type, Position worldPos, Position screenPos) {
        this.type = type;
        this.worldPos = worldPos;
        this.screenPos = screenPos;
    }

    public String getType() {
        return this.type;
    }
    public Position getScreenPos() {
        return this.screenPos;
    }

    public Position getWorldPos() {
        return this.worldPos;
    }
}