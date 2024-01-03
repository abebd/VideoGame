package com.ability;

import com.entity.Entity;
import com.tile.TileManager;

public class ABLTY_Fireball extends Ability {

    public ABLTY_Fireball() {
        this.name = "Fireball";
        this.description = "emtpy";

        this.damage = 10;
        this.manaCost = 10;
        this.tileRange = 4;
        this.cooldown = 3;
    }

    public void spellOverlay(TileManager tileM, Entity caster) {
        tileM.highlightAvailableTiles(caster, this.tileRange);
    }

    public void fire() {
        
    }

}
