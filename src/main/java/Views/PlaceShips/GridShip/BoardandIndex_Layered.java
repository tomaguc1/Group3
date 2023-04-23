package Views.PlaceShips.GridShip;

import javax.swing.*;
import java.awt.*;

public class BoardandIndex_Layered extends JLayeredPane {
    BoardAndIndex_Panel boardAndIndex_Panel = new BoardAndIndex_Panel();
    public BoardandIndex_Layered(){
        init_GridPane();

        this.add(boardAndIndex_Panel, new Integer(0));
    }
    void init_GridPane(){
        setLayout(null);
        setPreferredSize(new Dimension(550, 550));
        setBackground(Color.MAGENTA);
    }
}
