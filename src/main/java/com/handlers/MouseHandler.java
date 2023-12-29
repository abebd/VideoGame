package com.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import com.game.GamePanel;
import com.tile.Tile;
import com.tile.TileManager;

public class MouseHandler implements MouseListener {
    public int lastMouseX, lastMouseY, newMouseX, newMouseY;
    public boolean isPressed, isEntered, isClicked;

    GamePanel gp;
    TileManager tileM;

    public MouseHandler(GamePanel gp, TileManager tileM) {
        this.gp = gp;
        this.tileM = tileM;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isClicked = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isEntered = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isEntered = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        lastMouseX = e.getX();
        lastMouseY = e.getY();

        if (SwingUtilities.isRightMouseButton(e)) {
            Tile tile = tileM.getTileAtPosition(lastMouseX, lastMouseY);
            tile.showContextMenu(gp, lastMouseX, lastMouseY);
            System.out.println(tile.toString());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        newMouseX = e.getX();
        newMouseY = e.getY();
        isPressed = false;

        // TODO: Fix outside and inside bounds camera

        if (SwingUtilities.isLeftMouseButton(e)) {
            System.out.printf("dragged from x:%d -> %d and y:%d -> %d\n", lastMouseX, newMouseX, lastMouseY, newMouseY);

            gp.shiftX = (lastMouseX - newMouseX);
            gp.shiftY = (lastMouseY - newMouseY);
        }

        // gp.shiftCamera(lastMouseX - newMouseX, lastMouseY - newMouseY);
    }

}
