package Controller;
import Model.Game.GameModel;
import Model.Game.GameState;
import Model.Game.GameMode;
import Views.GameView;
import Views.PlaceShips.PlaceShipsView;

import java.awt.event.ActionListener;

public class GameController {

    GameModel model;
    GameView view;

    PlaceShipsController placeShipsController;

    public static void main(String[] args) throws InterruptedException {
        GameController controller = new GameController();
    }

    public GameController() { // Constructor : instantiates MainModel and MainView for the MainController object

        this.placeShipsController = new PlaceShipsController(this);

        this.model = new GameModel();
        this.view = new GameView(this);

        this.updateView(); // At object instantiation the view is updated with the current screen that is contained
                                                                                                    // in the model
    }

    void updateView() {
        this.view.setScreen(this.model.getState());
    }

    /**
     * @return action listener, that sets the singleplayer mode and changes the state
     */
    public ActionListener actionSingleplayer() {
        return actionEvent -> {
            this.model.setMode(GameMode.Singleplayer);
            this.model.setState(GameState.PrepareForBattle);
            this.updateView();
        };
    }
    
    /**Used in the main menu where we are setting the multiplayer mode and change the state of the game in the model
     * @return action listener, that sets the multiplayer mode and changes the state
     */
    public ActionListener actionMultiplayer() {
        return actionEvent -> {
            this.model.setMode(GameMode.Multiplayer);
            this.model.setState(GameState.PrepareForBattle);
            this.updateView();
        };
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
