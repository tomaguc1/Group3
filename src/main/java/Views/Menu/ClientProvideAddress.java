package Views.Menu;

import Controller.MainController;
import Model.Main.Screen;

import javax.swing.*;
import java.awt.*;

public class ClientProvideAddress extends MenuPanel {
    private MainController controller;
    public ClientProvideAddress(MainController controller) {
        super(controller);

        this.setBackground(Color.cyan);
        this.add(controller.createBackButton());
    }
}
