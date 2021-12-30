package main.game.response;

import java.util.List;

public class GameResponse {
    private List<TileResponse> tiles;
    private EntityResponse entities;

    public GameResponse(EntityResponse entities, List<TileResponse> tiles) {
        this.entities = entities;
        this.tiles = tiles;
    }

    public EntityResponse getEntities() {
        return this.entities;
    }

    public List<TileResponse> getTiles() {
        return this.tiles;
    }
}
