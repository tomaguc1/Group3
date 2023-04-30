package Views;

import Controller.GameController;
import Model.Difficulty;

import javax.swing.*;
import java.awt.*;

public class ChooseSingleplayerOrMultiplayer extends JPanel {
    public ChooseSingleplayerOrMultiplayer(GameController controller) {
        this.setPreferredSize(new Dimension(1280,720));
        this.setLayout(null);

        JButton buttonSingleplayerEasy = new JButton("Singleplayer (Easy)");
        buttonSingleplayerEasy.addActionListener(controller.actionSingleplayer(Difficulty.Easy));
        buttonSingleplayerEasy.setBounds(218, 100, 200, 50);
        this.add(buttonSingleplayerEasy);


        JButton buttonSingleplayerDifficult = new JButton("Singleplayer (Difficult)");
        buttonSingleplayerDifficult.addActionListener(controller.actionSingleplayer(Difficulty.Difficult));
        buttonSingleplayerDifficult.setBounds(540, 100, 200, 50);
        this.add(buttonSingleplayerDifficult);

        JButton buttonMultiplayer = new JButton("Multiplayer");
        buttonMultiplayer.addActionListener(controller.actionMultiplayer());
        buttonMultiplayer.setBounds(862, 100, 200, 50);
        this.add(buttonMultiplayer);

        JButton buttonRandomMultiplayer = new JButton("Random Multiplayer");
        buttonRandomMultiplayer.addActionListener(controller.actionRandomMultiplayer());
        //this.add(buttonRandomMultiplayer);

        JButton buttonMusic = new JButton("Submit Music");
        buttonMusic.addActionListener(controller.actionMusic());
        buttonMusic.setBounds(490, 300 , 200, 50);
        this.add(buttonMusic);

        GameController.textMusic.setBounds(690, 300, 100, 50);
        this.add(GameController.textMusic);

        JButton buttonHelp = new JButton("Help");
        buttonHelp.addActionListener(controller.actionHelp());
        buttonHelp.setBounds(590, 500, 100, 50);
        this.add(buttonHelp);

        this.setVisible(true);
    }
}
