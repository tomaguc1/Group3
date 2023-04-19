package Controller;
import Model.MainMenu.MainMenuModel;
import Model.Screen;
import Views.MainView;

import java.awt.*;

public class MainMenuController {

    AppController appController;

    MainMenuModel model;
    MainView view;

//    public static void main(String[] args) throws InterruptedException {
//        MainController controller = new MainController();
////        controller.startup();
//    }

    public MainMenuController(AppController app) { // Constructor : instantiates MainModel and MainView for the MainController object
        this.appController = app;
        this.model = new MainMenuModel();
        this.view = new MainView(this);

        this.updateView(); // At object instation the view is updated with the current screen that is contained
                                                                                                    // in the model
    }

    void updateView() {
        this.view.setScreen(this.model.getScreen());
    }

/* createServerButton()
    this {controller} -- listens on the "Host Game" button
        !(when pressed)! this.model -- screen is updated to the next one
        this {controller} -- uses updateView() method that works on this.view
* */
    public Button createServerButton() {
        Button button = new Button("Host Game");
        button.addActionListener(e -> {
            this.model.setScreen(Screen.ServerWaitingForConnection);
            this.updateView();
        });
        return button;
    }

    public Button createClientButton() {
        Button button = new Button("Connect to Game");
        button.addActionListener(e -> {
            this.model.setScreen(Screen.ClientProvideAddress);
            this.updateView();
        });
        return button;
    }

    public Button createBackButton() {
        Button button = new Button("Back");
        button.addActionListener(e -> {
            //TODO : Add temporary appController transition to the ship setting view
            this.model.setScreen(Screen.ChooseServerOrClient);
            this.updateView();
        });
        return button;
    }
}
