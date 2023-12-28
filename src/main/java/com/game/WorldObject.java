package com.game;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.object.*;
import com.tile.Tile;
import com.tile.TileManager;

public class WorldObject {

    GamePanel gp;
    TileManager tileM;
    Graphics2D g2;
    Tile myTile;

    public WorldObject(GamePanel gp, TileManager tileM) {
        this.gp = gp;
        this.tileM = tileM;

        // getObjectImage();
        loadObjects("/map/object_map/world.txt");
    }

    /*
     * private void getObjectImage() {
     * try {
     * 
     * objectImageList[2] = new OBJ_WoodenWall(myTile);
     * objectImageList[2].image =
     * ImageIO.read(getClass().getResourceAsStream("/assets/object/wooden_wall1.png"
     * ));
     * 
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * 
     * }
     */

    public void draw(Graphics2D g2) {
        for (int col = 0; col < tileM.mapTiles.length; col++) {
            for (int row = 0; row < tileM.mapTiles[col].length; row++) {

                SuperObject currentObject = tileM.mapTiles[col][row].getObject();
                if (currentObject != null) {
                    currentObject.draw(g2, gp);
                }

            }
        }
    }

    public void loadObjects(String objectMap) {

        try {

            InputStream is = getClass().getResourceAsStream(objectMap);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gp.maxWorldRow; row++) {
                String line = br.readLine();
                String numbers[] = line.split(" ");

                for (int col = 0; col < gp.maxWorldCol; col++) {
                    int num = Integer.parseInt(numbers[col]);

                    if (num != 0) {
                        setObjectBasedOnIndexOnTile(tileM.mapTiles[col][row], num);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setObjectBasedOnIndexOnTile(Tile tile, int index) {

        if (index == 2) {
            tile.setObject(new OBJ_WoodenWall(tile));
        }

        if (index == 3) {
            tile.setObject(new OBJ_WoodenDoor(tile));
        }

        // Tree
        if (index == 4) {
            tile.setObject(new OBJ_Tree(tile));
        }

    }
}
