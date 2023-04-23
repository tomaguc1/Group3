package Views.PlaceShips.MenuShips;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;

public class ShipBox_Label extends JLabel {
    ImageLibrary graphics = new ImageLibrary();


    ShipBox_Label(String shipType){

        switch(shipType) {
                    case "s":
                        this.setIcon(graphics.smallShip);
                        break;
                    case "m":
                        this.setIcon(graphics.mediumShip);
                        break;
                    case "l":
                        this.setIcon(graphics.largeShip);
                        break;
                    case "c":
                        this.setIcon(graphics.carrier);
                        break;
                }
                this.setBackground(Color.GREEN);
                this.setOpaque(true);
    }

}
