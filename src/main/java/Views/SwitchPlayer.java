package Views;

import Controller.GameController;

import java.awt.*;

public class SwitchPlayer extends MenuPanel {
    private GameController controller;
    public SwitchPlayer(GameController controller) {
        super(controller);

        this.setBackground(Color.cyan);
        this.add(controller.createBackButton());
    }
}
