package Views.BoatSetup;

import Views.BoatSetup.Grid.Layer0_panel;
import Views.BoatSetup.Grid.Layer1_panel;

import javax.swing.*;
import java.awt.*;

public class BoatSet_LayerPanel extends JLayeredPane {
    JPanel lay0, lay1;

    public BoatSet_LayerPanel(){
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
    //WHAT I NEED
    //Placement X = 350 ; Y = 50
    //Dimensions W = 930 ; H = 500

    // North -- H 50
    // West  -- W 350




}
