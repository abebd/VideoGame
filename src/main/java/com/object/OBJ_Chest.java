package com.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.tile.Tile;

public class OBJ_Chest extends SuperObject {

    public OBJ_Chest(Tile tile) {
        myTile = tile;

        // DESCRIPTIVE VARIABLES
        name = "Chest";
        contextMenuInteractionString = "Open chest";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/object/chest.png"));
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
