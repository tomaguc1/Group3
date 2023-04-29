package Views.BattleUI.Weapons;

import Controller.BattleController;
import Controller.GameController;

import javax.swing.*;
import java.awt.*;

public class WeaponPanel extends JPanel {

    public WeaponPanel(BattleController controller){
        this.setPreferredSize(new Dimension(250, 550));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.ORANGE);
    }

    public void clearWeapons() {
        // TODO
    }

    public void addWeapons() {
        // TODO
    }
}
