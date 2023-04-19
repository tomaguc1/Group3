package Views;

import Controller.MainController;
import Helpers.ImageLibrary;
import Model.Main.MainModel;
import Model.Main.Screen;
import Views.BoatSetup.BoatSet_LayerPanel;
import Views.Menu1_ServerConnection.HostClient_Pane;
import Views.Menu.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainView extends JFrame{

    public static ImageLibrary graphics = new ImageLibrary();


    private MainController controller;

    private ChooseSingleplayerOrMultiplayer chooseSingleplayerOrMultiplayer;
    private ChooseServerOrClient            chooseServerOrClient;
    private ServerWaitingForConnection      serverWaitingForConnection;
    private ClientProvideAddress            clientProvideAddress;
    private ClientConnecting                clientConnecting;

    public MainView(MainController controller) {

        this.controller = controller;

        this.chooseSingleplayerOrMultiplayer = new ChooseSingleplayerOrMultiplayer(controller);
        this.chooseServerOrClient            = new ChooseServerOrClient(controller);
        this.serverWaitingForConnection      = new ServerWaitingForConnection(controller);
        this.clientProvideAddress            = new ClientProvideAddress(controller);
        this.clientConnecting                = new ClientConnecting(controller);

        this.add(this.chooseSingleplayerOrMultiplayer);
        this.add(this.chooseServerOrClient);
        this.add(this.serverWaitingForConnection);
        this.add(this.clientProvideAddress);
        this.add(this.clientConnecting);

          //Frame settings
        this.setLayout(new FlowLayout());
        this.setTitle("MenuConnect Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.getContentPane().setBackground(Color.pink);
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================



//ADD components to the frame
        //''this'' -- Frame Component


        this.setVisible(true);

    }//End of constrctor


    public void setScreen(Screen screen) {
//        this.remove(chooseSingleplayerOrMultiplayer);
//        this.remove(chooseServerOrClient);
//        this.remove(serverWaitingForConnection);
//        this.remove(clientProvideAddress);
//        this.remove(clientConnecting);

        chooseSingleplayerOrMultiplayer.setVisible(false);
        chooseServerOrClient.setVisible(false);
        serverWaitingForConnection.setVisible(false);
        clientProvideAddress.setVisible(false);
        clientConnecting.setVisible(false);

        switch (screen) {
            case ChooseSingleplayerOrMultiplayer:
                chooseSingleplayerOrMultiplayer.setVisible(true);
                break;
            case ChooseServerOrClient:
                chooseServerOrClient.setVisible(true);
                break;
            case ServerWaitingForConnection:
                serverWaitingForConnection.setVisible(true);
                break;
            case ClientProvideAddress:
                clientProvideAddress.setVisible(true);
                break;
            case ClientConnecting:
                clientConnecting.setVisible(true);
                break;
        }
    }

//    private class ModelObserver implements Observer {
//        public void update(Observable observable, Object object) {
//            if ((observable instanceof MainModel) == false) return;
//
//
//        }
//    }

}
 
