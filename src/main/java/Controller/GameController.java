package Controller;
import Model.EasyAI.EasyAI;
import Model.Game.GameModel;
import Model.Game.GameState;
import Model.Game.GameMode;
import Model.Player.Kompic;
import Model.Player.PlayerModel;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;
import Views.ChooseSingleplayerOrMultiplayer;
import Views.GameView;
import Views.PlaceShips.PlaceShipsView;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class
GameController {

    GameModel model;
    GameView view;

    PlaceShipsController placeShipsController;
    BattleController battleController;

    private ArrayList<Ship_Type> types;
    private Kompic kompic;

    public static void main(String[] args) throws InterruptedException {
        GameController controller = new GameController();
    }

    public GameController() { // Constructor : instantiates MainModel and MainView for the MainController object

        this.types = new ArrayList<>();
        this.types.add(Ship_Type.SUBMARINE);
        this.types.add(Ship_Type.CARRIER);
        this.types.add(Ship_Type.BATTLESHIP);

        // could be switched by user to adjust difficulty
        this.kompic = new EasyAI();

        this.model = new GameModel();
        this.view = new GameView();

        this.updateView(); // At object instantiation the view is updated with the current screen that is contained
                                                                                                    // in the model
    }

    void updateView() {
        this.view.getContentPane().removeAll();

        switch (this.model.state) {
            case ChooseSingleplayerOrMultiplayer:
                this.view.setTitle("Battle The Ships");
                this.view.add(new ChooseSingleplayerOrMultiplayer(this));
                break;
            case PrepareForBattle:
                this.view.add(this.placeShipsController.view);
                break;
            case PlayerSelectsTarget:
                this.view.add(this.battleController.view);
                break;
        }

        this.view.validate();
        this.view.repaint();
    }

    /**
     * @return action listener, that sets the singleplayer mode and changes the state
     */
    public ActionListener actionSingleplayer() {
        return actionEvent -> {
            this.model.mode = GameMode.Singleplayer;
            this.model.state = GameState.PrepareForBattle;
            this.placeShipsController = new PlaceShipsController(this, this.types, "Player");
            this.updateView();
        };
    }
    
    /**Used in the main menu where we are setting the multiplayer mode and change the state of the game in the model
     * @return action listener, that sets the multiplayer mode and changes the state
     */
    public ActionListener actionMultiplayer() {
        return actionEvent -> {
            this.model.mode = GameMode.Multiplayer;
            this.model.state = GameState.PrepareForBattle;
            this.placeShipsController = new PlaceShipsController(this, this.types, "Player 1");
            this.updateView();
        };
    }

    public ActionListener actionRandomMultiplayer() {
        return actionEvent -> {
            this.model.mode = GameMode.Multiplayer;
            PlayerModel one = new PlayerModel("one", this.kompic.placeShips(this.types));
            PlayerModel two = new PlayerModel("two", this.kompic.placeShips(this.types));
            this.battleController = new BattleController(one, two);
            this.model.state = GameState.PlayerSelectsTarget;
            this.updateView();
        };
    }

    public void submitPlayerData(String name, ArrayList<Ship> ships) {
        PlayerModel player = new PlayerModel(name, ships);
        if (this.model.playerOne == null) {
            this.model.playerOne = player;
        } else if (this.model.playerTwo == null) {
            this.model.playerTwo = player;
        }

        // if playerTwo is missing
        switch (this.model.mode) {
            case Singleplayer:
                this.model.playerTwo = new PlayerModel(kompic, this.types);
                break;
            case Multiplayer:
                this.placeShipsController = new PlaceShipsController(this, this.types, "Player 2");
                break;
        }

        // at least playerOne is ready by now
        if (this.model.playerTwo != null) {
            // if both players are ready
            this.battleController = new BattleController(this.model.playerOne, this.model.playerTwo);
            this.model.state = GameState.PlayerSelectsTarget;
        }

        this.updateView();
    }
    

    public PlaceShipsView getPlaceShipsView() {
        return this.placeShipsController.view;
    }

    public PlaceShipsController getPlaceShipsController(){
        return this.placeShipsController;
    }


    //TODO : UNUSED thus remove probably
//    public Button createBackButton() {
//        Button button = new Button("Back");
//        button.addActionListener(e -> {
//            //TODO : Add temporary appController transition to the ship setting view
////            this.model.setScreen(Screen.ChooseServerOrClient);
//            this.view.setVisible(false);
//            this.updateView();
//
//        });

//        return button;

//    }

}
