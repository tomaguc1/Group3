package Views;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;

public abstract class MenuPanel extends JPanel {
    private GameController controller;

    public MenuPanel(GameController controller) {

        this.controller = controller;
        this.setPreferredSize(new Dimension(1280,720));
        this.setLayout(new GridLayout(1,2));
//        this.add(new Label(this.getClass().getName()));
    }
}
