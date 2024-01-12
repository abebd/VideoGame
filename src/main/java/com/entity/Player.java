package com.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ability.*;
import com.game.GamePanel;
import com.handlers.KeyHandler;
import com.handlers.MouseHandler;
import com.tile.Tile;
import com.tile.TileManager;

import config.Config;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    MouseHandler mouseH;
    TileManager tileM;

    public final int screenX;
    public final int screenY;

    public Ability[] actionBar = new Ability[9];

    public Player(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, TileManager tileM) {
        // Constructor

        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        this.tileM = tileM;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        setDefaultValues();
    }

    public void castSpell() {
        // Bad code since everything is hard coded
    }

    public void setMyTile(Tile newTile) {
        this.myTile = newTile;
    }

    public void setDefaultValues() {
        // Set player's default values

        // Starting position and speed
        /*
         * worldX = gp.tileSize * 10;
         * worldY = gp.tileSize * 10;
         * speed = 4;
         * direction = "down";
         */

        myTile = tileM.getTileAtPosition(150, 150);
        myTile.setEntity(this);

        // Blinking border around player
        hasBlinkingBorder = true;

        // Abilities
        actionBar[0] = new ABLTY_Blink();
        actionBar[1] = new ABLTY_Fireball();

    }

    public void update() {

        Tile tileNorth, tileNorthEast, tileEast, tileSouthEast, tileSouth, tileSouthWest, tileWest, tileNorthWest;

        Tile oldTile = this.myTile; // Needed?
        Tile newTile;

        // Get the tiles surrounding the player
        tileNorth = tileM.getTileAtPosition(myTile.getX() + (gp.tileSize), myTile.getY());
        // tileEastNorth = tileM.getTileAtPosition(myTile.x + (gp.tileSize), myTile.y);
        tileEast = tileM.getTileAtPosition(myTile.getX() + (gp.tileSize * 2), myTile.getY() + (gp.tileSize));
        // tileSouthEast = tileM.getTileAtPosition(myTile.x + (gp.tileSize * 2),
        // myTile.y + (gp.tileSize * 2));
        tileSouth = tileM.getTileAtPosition(myTile.getX() + (gp.tileSize), myTile.getY() + (gp.tileSize * 2));
        tileSouthWest = tileM.getTileAtPosition(myTile.getX(), myTile.getY() + (gp.tileSize * 2));
        tileWest = tileM.getTileAtPosition(myTile.getX(), myTile.getY() + gp.tileSize);
        tileNorthWest = tileM.getTileAtPosition(myTile.getX(), myTile.getY());

        if (gp.drawCount == 1) {
            toggleBorderVisibility();
        }

        /*
         * OLD MOVEMENT
         * if (playerCanMoveHere(tileNorth)) {
         * myTile.setEntity(null);
         * myTile = tileNorth;
         * tileNorth.setEntity(this);
         * 
         * System.out.println("Moved to tile " + myTile.toString());
         * }
         */

        // Movement
        if (keyH.upPressed == true) {
            direction = "up";

            moveTiles(myTile, tileNorth);
            keyH.upPressed = false;

        } else if (keyH.downPressed == true) {
            direction = "down";

            moveTiles(myTile, tileSouth);
            keyH.downPressed = false;

        } else if (keyH.leftPressed == true) {
            direction = "left";

            moveTiles(myTile, tileWest);
            keyH.leftPressed = false;

        } else if (keyH.rightPressed == true) {
            direction = "right";

            moveTiles(myTile, tileEast);
            keyH.rightPressed = false;

        }
    }

    public void moveTiles(Tile oldTile, Tile newTile) {

        if (playerCanMoveHere(newTile)) {

            oldTile.setEntity(null);
            myTile = newTile;
            newTile.setEntity(this);

            keyH.upPressed = false;
            System.out.println("Moved to tile " + myTile.toString());
        }
    }

    public boolean playerCanMoveHere(Tile tile) {
        if (Config.DEBUG_MODE && Config.DEBUG_PRINT_PLAYER_MOVEMENT) {
            System.out.println("Checking tile: " + tile.toString());
        }

        // No object or entity exist, so just walk through
        if (tile.getObject() == null && tile.getEntity() == null) {
            return true;
        }
        if (tile.getObject().hasCollision == true) {
            System.out.println("Can not move here since object has collision");
            return false;
        }

        if (tile.getEntity() != null) {
            System.out.println("Can not move here since entity already taken this slot");
            return false;
        }
        return true;
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/ugly_face.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        /*
         * if (isBorderVisible() && hasBlinkingBorder()) {
         * // Draw border
         * g2.setColor(Color.decode("#DCD01C"));
         * g2.drawLine(myTile.getX() + gp.tileSize, myTile.getY(), myTile.getX(),
         * myTile.getY());
         * g2.drawLine(myTile.getX(), myTile.getY(), myTile.getX(), myTile.getY() +
         * gp.tileSize);
         * g2.drawLine(myTile.getX() + gp.tileSize, myTile.getY() + gp.tileSize,
         * myTile.getX() + gp.tileSize,
         * myTile.getY());
         * g2.drawLine(myTile.getX() + gp.tileSize, myTile.getY() + gp.tileSize,
         * myTile.getX(),
         * myTile.getY() + gp.tileSize);
         * }
         */

        drawBorder(g2, gp);

        getPlayerImage();
        BufferedImage image = null;

        // Add direction

        image = up1;

        g2.drawImage(image, myTile.getX(), myTile.getY(), gp.tileSize, gp.tileSize, null);

        // g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    @Override
    public String toString() {
        return "player";
    }
}

/*
 * unecessarily complicated movement
 * if (keyH.upPressed == true && keyH.ticksSinceLastMove >= keyH.cooldownTicks)
 * {
 * y -= speed;
 * keyH.upPressed = false;
 * keyH.ticksSinceLastMove = 0;
 * 
 * } else if (keyH.downPressed == true && keyH.ticksSinceLastMove >=
 * keyH.cooldownTicks) {
 * y += speed;
 * keyH.downPressed = false;
 * keyH.ticksSinceLastMove = 0;
 * 
 * } else if (keyH.leftPressed == true && keyH.ticksSinceLastMove >=
 * keyH.cooldownTicks) {
 * x -= speed;
 * keyH.leftPressed = false;
 * keyH.ticksSinceLastMove = 0;
 * 
 * } else if (keyH.rightPressed == true && keyH.ticksSinceLastMove >=
 * keyH.cooldownTicks) {
 * x += speed;
 * keyH.rightPressed = false;
 * keyH.ticksSinceLastMove = 0;
 * }
 * keyH.ticksSinceLastMove++;
 */