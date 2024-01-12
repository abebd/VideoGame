package com.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.GamePanel;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, upCameraPressed, downCameraPressed,
            leftCameraPressed, rightCameraPressed;
    public int cooldownTicks = 10;
    public int ticksSinceLastMove = 0;

    // Test booleans
    public boolean actionBarSlotOnePressed;
    public boolean actionBarSlotTwoPressed;

    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        /* WASD */
        /*
         * 
         * // Player movement
         * if (code == KeyEvent.VK_W) {
         * upPressed = true;
         * // upPressed = false;
         * }
         * 
         * if (code == KeyEvent.VK_S) {
         * downPressed = true;
         * // downPressed = false;
         * }
         * 
         * if (code == KeyEvent.VK_A) {
         * leftPressed = true;
         * // leftPressed = false;
         * }
         * 
         * if (code == KeyEvent.VK_D) {
         * rightPressed = true;
         * // rightPressed = false;
         * }
         * 
         */

        /* ARROWS */
        // Player movement
        if (code == KeyEvent.VK_UP) {
            upPressed = true;
            // upPressed = false;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
            // downPressed = false;
        }

        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
            // leftPressed = false;
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
            // rightPressed = false;
        }

        // ABILITIES
        if (code == KeyEvent.VK_1) {
            actionBarSlotOnePressed = !actionBarSlotOnePressed;
        }

        if (code == KeyEvent.VK_2) {
            actionBarSlotTwoPressed = !actionBarSlotTwoPressed;
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
