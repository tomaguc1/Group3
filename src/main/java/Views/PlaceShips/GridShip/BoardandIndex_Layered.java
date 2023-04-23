package Views.PlaceShips.GridShip;

import javax.swing.*;
import java.awt.*;

public class BoardandIndex_Layered extends JLayeredPane {

    public BoardandIndex_Layered(){

        init_GridPane();
    }
    void init_GridPane(){
        setLayout(null);
        setPreferredSize(new Dimension(550, 550));
        setBackground(Color.MAGENTA);
    }
}
