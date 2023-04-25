package Views.PlaceShips.MenuShips;

import Helpers.ImageLibrary;
import Model.Ship.Ship_Type;

import javax.swing.*;
import java.awt.*;

public class ShipBox_Label extends JLabel {
    ImageLibrary graphics = new ImageLibrary();


    public ShipBox_Label(Ship_Type shipType){

        switch(shipType) {
            case SUBMARINE:
                    this.setIcon(graphics.smallShip);
                    break;
            case DESTROYER:
                    this.setIcon(graphics.mediumShip);
                    break;
            case BATTLESHIP:
                    this.setIcon(graphics.largeShip);
                    break;
            case CARRIER:
                    this.setIcon(graphics.carrier);
                    break;
                }
            this.setBackground(Color.GREEN);
            this.setOpaque(true);
    }
}
