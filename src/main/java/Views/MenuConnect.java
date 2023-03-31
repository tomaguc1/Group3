package Views;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConnect extends JFrame implements ActionListener {

    ImageLibrary graphics = new ImageLibrary();
    public MenuConnect(){
        //Frame settings
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(250,250,250));

        //Label Picture + Text
        ImageIcon image = new ImageIcon(graphics.shipImage.getImage());
        JLabel label = new JLabel(image);
        label.setText("Battleships Group3");
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(new Color(105,0,0));
        label.setFont(new Font("Helvetica", Font.BOLD, 28));

        //Pannels
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,0,64,64);
            JLabel amogusLabel = new JLabel(new ImageIcon(graphics.amogusImage.getImage()));
        greenPanel.add(amogusLabel);

            //ADD components to the frame
        this.add(greenPanel);
        this.add(label);        //this Frame had label added to it


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
