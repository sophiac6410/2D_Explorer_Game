package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.game.util.Direction;


/**
 * handles key input from user
 */
public class KeyHandler implements KeyListener {
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
        // don't use this
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // get the id of the key that is pressed
        switch (code) {
            case KeyEvent.VK_W :
                upPressed = true;
                break;
            case KeyEvent.VK_S :
                downPressed = true;
                break;
            case KeyEvent.VK_A :
                leftPressed = true;
                break;
            case KeyEvent.VK_D :
                rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // get the id of the key that is pressed
        switch (code) {
            case KeyEvent.VK_W :
                upPressed = false;
                break;
            case KeyEvent.VK_S :
                downPressed = false;
                break;
            case KeyEvent.VK_A :
                leftPressed = false;
                break;
            case KeyEvent.VK_D :
                rightPressed = false;
                break;
        }
    }

    public Direction getDirection() {
        if (upPressed) {
            return Direction.UP;
        } else if (leftPressed) {
            return Direction.LEFT;
        } else if (rightPressed) {
            return Direction.RIGHT;
        } else if (downPressed) {
            return Direction.DOWN;
        }
        return null;
    }
}
