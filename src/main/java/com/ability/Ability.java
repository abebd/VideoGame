package com.ability;

public class Ability {

    String name;
    String description;
    float damage;
    int manaCost;
    int tileRange;
    int cooldown;

    public void highlightAvailableTiles() {

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
