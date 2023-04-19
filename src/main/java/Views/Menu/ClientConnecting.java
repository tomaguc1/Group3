package Views.Menu;

import Controller.MainMenuController;

import java.awt.*;

public class ClientConnecting extends MenuPanel {
    private MainMenuController controller;
    public ClientConnecting(MainMenuController controller) {
        super(controller);

        this.setBackground(Color.yellow);
    }
}
