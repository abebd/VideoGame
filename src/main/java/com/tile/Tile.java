package com.tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.entity.Entity;
import com.entity.EntityType;
import com.game.GamePanel;
import com.object.SuperObject;

import config.Config;

public class Tile {

    public BufferedImage image;
    public boolean collision = false;
    public int mapTileNum = 0;

    int x, y;
    int columnValue = -1;
    int rowValue = -1;

    public int worldX, worldY, screenX, screenY;

    Entity entity = null;
    SuperObject object = null;
    boolean isHighlighted;
    boolean isHover = false;

    // Main constructor
    public Tile(BufferedImage image, int mapTileNum, int x, int y) {
        this.image = image;
        this.mapTileNum = mapTileNum;
        this.x = x;
        this.y = y;

    }

    public void showContextMenu(GamePanel gp, int mouseX, int mouseY) {
        // TODO: Remove when done testing
        JPopupMenu menu = new JPopupMenu();
        ActionListener menuListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                handleContextMenuOption(e.getActionCommand());
            }

        };

        // Add items to popupMenu

        // If the tile has an entity
        if (entity != null) {

            if (entity.isOfType(EntityType.ENEMY)) {

                JMenuItem attack = new JMenuItem("Attack");
                menu.add(attack);
            }

            if (entity.isOfType(EntityType.FRIENDLY) || entity.isOfType(EntityType.NEUTRAL)) {

                JMenuItem talk = new JMenuItem("Talk");
                menu.add(talk);
            }

            if (entity.isOfType(EntityType.DEFAULT)) {

                JMenuItem interact = new JMenuItem("Interact");
                menu.add(interact);
            }

            menu.addSeparator();
        } // end of if (entity != null)

        // If the tile has an object
        if (object != null) {

            JMenuItem objectInteract = new JMenuItem(object.getContextMenuinteractionString());
            menu.add(objectInteract);

            menu.addSeparator();
        }

        // Generic items
        JMenuItem inspect = new JMenuItem("Inspect");
        menu.add(inspect);

        JMenuItem move = new JMenuItem("Move");
        move.addActionListener(menuListener);
        menu.add(move);

        // menu.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        menu.show(gp, mouseX, mouseY);

    }

    public void handleContextMenuOption(String command) {
        switch (command) {
            case ("Attack"):
                break;
            case ("Talk"):
                break;
            case ("Interact"):
                break;
            case ("Break"):
                break;
            case ("Open door"):
                break;
            case ("Chop down"):
                break;
            case ("Open chest"):
                break;
            default:
                System.out.printf("debug: command=%s is NYI", command);
                break;
        }
    }

    public void draw(Graphics2D g2, GamePanel gp) {

        // Always draw image
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        // Add low opactity overlay
        if (isHighlighted) {

            g2.setColor(Config.SPELL_OVERLAY_COLOR_VALID_TILE);

            if (isHover) {
                // Set it to blue if its being hovered
                g2.setColor(Config.SPELL_OVERLAY_COLOR_HOVER_TILE);
            }

            g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        }
    }

    public void toggleIsHover() {
        this.isHover = !this.isHover;
    }

    public boolean getIsHover() {
        return isHover;
    }

    public void setIsHover(boolean isHover) {
        this.isHover = isHover;
    }

    public void toggleIsHighlighted() {
        this.isHighlighted = !this.isHighlighted;
    }

    public boolean getIsHighlighted() {
        return isHighlighted;
    }

    public void setIsHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }

    public int getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(int columnValue) {
        this.columnValue = columnValue;
    }

    public int getRowValue() {
        return rowValue;
    }

    public boolean objectOnTileHasCollision() {
        // Need this to simplify checking if the object has collision
        // Otherwise would need to do this if statement before the method call

        if (this.object != null) {
            return this.object.hasCollision;
        }

        return false;

    }

    public void setRowValue(int rowValue) {
        this.rowValue = rowValue;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setObject(SuperObject object) {
        this.object = object;
    }

    public SuperObject getObject() {
        return object;
    }

    // Empty constructor
    public Tile() {

    }

    @Override
    public String toString() {

        String out = "x:" + x + " y:" + y + " mapTileNum:" + mapTileNum + " isHighlited:" + isHighlighted;

        if (entity != null) {
            out += " entity:" + entity.toString();
        }

        if (object != null) {
            out += " object:" + object.toString();
        }

        if (columnValue != -1 && rowValue != -1) {
            out += " columnValue:" + columnValue + " rowValue:" + rowValue;
        }

        return out;
    }

}
