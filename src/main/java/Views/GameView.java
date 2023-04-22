package Views;

import Controller.GameController;
import Helpers.ImageLibrary;
import Model.GameState;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame{

    public static ImageLibrary graphics = new ImageLibrary();

    private GameController controller;

/* Below we declare all the possible panels that can occur in the main menu,
    And accoring to the user input listened by the MainController object the model is updated
     and the view is changed by  ....  TODO : finish
* */
    private ChooseSingleplayerOrMultiplayer chooseSingleplayerOrMultiplayer;
    private PrepareForBattle prepareForBattle;
    private PlayerSelectsTarget playerSelectsTarget;
    private SwitchPlayer switchPlayer;
    private PlayerOutOfShips playerOutOfShips;

    public GameView(GameController controller) {

        this.controller = controller;

/*  Instantiation of the above declared all possible panels that will occur in the main menu
*  */
        this.chooseSingleplayerOrMultiplayer = new ChooseSingleplayerOrMultiplayer(controller);
        this.prepareForBattle = new PrepareForBattle(controller);
        this.playerSelectsTarget = new PlayerSelectsTarget(controller);
        this.switchPlayer = new SwitchPlayer(controller);
        this.playerOutOfShips = new PlayerOutOfShips(controller);


/*  Adding the instantiated panels above to the frame, by default they are NOT visible
* */
        this.add(this.chooseSingleplayerOrMultiplayer);
        this.add(this.prepareForBattle);
        this.add(this.playerSelectsTarget);
        this.add(this.switchPlayer);
        this.add(this.playerOutOfShips);


/*  Frame settings
* */
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 ,0));
        this.setTitle("MainFrame Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.getContentPane().setBackground(Color.YELLOW);
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================



//ADD components to the frame
        //''this'' -- Frame Component


        this.setVisible(true);

    }//End of constrctor


    public void setScreen(GameState screen) {

        chooseSingleplayerOrMultiplayer.setVisible(false);
        prepareForBattle.setVisible(false);
        playerSelectsTarget.setVisible(false);
        switchPlayer.setVisible(false);
        playerOutOfShips.setVisible(false);

        switch (screen) {
            case ChooseSingleplayerOrMultiplayer:
                chooseSingleplayerOrMultiplayer.setVisible(true);
                this.setTitle("ChooseSingleplayerOrMultiplayer");
                break;
            case PrepareForBattle:
                prepareForBattle.setVisible(true);
                this.setTitle("PrepareForBattle");
                break;
            case PlayerSelectsTarget:
                playerSelectsTarget.setVisible(true);
                this.setTitle("PlayerSelectsTarget");
                break;
            case SwitchPlayer:
                switchPlayer.setVisible(true);
                this.setTitle("SwitchPlayer");
                break;
            case PlayerOutOfShips:
                playerOutOfShips.setVisible(true);
                this.setTitle("PlayerOutOfShips");
                break;
        }
    }

}
 
