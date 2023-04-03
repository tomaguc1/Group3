package Views.ConnectingPanels;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;

public class MenuConnect extends JFrame{

    ImageLibrary graphics = new ImageLibrary();

    JLayeredPane servingDecisionPANEL;
    JButton buttonHost;
    JButton buttonClient;
    SERVICE service; // Used for client/server execution flow

    public MenuConnect(){
          //Frame settings
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(68, 159, 175));
        this.setLayout(new BorderLayout(10,15));        //----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================

        //Label Picture + Text
        ImageIcon image = new ImageIcon(graphics.shipImage.getImage());
        JLabel menuLabel_shipLabel = new JLabel(image);
        menuLabel_shipLabel.setText("Battleships Group3");
        menuLabel_shipLabel.setVerticalAlignment(JLabel.TOP);
        menuLabel_shipLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel_shipLabel.setHorizontalTextPosition(JLabel.CENTER);
        menuLabel_shipLabel.setVerticalTextPosition(JLabel.BOTTOM);
        menuLabel_shipLabel.setForeground(new Color(105,0,0));
        menuLabel_shipLabel.setFont(new Font("Helvetica", Font.BOLD, 28));

        //Pannels
        servingDecisionPANEL = new ServDecisionPanel();






        //ADD components to the frame
        //''this'' -- Frame Component
        this.add(menuLabel_shipLabel);
        this.add(servingDecisionPANEL, BorderLayout.SOUTH);


    }//End of constrctor
}
