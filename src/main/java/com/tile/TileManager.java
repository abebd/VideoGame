package com.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.entity.Entity;
import com.game.GamePanel;

public class TileManager {

    GamePanel gp;

    Tile[] tileImageList;
    int mapTileNum[][];
    public Tile[][] mapTiles;
    public Tile[][] visibleMapTiles;
    Tile currentTile;
    Tile lastOnHoverTile;

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tileImageList = new Tile[10];
        // mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        mapTiles = new Tile[gp.maxWorldCol][gp.maxWorldRow]; // This one should only keep the available

        getTileImage();
        loadMap("/map/world_floor.txt");
    }

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();
                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    int mapTileX = col * gp.tileSize;
                    int mapTileY = row * gp.tileSize;

                    Tile newTile = new Tile(null, num, mapTileX, mapTileY);
                    newTile.setColumnValue(col);
                    newTile.setRowValue(row);
                    mapTiles[col][row] = newTile;
                    // mapTiles[col][row] = new Tile(null, num, mapTileX, mapTileY);

                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTileImage() {

        try {

            // Undiscovered area
            tileImageList[0] = new Tile();
            tileImageList[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/world/undiscovered.png"));

            // Walkable area
            tileImageList[1] = new Tile();
            tileImageList[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/world/empty_74percent.png"));

            // Stone wall
            tileImageList[2] = new Tile();
            tileImageList[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/world/wall_cobble3.png"));

            // Water
            tileImageList[3] = new Tile();
            tileImageList[3].image = ImageIO.read(getClass().getResourceAsStream("/assets/world/ghetto_water1.png"));

            // Grass
            tileImageList[4] = new Tile();
            tileImageList[4].image = ImageIO.read(getClass().getResourceAsStream("/assets/world/grass.png"));

            // Sand
            tileImageList[5] = new Tile();
            tileImageList[5].image = ImageIO.read(getClass().getResourceAsStream("/assets/world/sand_mud1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        for (int col = 0; col < mapTiles.length; col++) {
            for (int row = 0; row < mapTiles[col].length; row++) {

                currentTile = mapTiles[col][row];
                currentTile.image = tileImageList[currentTile.mapTileNum].image;

                // if ((currentTile.getX() >= gp.cameraX) &&
                // (currentTile.getY() >= gp.cameraY) &&
                // (currentTile.getX() <= gp.cameraX + gp.screenHeight) &&
                // (currentTile.getY() <= gp.cameraY + gp.screenWidth)) {

                currentTile.draw(g2, gp);

                // }
            }
        }
    }

    public void updateEntityOnTile(Tile oldTile, Tile newTile, Entity e) {
        oldTile.entity = null;
        oldTile = newTile;
        newTile.entity = e;
    }

    public Tile getTileAtPosition(int x, int y) {

        for (int col = 0; col < mapTiles.length; col++) {

            int tileStartX = mapTiles[col][0].getX();
            int tileEndX = tileStartX + gp.tileSize;

            if (tileStartX <= x && x <= tileEndX) {
                for (int row = 0; row < mapTiles[col].length; row++) {

                    int tileStartY = mapTiles[col][row].getY();
                    int tileEndY = tileStartY + gp.tileSize;

                    if (tileStartY <= y && y <= tileEndY) {
                        return mapTiles[col][row];
                    }
                }
            }
        }
        return currentTile;
    }

    public void highlightAvailableTiles(Entity caster, int range) {
        Tile startingTile = caster.getMyTile();

        int minColumn = startingTile.getColumnValue() - range;
        int maxColumn = startingTile.getColumnValue() + range;
        int minRow = startingTile.getRowValue() - range;
        int maxRow = startingTile.getRowValue() + range;

        for (int col = 0; col < mapTiles.length; col++) {
            for (int row = 0; row < mapTiles[col].length; row++) {

                Tile actualTile = mapTiles[col][row];
                int actualColumn = mapTiles[col][row].getColumnValue();
                int actualRow = mapTiles[col][row].getRowValue();

                if (minColumn < actualColumn && actualColumn < maxColumn && minRow < actualRow && actualRow < maxRow
                        && !actualTile.objectOnTileHasCollision()) {

                    actualTile.setIsHighlighted(true);
                } else {
                    // Turn it off
                    actualTile.setIsHighlighted(false);
                }
            }
        }

    }

    public void setHoverOnTileAt(int x, int y) {
        Tile tile = getTileAtPosition(x, y);
        if (lastOnHoverTile != null) {
            lastOnHoverTile.setIsHover(false);
        }
        tile.setIsHover(true);
        lastOnHoverTile = tile;
    }
}

/*
 * public void draw(Graphics2D g2) {
 * 
 * int worldCol = 0;
 * int worldRow = 0;
 * 
 * int centerX = gp.player.worldX / 2;
 * int centerY = gp.player.worldY / 2;
 * 
 * int cameraX = gp.player.worldX - centerX;
 * int cameraY = gp.player.worldY - centerY;
 * 
 * while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
 * int tileNum = mapTileNum[worldCol][worldRow];
 * 
 * int worldX = worldCol * gp.tileSize;
 * int worldY = worldRow * gp.tileSize;
 * int screenX = worldX - gp.player.worldX + gp.player.screenX;
 * int screenY = worldY - gp.player.worldY + gp.player.screenY;
 * 
 * if (worldX > gp.player.worldX - gp.player.screenX &&
 * worldX < gp.player.worldX + gp.player.screenX &&
 * worldY > gp.player.worldY - gp.player.screenY &&
 * worldY < gp.player.worldY + gp.player.screenY) {
 * 
 * g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize,
 * null);
 * }
 * 
 * worldCol++;
 * 
 * if (worldCol == gp.maxWorldCol) {
 * worldCol = 0;
 * worldRow++;
 * }
 * }
 * 
 * }
 * 
 */
