package com.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.tile.Tile;

public class OBJ_WoodenDoor extends SuperObject {

    public OBJ_WoodenDoor(Tile tile) {
        myTile = tile;

        name = "Wooden Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/object/wooden_door1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        isInteractable = false;
        hasCollision = true;

    }

    @Override
    public String toString() {
        return name;
    }

}
