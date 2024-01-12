package com.ability;

import com.entity.Entity;
import com.entity.Player;
import com.tile.Tile;
import com.tile.TileManager;

public class ABLTY_Blink extends Ability {

    public ABLTY_Blink() {
        this.name = "Blink";
        this.description = "empty";

        this.damage = -1;
        this.manaCost = 20;
        this.tileRange = 6;

        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean fire(Player player, Tile targetTile, TileManager tileM) {
        // Only player can do it now, but cba to implement moveTiles on entity atm
        if (targetTile.objectOnTileHasCollision()) {
            System.out.printf("Cant move to tile on [%s] due to object\n",
                    targetTile.getColumnValue() + "," + targetTile.getRowValue());
            return false;
        }

        if (targetTile.getEntity() != null) {
            System.out.printf("Cant move to tile on [%s] due to object\n",
                    targetTile.getColumnValue() + "," + targetTile.getRowValue());
            return false;
        }

        // If tile is in range logic
        if (!tileM.isTileInRange(player.getMyTile(), targetTile, tileRange)) {
            System.out.println("Tile chosen not in range");
            return false;
        }

        player.moveTiles(player.getMyTile(), targetTile);
        return true;
    }

}
