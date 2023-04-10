package Views.Menu;

import Controller.MainController;

import javax.swing.*;
import java.awt.*;

public abstract class MenuPanel extends JPanel {
    private MainController controller;

    public MenuPanel(MainController controller) {
        this.controller = controller;
        this.setLayout(new GridLayout(10,1));
        this.add(new Label(this.getClass().getName()));
    }
}
