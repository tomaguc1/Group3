package Views.SetShips.DragPanel;

import javax.swing.*;
import java.awt.*;

public class ShipLabel extends JLabel {

    public ShipLabel(String shipType, int index){
        switch (shipType) {
            case "s":
                this.setBounds(530, 50*index, 100, 48);
                break;
            case "m":
                this.setBounds(530, 50*index, 150, 48);
                break;
            case "l":
                this.setBounds(530, 50*index, 200, 35);
                break;
            case "c":
                this.setBounds(530, 50*index, 250, 48);
                break;
        }
        this.setBackground(Color.GREEN);
//        this.setOpaque(true);
    }

}
