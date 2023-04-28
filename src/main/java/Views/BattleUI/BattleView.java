package Views.BattleUI;

import Controller.BattleController;

import javax.swing.*;
import java.awt.*;

public class BattleView extends JPanel {
    public BattleView(BattleController controller) {
        this.setPreferredSize(new Dimension(1280,720));
        this.setBackground(Color.PINK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }
}
