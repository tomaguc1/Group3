package Views;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;

public class MenuConnect extends JFrame {

    ImageLibrary graphics = new ImageLibrary();
    public MenuConnect(){
        //Frame settings
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(640,640);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(250,250,250));

        //Label Picture + Text
        JLabel label = new JLabel();
        label.setText("Battleships Group3");
        ImageIcon image = new ImageIcon(graphics.shipImage.getImage());
        label.setIcon(image);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
            //text allignment
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(new Color(105,0,0));
        label.setFont(new Font("Helvetica", Font.BOLD, 28));


        this.add(label);        //Adding label to the frame



    }
}
