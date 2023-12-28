package com.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int lastMouseX, lastMouseY;
    public boolean isPressed, isEntered, isClicked;

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
        System.out.printf("isPressed:%s mouseX:%d mouseY:%d\n", isPressed, lastMouseX, lastMouseY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        lastMouseX = e.getX();
        lastMouseY = e.getY();
        isPressed = false;
        System.out.printf("isPressed:%s mouseX:%d mouseY:%d\n", isPressed, lastMouseX, lastMouseY);
    }

}
