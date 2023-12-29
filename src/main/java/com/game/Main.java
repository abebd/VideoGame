package com.game;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("VideoGame");

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        JLabel l = new JLabel("test");
        GamePanel gamePanel = new GamePanel();

        l.setText("tester");
        gamePanel.add(l);

        // window.add(gamePanel);
        mainPanel.add(gamePanel);
        window.add(mainPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}