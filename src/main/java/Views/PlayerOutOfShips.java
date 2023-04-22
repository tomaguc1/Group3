package Views;

import Controller.GameController;
import Views.MenuPanel;

import java.awt.*;

public class PlayerOutOfShips extends MenuPanel {
    private GameController controller;
    public PlayerOutOfShips(GameController controller) {
        super(controller);

        this.setBackground(Color.yellow);
    }
}
