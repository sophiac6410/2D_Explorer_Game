package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // can close window using 'x' 
        window.setResizable(false); // window is not resizable
        window.setTitle("2D Adventure");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // fits window to gamePanel's requirements
        window.setLocationRelativeTo(null); // window will be centred on screen
        window.setVisible(true); // can see window

        gamePanel.startGameThread();
    }
}
