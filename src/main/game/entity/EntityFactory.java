package main.game.entity;

import main.game.util.Position;

public class EntityFactory {

    public static Player createPlayer(Position worldPos, Position screenPos) {
        return new Player(worldPos, screenPos);
    }

    public static Player createPlayer(Position screenPos) {
        return new Player(new Position(50*16, 50*16), screenPos);
    }
}
