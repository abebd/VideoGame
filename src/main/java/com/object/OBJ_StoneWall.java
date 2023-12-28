package com.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.enums.WallDirection;
import com.tile.Tile;

public class OBJ_StoneWall extends SuperObject {

    public OBJ_StoneWall(Tile tile, WallDirection givenDirection) {
        myTile = tile;

        name = "Tree1";

        image = dictateWallDirection(givenDirection);

        isInteractable = true;
        hasCollision = true;
    }

    public BufferedImage dictateWallDirection(WallDirection givenDirection) {
        String assetString = "";

        switch (givenDirection) {
            case STRAIGHT_ABOVE:
                assetString = "/assets/object/stoneWall_straightAbove.png";
                break;
            case STRAIGHT_LEFT:
                assetString = "/assets/object/stoneWall_straightLeft.png";
                break;
            case STRAIGHT_RIGHT:
                assetString = "/assets/object/stoneWall_straightRight.png";
                break;
            case STRAIGHT_UNDER:
                assetString = "/assets/object/stoneWall_straightAbove.png"; // TODO: Add STRAIGHT_UNDER texture for
                                                                            // stone wall
                break;
            case EDGE_LEFT:
                assetString = "/assets/object/stoneWall_edgeLeft.png";
                break;
            case EDGE_RIGHT:
                assetString = "/assets/object/stoneWall_edgeRight.png";
                break;
            case INNER_EDGE_LEFT:
                assetString = "/assets/object/stoneWall_innerEdgeLeft.png";
                break;
            case INNER_EDGE_RIGHT:
                assetString = "/assets/object/stoneWall_innerEdgeRight.png";
                break;
            case PILLAR:
                assetString = "/assets/object/stoneWall_straightLeft.png"; // TODO: Add PILLAR texture for stone wall
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
