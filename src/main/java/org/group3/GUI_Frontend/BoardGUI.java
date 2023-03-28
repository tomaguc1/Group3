package org.group3.GUI_Frontend;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import org.group3.Helpers.ImageLibrary;

public class BoardGUI extends JFrame {
    ImageLibrary graphics;
    public BoardGUI() {
        try {
            graphics = new ImageLibrary();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.setTitle("BattleShipsTitle"); //sets frame title in the bar with the close minimize and expand buttons
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets default close operation (what happens when you close the window, default is Hide on close)
        this.setResizable(true); // determines if you can alter the size of the window
        this.setVisible(true); // Shows the JFrame (default is false)
        this.setSize(2000,1000); // sets an arbitrary size for the initially generated frame

        this.getContentPane().setBackground(new Color(255,255,255)); //RGB format change background of the frame


        //Gametitle text
        JLabel gameLabel = new JLabel();
        ImageIcon shipImage = new ImageIcon("battleshipAppLogo.png");//"/resources/Miscellaneous/battleshipAppLogo.png");
        gameLabel.setIcon(graphics.shipLogoImage);
        gameLabel.setText("Battleships Group3");


        this.add(gameLabel);



    }
    
}
