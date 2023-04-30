package Views;

import Controller.GameController;
import Model.Difficulty;

import javax.swing.*;
import java.awt.*;

public class ChooseSingleplayerOrMultiplayer extends JPanel {
    public ChooseSingleplayerOrMultiplayer(GameController controller) {
        this.setPreferredSize(new Dimension(1280,720));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 55));

        JButton buttonSingleplayerEasy = new JButton("Singleplayer (Easy)");
        buttonSingleplayerEasy.addActionListener(controller.actionSingleplayer(Difficulty.Easy));
        this.add(buttonSingleplayerEasy);

        JButton buttonSingleplayerDifficult = new JButton("Singleplayer (Difficult)");
        buttonSingleplayerDifficult.addActionListener(controller.actionSingleplayer(Difficulty.Difficult));
        this.add(buttonSingleplayerDifficult);

        JButton buttonMultiplayer = new JButton("Multiplayer");
        buttonMultiplayer.addActionListener(controller.actionMultiplayer());
        this.add(buttonMultiplayer);

        JButton buttonRandomMultiplayer = new JButton("Random Multiplayer");
        buttonRandomMultiplayer.addActionListener(controller.actionRandomMultiplayer());
        this.add(buttonRandomMultiplayer);

        JButton buttonMusic = new JButton("Submit Music");
        buttonMusic.addActionListener(controller.actionMusic());
        this.add(buttonMusic);
        this.add(GameController.textMusic);

        JButton buttonHelp = new JButton("Help");
        buttonHelp.addActionListener(controller.actionHelp());
        this.add(buttonHelp);

        this.setVisible(true);
    }
}
