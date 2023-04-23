package Views.PlaceShips;

import Views.PlaceShips.GridShip.BoardAndIndex_Panel;
import Views.PlaceShips.MenuShips.ShipsMenu_Panel;
import Views.PlaceShips.ReadyToPlay.ReadyToPlay_Panel;

import javax.swing.*;
import java.awt.*;

public class PlaceShip_ContentPane extends JPanel {

    BoardAndIndex_Panel boardAndIndex_panel = new BoardAndIndex_Panel();
    ShipsMenu_Panel shipsMenu_panel = new ShipsMenu_Panel();
    ReadyToPlay_Panel readyToPlay_panel = new ReadyToPlay_Panel();

    public PlaceShip_ContentPane(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30 , 30));
        this.setPreferredSize(new Dimension(1280, 665));
        this.setBackground(Color.CYAN);

        this.add(boardAndIndex_panel);
        this.add(shipsMenu_panel);
        this.add(readyToPlay_panel);


        //TODO : Add the grid and hui And pick ship and ready as in your caiet toma
    }

}
