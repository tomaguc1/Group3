package Views.PlaceShips.MenuShips;

import javax.swing.*;
import java.awt.*;

public class ShipsMenu_Panel extends JPanel {
    String[] shipColection = {"s","s", "m", "l", "c"};

    public ShipsMenu_Panel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER)); // TODO : Add gaps

        this.setPreferredSize(new Dimension(300, 550));
        this.setBackground(Color.BLUE);

        for (String s : shipColection){
            this.add(new ShipBox_Panel(s));
        }
    }


}
