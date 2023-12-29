package com.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.enums.WallDirection;
import com.tile.Tile;

public class OBJ_StoneWall extends SuperObject {

    public OBJ_StoneWall(Tile tile, WallDirection givenDirection) {
        myTile = tile;

        // DESCRIPTIVE VARIABLES
        name = "Tree1";
        contextMenuInteractionString = "Break";

        image = dictateWallDirection(givenDirection);

        isInteractable = true;
        hasCollision = true;
    }

    public BufferedImage dictateWallDirection(WallDirection givenDirection) {
        String assetString = "";

        switch (givenDirection) {
            case STRAIGHT_ABOVE:
                assetString = "/assets/object/stone_wall_straight_above.png";
                break;
            case STRAIGHT_LEFT:
                assetString = "/assets/object/stone_wall_straight_left.png";
                break;
            case STRAIGHT_RIGHT:
                assetString = "/assets/object/stone_wall_straight_right.png";
                break;
            case STRAIGHT_UNDER:
                assetString = "/assets/object/stone_wall_straight_above.png"; // TODO: Add STRAIGHT_UNDER texture for
                                                                              // stone wall
                break;
            case OUTER_EDGE_LEFT:
                assetString = "/assets/object/stone_wall_outer_edge_left.png";
                break;
            case OUTER_EDGE_RIGHT:
                assetString = "/assets/object/stone_wall_outer_edge_right.png";
                break;
            case INNER_EDGE_LEFT:
                assetString = "/assets/object/stone_wall_inner_edge_left.png";
                break;
            case INNER_EDGE_RIGHT:
                assetString = "/assets/object/stone_wall_inner_edge_right.png";
                break;
            case PILLAR:
                assetString = "/assets/object/stone_wall_inner_edge_right.png"; // TODO: Add PILLAR texture for stone
                                                                                // wall
                break;

        }

        try {
            return ImageIO.read(getClass().getResourceAsStream(assetString));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
