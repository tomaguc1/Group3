package Views;

import Controller.GameController;
import Views.MenuPanel;

import java.awt.*;

public class ChooseSingleplayerOrMultiplayer extends MenuPanel {
    public ChooseSingleplayerOrMultiplayer(GameController controller) {
        super(controller);

        this.setBackground(Color.red);

        this.add(controller.createSingleplayerButton());
        this.add(controller.createMultiplayerButton());
    }
}
