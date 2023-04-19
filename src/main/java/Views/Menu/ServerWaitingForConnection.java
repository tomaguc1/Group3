package Views.Menu;

import Controller.MainMenuController;

import java.awt.*;

public class ServerWaitingForConnection extends MenuPanel {
    public ServerWaitingForConnection(MainMenuController controller) {
        super(controller);

        this.setBackground(Color.blue);
        this.add(controller.createBackButton());
    }
}
