package Views;

import Helpers.ImageLibrary;
import Views.BoatSetup.BoatSet_LayerPanel;
import Views.Menu1_ServerConnection.HostClient_Pane;
import Model.Network.Server;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    ImageLibrary graphics = new ImageLibrary();

    JLayeredPane menuLayeredPane;
    JLayeredPane boatSetPane;
    JButton buttonHost;
    JButton buttonClient;


    public MainFrame() throws InterruptedException {
          //Frame settings
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.getContentPane().setBackground(Color.MAGENTA);
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================


        //Pannels
        menuLayeredPane = new HostClient_Pane();
        boatSetPane = new BoatSet_LayerPanel();
//ADD components to the frame
        //''this'' -- Frame Component

        this.add(boatSetPane);


        this.setVisible(true);


    }//End of constrctor
}
 
