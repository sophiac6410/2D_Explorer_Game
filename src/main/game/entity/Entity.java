package main.game.entity;

import main.game.util.Position;

public abstract class Entity {
    protected Position worldPos;   // where entity is on world map
    protected int speed;
    protected String type;

    public Entity(Position worldPos, int speed) {
        this.worldPos = worldPos;
        this.speed = speed;
    }
}
