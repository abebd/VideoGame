package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.entity.Player;
import com.handlers.KeyHandler;
import com.handlers.MouseHandler;
import com.object.SuperObject;
import com.tile.Tile;
import com.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 2;

    public final int tileSize = originalTileSize * scale; // 48x48
    public final int maxScreenCol = 26;
    public final int maxScreenRow = 18;
    public int screenWidth = tileSize * maxScreenCol; // 1248
    public int screenHeight = tileSize * maxScreenRow; // 846

    // WORLD SETTINGS
    public final int maxWorldCol = 26; // 100; // 26 original
    public final int maxWorldRow = 18;// 100; // 18 original
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // CAMERA
    public int shiftX, shiftY;
    public int currentMouseX, currentMouseY;

    // FPS
    public int FPS = 60;
    public int drawCount; // used as tickrate for now

    InformationPanel infoPanel;

    // OBJECT MANAGERS
    TileManager tileM = new TileManager(this);
    WorldObject worldObj = new WorldObject(this, tileM);

    // HANDLERS
    KeyHandler keyH = new KeyHandler(this);
    MouseHandler mouseH = new MouseHandler(this, tileM);

    Thread gameThread;

    // PLAYER
    public Player player = new Player(this, keyH, mouseH, tileM);

    // IDK
    public SuperObject obj[] = new SuperObject[10];

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                currentMouseX = e.getX();
                currentMouseY = e.getY();
            }
        });

    }

    public void setInformationPanel(InformationPanel infoPanel) {
        this.infoPanel = infoPanel;
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

    public void shiftTiles(int x, int y) {
        // Acts as a camera, shifts the coordinates of each tile one tileSize (unit) in
        // the given direction
        // I.e, if shiftX = 1 move +1 tileSize length (unit) to the right

        for (int i = 0; i < tileM.mapTiles.length; i++) {
            for (int j = 0; j < tileM.mapTiles[i].length; j++) {

                if (shiftX != 0 || shiftY != 0) {
                    System.out.printf("moving x%d y%d\n", shiftX, shiftY);
                }

                if (x > 0) {

                    tileM.mapTiles[i][j].setX(tileM.mapTiles[i][j].getX() - x);
                    shiftX = 0;

                } else if (x < 0) {
                    tileM.mapTiles[i][j].setX(tileM.mapTiles[i][j].getX() - x);
                    shiftX = 0;
                }

                if (y > 0) {
                    tileM.mapTiles[i][j].setY(tileM.mapTiles[i][j].getY() - y);
                    shiftY = 0;
                } else if (y < 0) {
                    tileM.mapTiles[i][j].setY(tileM.mapTiles[i][j].getY() - y);
                    shiftY = 0;
                }

            }
        }
    }

    public void update() {

        // Update player? :D
        player.update();

        // Update the world
        shiftTiles(shiftX, shiftY);

        if (mouseH.isPressed) {
            // System.out.println("DOwn!!!!!");
            // System.out.printf("%d %d\n", mouseH.lastMouseX, mouseH.lastMouseY);
        }

        // System.out.println(FPS);

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

        // g2.fillRect(, currentMouseY, WIDTH, HEIGHT);

        tileM.draw(g2);
        worldObj.draw(g2);
        player.draw(g2);

        g2.dispose(); // Good practice to save memory
    }

    public void shiftCamera(int i, int j) {

    }

}
