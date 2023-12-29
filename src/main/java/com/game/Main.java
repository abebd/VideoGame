package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main {

    // THIS FILE IS OLD AND DEPRECATED, game/MainFrame.java IS THE NEWER VERSION
    /*
     * public static void main(String[] args) {
     * 
     * JFrame window = new JFrame();
     * 
     * window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * window.setResizable(true);
     * window.setTitle("VideoGame");
     * 
     * JPanel container = new JPanel();
     * GamePanel gamePanel = new GamePanel();
     * InformationPanel infoPanel = new InformationPanel(gamePanel);
     * 
     * // idk if this even works
     * gamePanel.setInformationPanel(infoPanel);
     * 
     * int gamePanelX = gamePanel.screenWidth / 2;
     * int gamePanelY = gamePanel.screenHeight / 2;
     * 
     * gamePanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
     * 
     * infoPanel.setPreferredSize(new Dimension(gamePanelX, gamePanelY));
     * infoPanel.setBackground(Color.BLACK);
     * 
     * GridBagConstraints gbc = new GridBagConstraints();
     * gbc.fill = GridBagConstraints.BOTH;
     * gbc.weightx = 1.0;
     * 
     * // container.setLayout();
     * container.add(gamePanel);
     * container.add(infoPanel);
     * 
     * // window.add(infoPanel);
     * // window.add(gamePanel);
     * 
     * window.add(container);
     * 
     * window.pack();
     * 
     * window.setLocationRelativeTo(null);
     * window.setVisible(true);
     * 
     * gamePanel.startGameThread();
     * 
     * }
     */
}