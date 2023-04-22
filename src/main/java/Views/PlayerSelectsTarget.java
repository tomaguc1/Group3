package Views;

import Controller.GameController;

import java.awt.*;

public class PlayerSelectsTarget extends MenuPanel {
    public PlayerSelectsTarget(GameController controller) {
        super(controller);

        this.setBackground(Color.blue);
        this.add(controller.createBackButton());
    }
}
