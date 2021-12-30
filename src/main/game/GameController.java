package main.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import main.game.entity.EntityFactory;
import main.game.entity.Player;
import main.game.response.GameResponse;
import main.game.tile.TileFactory;
import main.game.tile.TileManager;
import main.game.util.Direction;
import main.game.util.Position;

public class GameController {
    private TileManager tileM;
    private Player player;
    private int mapRow = 0;
    private int mapCol = 0;
    private int screenWidth = 0;
    private int screenHeight = 0;
    private int tileSize = 0;

    /**
     * constructor of controller
     * creates a tile manager and the player
     * @param centreX
     * @param centreY
     */
    public GameController(int screenWidth, int screenHeight, int tileSize) {
        this.tileM = new TileManager();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.tileSize = tileSize;
    }

    /**
     * load a map from a given path
     * @pre file is a .txt file
     * @param path - path the file is in
     * @return
     */
    public GameResponse loadMap(String path) {
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            // get each row of the file (row of map)
            for (int row = 0; myReader.hasNextLine(); row++) {
                String data = myReader.nextLine();
                String numbers[] = data.split(" ");
                mapCol = numbers.length;
                // get each tile in row
                for (int col = 0; col < numbers.length; col++) {
                    // load tile 
                    this.tileM.addTile(TileFactory.loadFromMap(Integer.parseInt(numbers[col]), col, row));
                }
                // keep track of rows in map
                mapRow++;
            }
            myReader.close();
            // create player
            this.player = EntityFactory.createPlayer(new Position(mapCol/2 * this.tileSize, mapRow/2 * this.tileSize), new Position(this.screenWidth/2 - this.tileSize/2, this.screenHeight/2 - this.tileSize/2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new GameResponse(player.getResponse(), tileM.getResponse());
    }

    /**
     * tick game state
     * @param direction - direction to move player in - can be "UP", "RIGHT", "DOWN", "LEFT", or null
     * @return
     */
    public GameResponse tick(Direction direction) {
        // update player
        player.update(direction);
        return new GameResponse(player.getResponse(), tileM.getResponse());
    }
}
