package com.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.GamePanel;
import com.tile.Tile;

public class Entity {

    public int worldX, worldY;
    public int speed;

    Tile myTile;
    EntityType myType;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    boolean hasBlinkingBorder;
    boolean isBorderVisible = true;

    public void toggleBorderVisibility() {
        isBorderVisible = !isBorderVisible;
    }

    public boolean hasBlinkingBorder() {
        return hasBlinkingBorder;
    }

    public boolean isBorderVisible() {
        return isBorderVisible;
    }

    public void drawBorder(Graphics2D g2, GamePanel gp) {
        if (hasBlinkingBorder && isBorderVisible) {
            // Draw border
            g2.setColor(Color.decode("#DCD01C"));
            g2.drawLine(myTile.getX() + gp.tileSize, myTile.getY(), myTile.getX(), myTile.getY());
            g2.drawLine(myTile.getX(), myTile.getY(), myTile.getX(), myTile.getY() + gp.tileSize);
            g2.drawLine(myTile.getX() + gp.tileSize, myTile.getY() + gp.tileSize, myTile.getX() + gp.tileSize,
                    myTile.getY());
            g2.drawLine(myTile.getX() + gp.tileSize, myTile.getY() + gp.tileSize, myTile.getX(),
                    myTile.getY() + gp.tileSize);
        }
    }

    public Tile getMyTile() {
        return myTile;
    }

    public boolean isOfType(EntityType otherType) {
        if (myType == otherType) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
