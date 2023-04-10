package Controller;
import Model.Main.MainModel;
import Model.Main.Screen;
import Views.MainView;

import java.awt.*;

public class MainController {

    MainModel model;
    MainView view;

    public static void main(String[] args) throws InterruptedException {
        MainController controller = new MainController();
//        controller.startup();
    }

    public MainController() {
        this.model = new MainModel();
        this.view = new MainView(this);

        this.updateView();
    }

    void updateView() {
        this.view.setScreen(this.model.getScreen());
    }

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
            this.model.setScreen(Screen.ChooseServerOrClient);
            this.updateView();
        });
        return button;
    }
}
