package Views.Menu;

import Controller.MainMenuController;

import javax.swing.*;
import java.awt.*;

public abstract class MenuPanel extends JPanel {
    private MainMenuController controller;

    public MenuPanel(MainMenuController controller) {

        this.controller = controller;
        this.setPreferredSize(new Dimension(150,200));
        this.setLayout(new GridLayout(5,1));
        this.add(new Label(this.getClass().getName()));
    }
}
