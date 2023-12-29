package com.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.GamePanel;
import com.tile.Tile;
import com.tile.TileManager;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean hasCollision = false;
    public boolean isInteractable = false;
    public Tile myTile;
    public TileManager tileM;

    // Length of this string is crazy
    String contextMenuInteractionString = "";

    public void setObject() {

        myTile = tileM.getTileAtPosition(150, 150);
        myTile.setObject(this);

    }

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, myTile.getX(), myTile.getY(), gp.tileSize, gp.tileSize, null);
    }

    public String getContextMenuinteractionString() {
        return contextMenuInteractionString;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
