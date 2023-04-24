package Views.PlaceShips.MenuShips;

import Model.Ship.Ship_Type;

import javax.swing.*;
import java.awt.*;

public class ShipBox_Panel extends JPanel {

    ShipBox_Label label;

    public ShipBox_Panel(Ship_Type shipType){
        this.setPreferredSize(new Dimension(295, 50));
        label = new ShipBox_Label(shipType);
        this.add(label);
    }
}
