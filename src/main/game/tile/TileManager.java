package main.game.tile;

import java.util.ArrayList;
import java.util.List;

import main.game.response.TileResponse;

public class TileManager {
    List<Tile> tiles = new ArrayList<>();

    public void addTile(Tile t) {
        tiles.add(t);
    }

    public void removeTile(Tile t) {
        tiles.remove(t);
    }

    public List<TileResponse> getResponse() {
        List<TileResponse> responses = new ArrayList<>();
        for(Tile t : this.tiles) {
            responses.add(t.getResponse());
        }
        return responses;
    }
}
