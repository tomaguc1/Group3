package Views.PlaceShips.MenuShips;

import Controller.PlaceShipsController;
import Model.Ship.Ship_Type;
import Views.PlaceShips.PlaceShipsView;

import javax.swing.*;
import java.awt.*;

public class ShipsMenu_Panel extends JPanel {

    public ShipsMenu_Panel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER)); // TODO : Add gaps

        this.setPreferredSize(new Dimension(300, 550));
        this.setBackground(Color.BLUE);
    }

    public void clearShips() {
        this.removeAll();
    }

    public void addShip(PlaceShipsController controller, Ship_Type type, int index, boolean isSelected) {
        ShipBox_Label shipBoxLabel = new ShipBox_Label(type);
        shipBoxLabel.addMouseListener(controller.actionSelectShipFromMenu(index));
        shipBoxLabel.setBackground(isSelected ? Color.RED : Color.GRAY);
        this.add(shipBoxLabel);
    }
}
