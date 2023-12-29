package com.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.GamePanel;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, upCameraPressed, downCameraPressed,
            leftCameraPressed, rightCameraPressed;
    public int cooldownTicks = 10;
    public int ticksSinceLastMove = 0;

    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // Player movement
        if (code == KeyEvent.VK_W) {
            upPressed = true;
            // upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
            // downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            // leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            // rightPressed = false;
        }

        // Other

        if (code == KeyEvent.VK_1) {
            System.out.println(gp.player.getMyTile());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            ticksSinceLastMove = 0;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
            ticksSinceLastMove = 0;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
            ticksSinceLastMove = 0;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
            ticksSinceLastMove = 0;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
