package Controller;
import Model.GameModel;
import Model.GameState;
import Model.GameMode;
import Views.GameView;
import Views.PlaceShips.PlaceShipsView1;

import java.awt.*;

public class GameController {

    GameModel model;
    GameView view;

    PlaceShipsController placeShipsController;

    public static void main(String[] args) throws InterruptedException {
        GameController controller = new GameController();
    }

    public GameController() { // Constructor : instantiates MainModel and MainView for the MainController object

        this.placeShipsController = new PlaceShipsController();

        this.model = new GameModel();
        this.view = new GameView(this);

        this.updateView(); // At object instantiation the view is updated with the current screen that is contained
                                                                                                    // in the model
    }

    void updateView() {
        this.view.setScreen(this.model.getState());
    }

    /**
     * @return Jbutton with action listener, that sets the singleplayer mode and changes the state
     */
    public Button createSingleplayerButton() {
        Button button = new Button("Singleplayer");
        button.addActionListener(e -> {
            this.model.setMode(GameMode.Singleplayer);
            this.model.setState(GameState.PrepareForBattle);
            this.updateView();
        });
        return button;
    }

    /**Used in the main menu where we are setting the multiplayer mode and change the state of the game in the model
     * @return JButton with action listener, that sets the multiplayer mode and changes the state
     */
    public Button createMultiplayerButton() {
        Button button = new Button("Multiplayer"); // TODO : should change to a panel where when u click the button changes for the other player
        button.addActionListener(e -> {
            this.model.setMode(GameMode.Multiplayer);
            this.model.setState(GameState.PrepareForBattle);
            this.updateView();
        });
        return button;
    }




    //TODO : UNUSED thus remove probably
    public Button createBackButton() {
        Button button = new Button("Back");
        button.addActionListener(e -> {
            //TODO : Add temporary appController transition to the ship setting view
//            this.model.setScreen(Screen.ChooseServerOrClient);
            this.view.setVisible(false);
            this.updateView();

        });
        return button;
    }

    public PlaceShipsView1 getPlaceShipsView() {
        return this.placeShipsController.view;
    }


    public PlaceShipsController getPlaceShipsController(){
        return this.placeShipsController;
    }
}
