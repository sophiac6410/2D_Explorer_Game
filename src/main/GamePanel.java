package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.game.GameController;
import main.game.response.EntityResponse;
import main.game.response.GameResponse;
import main.game.response.TileResponse;

import java.util.List;

public class GamePanel extends JPanel implements Runnable { 
    /**
     * screen settings
     */
    private final int originalTileSize = 16; //16x16 tile
    private final int scale = 3;
    private final int tileSize = originalTileSize * scale; // 48x48 tile
    
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;

    private final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    private final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    // // WORLD SETTINGS
    // private final int maxWorldCol = 50;
    // private final int maxWorldRow = 50;

    // FPS
    int FPS = 60;

    GameController gc = new GameController(screenWidth, screenHeight, tileSize);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // keeps program running until you stop the game
    

    /**
     * constructor for game panel
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // will automatically call the run method
    }

    // /**
    //  * runs the thread using sleep method
    //  * core of the game
    //  */
    // @Override
    // public void run() {
    //     double drawInterval = 1000000000/FPS; // 1 second / 60
    //     double nextDrawTime = System.nanoTime() + drawInterval; // current system time in nano seconds + drawInterval
       
    //     while(gameThread != null) { // while gameThread exists

    //         // UPDATE: update information such as character position
    //         update();
    //         // DRAW: draw screen with the updated information per frame
    //         repaint();

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime /= 1000000; // convert to milliseconds
    //             if (remainingTime < 0) {
    //                 remainingTime = 0;
    //             }
    //             Thread.sleep((long)remainingTime);

    //             nextDrawTime += drawInterval; // update next draw time

    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
            
    //     } 
    // }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // 1 second / 60
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        //tileM.defaultMap();
        gc.loadMap("src/resources/maps/world_map1.txt");
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                repaint();
                delta--;
            }
        }
    }

    /**
     * draw everything on the screen
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // get responses
        GameResponse response = gc.tick(keyH.getDirection());
        List<TileResponse> tiles = response.getTiles();
        EntityResponse player = response.getEntities();
        // only draw each tile if it is visible on screen
        for (TileResponse tile : tiles) {
            if (tileInFrame(tile, player)) {
                g2.drawImage(Skins.getImage(tile.getType()), (tile.getPos().getX() * this.tileSize) - player.getWorldPos().getX() + player.getScreenPos().getX(),
                (tile.getPos().getY() * this.tileSize) - player.getWorldPos().getY() + player.getScreenPos().getY(), 
                this.tileSize, this.tileSize, null);   
            }
        }
        // draw player
        g2.drawImage(Skins.getImage(player.getType()), player.getScreenPos().getX(), player.getScreenPos().getY(), this.tileSize, this.tileSize, null);
        g2.dispose();
    }

    private boolean tileInFrame(TileResponse tile, EntityResponse player) {
        return (tile.getPos().getX() * this.tileSize) + this.tileSize > player.getWorldPos().getX() - player.getScreenPos().getX()
        && (tile.getPos().getX() * this.tileSize) - this.tileSize < player.getWorldPos().getX() + player.getScreenPos().getX()
        && (tile.getPos().getY() * this.tileSize) + this.tileSize > player.getWorldPos().getY() - player.getScreenPos().getY()
        && (tile.getPos().getY() * this.tileSize) - this.tileSize < player.getWorldPos().getY() + player.getScreenPos().getY();
    }
}
