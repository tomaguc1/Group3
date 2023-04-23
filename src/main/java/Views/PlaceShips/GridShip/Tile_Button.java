package Views.PlaceShips.GridShip;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;

public class Tile_Button extends JButton {
    ImageLibrary graphics = new ImageLibrary();
    Tile_Button(){
        this.setEnabled(true);
//        this.setOpaque(false);
        this.setIcon(graphics.water);
//        this.setContentAreaFilled(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        this.addActionListener(e -> {});
    }
    public Tile_Button(String s){ // Tile button for indexes
        this.setEnabled(false);
        this.setText(s);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}
