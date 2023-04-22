package Views.SetShips.Grid;

import javax.swing.*;
import java.awt.*;

public class Tile_Button extends JButton {
    Tile_Button(){
        this.setEnabled(false);
//        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
    }
    public Tile_Button(String s){
        this();
        this.setText(s);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}