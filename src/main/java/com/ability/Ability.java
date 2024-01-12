package com.ability;

import com.entity.Entity;
import com.entity.Player;
import com.tile.Tile;
import com.tile.TileManager;

public class Ability {

    String name;
    String description;
    float damage;
    int manaCost;
    int tileRange;
    int cooldown;

    public boolean fire(Player player, Tile targetTile, TileManager tileM) {
        System.out.println("Not yet implemented for this spell haha");
        return false;
    }

    public void toggleSpellOverlay(TileManager tileM, Entity caster) {
        tileM.highlightAvailableTiles(caster, this);
    }

    public float getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public int getTileRange() {
        return tileRange;
    }

}
