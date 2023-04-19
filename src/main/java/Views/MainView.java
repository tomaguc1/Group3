package Views;

import Controller.MainMenuController;
import Helpers.ImageLibrary;
import Model.Screen;
import Views.Menu.*;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    public static ImageLibrary graphics = new ImageLibrary();

    private MainMenuController controller;

/* Below we declare all the possible panels that can occur in the main menu,
    And accoring to the user input listened by the MainController object the model is updated
     and the view is changed by  ....  TODO : finish
* */
    private ChooseSingleplayerOrMultiplayer chooseSingleplayerOrMultiplayer;
    private ChooseServerOrClient            chooseServerOrClient;
    private ServerWaitingForConnection      serverWaitingForConnection;
    private ClientProvideAddress            clientProvideAddress;
    private ClientConnecting                clientConnecting;

    public MainView(MainMenuController controller) {

        this.controller = controller;

/*  Instantiation of the above declared all possible panels that will occur in the main menu
*  */
        this.chooseSingleplayerOrMultiplayer = new ChooseSingleplayerOrMultiplayer(controller);
        this.chooseServerOrClient            = new ChooseServerOrClient(controller);
        this.serverWaitingForConnection      = new ServerWaitingForConnection(controller);
        this.clientProvideAddress            = new ClientProvideAddress(controller);
        this.clientConnecting                = new ClientConnecting(controller);


/*  Adding the instantiated panels above to the frame, by default they are NOT visible
* */
        this.add(this.chooseSingleplayerOrMultiplayer);
        this.add(this.chooseServerOrClient);
        this.add(this.serverWaitingForConnection);
        this.add(this.clientProvideAddress);
        this.add(this.clientConnecting);


/*  Frame settings
* */
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
//        }
//    }

}
 
