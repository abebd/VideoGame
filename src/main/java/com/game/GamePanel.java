package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.entity.Player;
import com.handlers.KeyHandler;
import com.handlers.MouseHandler;
import com.object.OBJ_Tree;
import com.object.SuperObject;
import com.tile.Tile;
import com.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48
    public final int maxScreenCol = 26;
    public final int maxScreenRow = 18;
    public final int screenWidth = tileSize * maxScreenCol; // 1248
    public final int screenHeigt = tileSize * maxScreenRow; // 846

    // WORLD SETTINGS
    public final int maxWorldCol = 26;
    public final int maxWorldRow = 18;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // FPS
    public int FPS = 64;
    public int drawCount; // used as tickrate for now

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    MouseHandler mouseH = new MouseHandler();
    WorldObject worldObj = new WorldObject(this, tileM);
    Thread gameThread;
    public Player player = new Player(this, keyH, mouseH, tileM);

    public SuperObject obj[] = new SuperObject[10];

    // Set player's default position
    // int playerX = 96;
    // int playerY = 96;
    // int playerSpeed = 48;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeigt));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS; // 0.033
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                // System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        player.update();
        // worldObj.update();

        if (mouseH.isClicked) {
            Tile t = tileM.getTileAtPosition(mouseH.lastMouseX, mouseH.lastMouseY);
            // JOptionPane.showMessageDialog(null, t.toString(), "Tile information",
            // JOptionPane.INFORMATION_MESSAGE);
            // t.setObject(new OBJ_Tree(t));
        }
        mouseH.isClicked = false;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        worldObj.draw(g2);
        player.draw(g2);

        g2.dispose(); // Good practice to save memory
    }

}
