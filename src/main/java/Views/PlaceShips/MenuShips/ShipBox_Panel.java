package Views.PlaceShips.MenuShips;

import javax.swing.*;
import java.awt.*;

public class ShipBox_Panel extends JPanel {

    ShipBox_Label label;

    ShipBox_Panel(){
        this.setPreferredSize(new Dimension(295, 50));

    }
    public ShipBox_Panel(String shipType){
        this();
        label = new ShipBox_Label(shipType);
        this.add(label);



    }
}
