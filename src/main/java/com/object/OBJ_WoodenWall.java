package com.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.tile.Tile;

public class OBJ_WoodenWall extends SuperObject {

    public OBJ_WoodenWall(Tile tile) {
        myTile = tile;

        // DESCRIPTIVE VARIABLES
        name = "Wooden Wall";
        contextMenuInteractionString = "Break";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/object/wooden_wall1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        isInteractable = true;
        hasCollision = true;

    }

    @Override
    public String toString() {
        return name;
    }

}
