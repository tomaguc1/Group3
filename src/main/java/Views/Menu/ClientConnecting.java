package Views.Menu;

import Controller.MainController;
import Model.Main.Screen;

import javax.swing.*;
import java.awt.*;

public class ClientConnecting extends MenuPanel {
    private MainController controller;
    public ClientConnecting(MainController controller) {
        super(controller);

        this.setBackground(Color.yellow);
    }
}
