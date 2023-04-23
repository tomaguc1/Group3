package Views.PlaceShips.GridShip;

import javax.swing.*;
import java.awt.*;

public class OceanButtonGrid_Panel extends JPanel {

    public OceanButtonGrid_Panel(){
        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(10,10));
        this.setBounds(50, 0, 500, 500);

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.add(new Tile_Button());
            }
        }
    }
}
