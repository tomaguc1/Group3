package Views.SetShips.Grid;

import javax.swing.*;
import java.awt.*;

public class Tile_Grid extends JPanel {

    public Tile_Grid(){
        this.setBackground(Color.CYAN);
        this.setLayout(new GridLayout(10,10));

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.add(new Tile_Button());
            }
        }

        this.setVisible(true); //At the end
    }

}
