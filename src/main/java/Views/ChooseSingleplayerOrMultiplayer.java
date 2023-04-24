package Views;

import Controller.GameController;
import Views.MenuPanel;

import javax.swing.*;

public class ChooseSingleplayerOrMultiplayer extends MenuPanel {
    public ChooseSingleplayerOrMultiplayer(GameController controller) {
        super(controller);
        
        JButton buttonSingleplayer = new JButton("Singleplayer");
        buttonSingleplayer.addActionListener(controller.actionSingleplayer());
        this.add(buttonSingleplayer);

        JButton buttonMultiplayer = new JButton("Multiplayer");
        buttonMultiplayer.addActionListener(controller.actionMultiplayer());
        this.add(buttonMultiplayer);
    }
}
