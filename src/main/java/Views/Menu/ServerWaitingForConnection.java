package Views.Menu;

import Controller.MainController;
import Model.Main.Screen;

import javax.swing.*;
import java.awt.*;

public class ServerWaitingForConnection extends MenuPanel {
    public ServerWaitingForConnection(MainController controller) {
        super(controller);

        this.setBackground(Color.blue);
        this.add(controller.createBackButton());
    }
}
