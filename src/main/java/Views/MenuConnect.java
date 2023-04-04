package Views.Menu1_ServerConnection;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;

public class MenuConnect extends JFrame{

    ImageLibrary graphics = new ImageLibrary();

    JLayeredPane menuLayeredPane;
    JButton buttonHost;
    JButton buttonClient;
    SERVICE service; // Used for client/server execution flow

    public MenuConnect(){
          //Frame settings
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.getContentPane().setBackground(Color.MAGENTA);
//        this.setLayout(new BorderLayout(10,15));        //----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================


        //Pannels
        menuLayeredPane = new MenuLayeredPane();

//ADD components to the frame
        //''this'' -- Frame Component

        this.add(menuLayeredPane);
        this.setVisible(true);


    }//End of constrctor
}
