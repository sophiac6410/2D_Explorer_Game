package main.game.entity;

import main.game.util.Direction;
import main.game.util.Position;

import main.Skins;
import main.game.response.EntityResponse;

public class Player extends Entity {
    int spriteNum = 1;
    int spriteCounter = 0;
    private final Position screenPos; // where player is drawn on the screen

    public Player(Position worldPos, Position screenPos) {
        super(worldPos, 4);
        super.type = Skins.PLAYER_UP_1;
        this.screenPos = screenPos;
    }

    /**
     * @param direction - direction player is moving in
     */
    public void update(Direction direction) {
        this.moveDirection(direction);
        this.changeImage(direction);
    }

    private void moveDirection(Direction direction) {
        if (direction != null) {
            for (int i = 0; i < speed; i++) {
                super.worldPos = super.worldPos.translateBy(direction);
            }
        }
    }

    /**
     * change the type/image of the player according to the direction it is moving in
     * @param direction
     */
    private void changeImage(Direction direction) {
        if (direction != null) {
            switch (direction) {
                case UP:
                    if (spriteNum == 1) {
                        super.type = Skins.PLAYER_UP_1;
                    } else if (spriteNum == 2) {
                        super.type = Skins.PLAYER_UP_2;
                    }
                    break;
                case DOWN:
                    if (spriteNum == 1) {
                        super.type = Skins.PLAYER_DOWN_1;
                    } else if (spriteNum == 2) {
                        super.type = Skins.PLAYER_DOWN_2;
                    }
                    break;
                case LEFT:
                    if (spriteNum == 1) {
                        super.type = Skins.PLAYER_LEFT_1;
                    } else if (spriteNum == 2) {
                        super.type = Skins.PLAYER_LEFT_2;
                    }
                    break;
                case RIGHT:
                    if (spriteNum == 1) {
                        super.type = Skins.PLAYER_RIGHT_1;
                    } else if (spriteNum == 2) {
                        super.type = Skins.PLAYER_RIGHT_2;
                    }
                    break;
                default:
                    break;
            }
            spriteCounter++;
            if(spriteCounter > 10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public EntityResponse getResponse() {
        return new EntityResponse(this.type, this.worldPos, this.screenPos);
    }
}