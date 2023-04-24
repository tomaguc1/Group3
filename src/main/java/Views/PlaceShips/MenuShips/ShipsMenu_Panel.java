package Views.PlaceShips.MenuShips;

import Model.Ship.Ship_Type;

import javax.swing.*;
import java.awt.*;

public class ShipsMenu_Panel extends JPanel {
//    String[] shipColection = {"s","s", "m", "l", "c"};
    Ship_Type[] shipCollection = {Ship_Type.SUBMARINE, Ship_Type.SUBMARINE,
        Ship_Type.DESTROYER, Ship_Type.BATTLESHIP, Ship_Type.CARRIER };

    public ShipsMenu_Panel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER)); // TODO : Add gaps

        this.setPreferredSize(new Dimension(300, 550));
        this.setBackground(Color.BLUE);

        for (Ship_Type s : shipCollection){
            this.add(new ShipBox_Panel(s));
        }
    }


}
