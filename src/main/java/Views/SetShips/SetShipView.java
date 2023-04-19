package Views.SetShips;

import Controller.ShipSetController;
import Views.SetShips.Grid.Layer0_panel;
import Views.SetShips.Grid.Layer1_panel;

import javax.swing.*;
import java.awt.*;

public class SetShipView extends JLayeredPane {
    private ShipSetController shipSetController;

    JPanel lay0, lay1;

    public SetShipView(ShipSetController controller){
        shipSetController = controller;
        initGui();
    }
/*  Method used in constructor that initialized the base structure of the layered pane
                                                                    for placing ships*/
    private void initGui(){
        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);

        lay0 = new Layer0_panel();

        lay1 = new Layer1_panel();


        this.add(lay0, new Integer(0));
        this.add(lay1, new Integer(1));
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(1280,720));
        this.setVisible(true); // Add at the end
    }

}
