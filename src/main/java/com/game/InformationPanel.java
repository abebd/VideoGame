package com.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class InformationPanel extends JPanel {

    GamePanel gp;

    public InformationPanel(GamePanel gp) {

        this.gp = gp;

        this.setPreferredSize(new Dimension(gp.screenWidth / 2, gp.screenHeight / 2));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);

        // this.addKeyListener(keyH);
        // this.addMouseListener(mouseH);
        this.setFocusable(true);

        JTextPane test = new JTextPane();
        JTextArea test2 = new JTextArea();

        test.setText("THIS IS TEST TEXT");

        this.add(test);
        this.add(test2);

        // TODO: INFORMATION PANEL IS TURNED OFF
        this.setVisible(false);

    }

}
