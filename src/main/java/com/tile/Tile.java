package com.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.entity.Entity;
import com.game.GamePanel;
import com.object.SuperObject;

public class Tile {

    public BufferedImage image;
    public boolean collision = false;
    public int mapTileNum = 0;
    int x, y;
    public int worldX, worldY, screenX, screenY;
    Entity entity = null;
    SuperObject object = null;

    // Main constructor
    public Tile(BufferedImage image, int mapTileNum, int x, int y) {
        this.image = image;
        this.mapTileNum = mapTileNum;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setObject(SuperObject object) {
        this.object = object;
    }

    public SuperObject getObject() {
        return object;
    }

    // Empty constructor
    public Tile() {

    }

    @Override
    public String toString() {

        String out = "x:" + x + " y:" + y + " mapTileNum:" + mapTileNum;

        if (entity != null) {
            out += " entity:" + entity.toString();
        }

        if (object != null) {
            out += " object:" + object.toString();
        }
        return out;
    }

}
