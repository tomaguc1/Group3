package Views.Menu;

import Controller.MainMenuController;

import java.awt.*;

public class ClientProvideAddress extends MenuPanel {
    private MainMenuController controller;
    public ClientProvideAddress(MainMenuController controller) {
        super(controller);

        this.setBackground(Color.cyan);
        this.add(controller.createBackButton());
    }
}
