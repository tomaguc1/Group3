package Views;

import Helpers.ImageLibrary;
import Model.Main.MainModel;
import Views.BoatSetup.BoatSet_LayerPanel;
import Views.Menu1_ServerConnection.HostClient_Pane;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    public static ImageLibrary graphics = new ImageLibrary();

    JLayeredPane menuLayeredPane;
    JLayeredPane boatSetPane;
    JButton buttonHost;
    JButton buttonClient;

    private MainModel model;

    public MainView(MainModel model) {

        this.model = model;

          //Frame settings
        this.setLayout(new BorderLayout());
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.getContentPane().setBackground(Color.GREEN);
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================


        //Pannels
        menuLayeredPane = new HostClient_Pane();
        boatSetPane = new BoatSet_LayerPanel();

//ADD components to the frame
        //''this'' -- Frame Component

        this.add(menuLayeredPane);
        this.add(boatSetPane);


        this.setVisible(true);


    }//End of constrctor

    public void showMenu() {
        this.boatSetPane.setVisible(false);
        this.menuLayeredPane.setVisible(true);
    }

    public void showGame() {
        this.menuLayeredPane.setVisible(false);
        this.boatSetPane.setVisible(true);
    }

}
 
