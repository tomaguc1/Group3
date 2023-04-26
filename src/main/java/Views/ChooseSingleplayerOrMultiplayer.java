package Views;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;

public class ChooseSingleplayerOrMultiplayer extends JPanel {
    public ChooseSingleplayerOrMultiplayer(GameController controller) {
        this.setPreferredSize(new Dimension(1280,720));
        
        JButton buttonSingleplayer = new JButton("Singleplayer");
        buttonSingleplayer.addActionListener(controller.actionSingleplayer());
        this.add(buttonSingleplayer);

        JButton buttonMultiplayer = new JButton("Multiplayer");
        buttonMultiplayer.addActionListener(controller.actionMultiplayer());
        this.add(buttonMultiplayer);

        JButton buttonRandomMultiplayer = new JButton("Random Multiplayer");
        buttonRandomMultiplayer.addActionListener(controller.actionRandomMultiplayer());
        this.add(buttonRandomMultiplayer);

        this.setVisible(true);
    }
}
