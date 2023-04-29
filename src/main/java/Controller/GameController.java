package Controller;
import Model.DifficultAI.DifficultAI;
import Model.Difficulty;
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
import sun.plugin.dom.exception.InvalidStateException;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class
GameController {

    GameModel model;
    GameView view;

    PlaceShipsController placeShipsController;
    BattleController battleController;

    public static void main(String[] args) throws InterruptedException {
        GameController controller = new GameController();
    }

    public GameController() { // Constructor : instantiates MainModel and MainView for the MainController object

        this.model = new GameModel();
        this.view = new GameView();

        this.updateView(); // At object instantiation the view is updated with the current screen that is contained
                                                                                                    // in the model
    }

    private void updateView() {
        this.view.getContentPane().removeAll();

        switch (this.model.state) {
            case ChooseSingleplayerOrMultiplayer:
                this.view.setTitle("Battleship: Main Menu");
                this.view.add(new ChooseSingleplayerOrMultiplayer(this));
                break;
            case PrepareForBattle:
                this.view.setTitle("Battleship: Prepare for Battle");
                this.view.add(this.placeShipsController.view);
                break;
            case PlayerSelectsTarget:
                this.view.setTitle("Battleship: daVAI dratza");
                this.view.add(this.battleController.view);
                break;
        }

        this.view.validate();
        this.view.repaint();
    }

    private Kompic kompic() {
        switch (this.model.difficulty) {
            case Easy:
                return new EasyAI();
            case Difficult:
                return new DifficultAI();
        }
        throw new InvalidStateException("");
    }

    /**
     * @return action listener, that sets the singleplayer mode and changes the state
     */
    public ActionListener actionSingleplayer(Difficulty difficulty) {
        return actionEvent -> {
            this.model.mode = GameMode.Singleplayer;
            this.model.state = GameState.PrepareForBattle;
            this.model.difficulty = difficulty;
            this.placeShipsController = new PlaceShipsController(this, this.model.types, "Player");
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
            this.placeShipsController = new PlaceShipsController(this, this.model.types, "Player 1");
            this.updateView();
        };
    }

    public ActionListener actionRandomMultiplayer() {
        return actionEvent -> {
            this.model.mode = GameMode.Multiplayer;
            PlayerModel one = new PlayerModel("one", this.kompic().placeShips(this.model.types));
            PlayerModel two = new PlayerModel("two", this.kompic().placeShips(this.model.types));
            this.battleController = new BattleController(one, two, this.model.types);
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
                this.model.playerTwo = new PlayerModel(this.kompic(), this.model.types);
                break;
            case Multiplayer:
                this.placeShipsController = new PlaceShipsController(this, this.model.types, "Player 2");
                break;
        }

        // at least playerOne is ready by now
        if (this.model.playerTwo != null) {
            // if both players are ready
            this.battleController = new BattleController(this.model.playerOne, this.model.playerTwo, this.model.types);
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
