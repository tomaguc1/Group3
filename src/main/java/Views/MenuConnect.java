package Views;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConnect extends JFrame{

    ImageLibrary graphics = new ImageLibrary();
    JButton hostButton;
    JPanel hostPannel;
    public MenuConnect(){
        //Frame settings
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(250,250,250));
        this.setLayout(new BorderLayout(10,15));

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
        greenPanel.setBounds(0,0,128,128);
        greenPanel.setLayout(new BorderLayout());
            JLabel amogusLabel = new JLabel(new ImageIcon(graphics.amogusImage.getImage()));
//            amogusLabel.setHorizontalAlignment(JLabel.); //Changes the postion of the label inside the CONTAINER
//        greenPanel.add(amogusLabel);

        //====  Host Pannel ==== TODO :{ after pressing host should display the ip address to connect at, and handle a ready lock to transition to the game }
        hostPannel = new JPanel(new BorderLayout());
        hostPannel.setBackground(Color.MAGENTA);
        hostPannel.setPreferredSize(new Dimension(100,200));
        hostPannel.setVisible(false);


        //Button for Hosting and connection
        hostButton = new JButton();
        hostButton.setBounds(600, 560 , 100,50);
        hostButton.setHorizontalAlignment(SwingConstants.CENTER);
        hostButton.setVerticalAlignment(SwingConstants.BOTTOM);

        hostButton.addActionListener( e -> {System.out.println(" -> Host button pressed !");
                                            hostPannel.setVisible(true);}
                                    );

        //Button formatting
            hostButton.setFocusable(false);                         //removes the box around text
            hostButton.setText("Host");
            hostButton.setHorizontalTextPosition(JButton.CENTER);
            hostButton.setVerticalTextPosition(JButton.TOP);
            hostButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
            hostButton.setBackground(Color.LIGHT_GRAY);
            hostButton.setBorder(BorderFactory.createEtchedBorder());





//----------------------------------------------------------------------------------------------------------------------
            //ADD components to the frame
        this.add(hostButton);
        this.add(hostPannel, BorderLayout.SOUTH);
        //this.add(greenPanel);
        this.add(label);        //this Frame had label added to it


    }//End of constrctor


}
