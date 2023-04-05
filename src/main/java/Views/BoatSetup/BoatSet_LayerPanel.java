package Views.BoatSetup;

import Views.BoatSetup.Grid.Tile_Button;
import Views.BoatSetup.Grid.Tile_Grid;
import Views.UI_Panels;

import javax.swing.*;
import java.awt.*;

public class BoatSet_LayerPanel extends JLayeredPane {
    JPanel Npanel, SPanel, Epanel, Wpanel, Gridpanel, Wpanel_inex, Spanel_index_pane;

    public BoatSet_LayerPanel(){
        this.setLayout(new BorderLayout());
                //Fillers
                Npanel = new UI_Panels(1, 50, Color.LIGHT_GRAY);
                Epanel = new UI_Panels(430,  1, Color.MAGENTA);

        //West Pannel Indexes config
            String[] char_labels = {"A","B","C","D","E","F","G","H","I","J"};
            Wpanel = new UI_Panels(350, 1, Color.RED);
            Wpanel.setLayout(new BorderLayout());
                Wpanel_inex = new UI_Panels(40, 1, Color.ORANGE);
                Wpanel_inex.setLayout(new GridLayout(10,1));
                Wpanel.add(Wpanel_inex, BorderLayout.EAST);
                for (String i : char_labels){
                    Wpanel_inex.add(new Tile_Button(i));
                }

        //South Pannel Indexes config
            String[] int_labels = {"1","2","3","4","5","6","7","8","9","10"};
            SPanel = new UI_Panels(1280, 170, Color.BLACK);
            SPanel.setLayout(new BorderLayout());
                Spanel_index_pane = new UI_Panels(1280,40, Color.GRAY);
                Spanel_index_pane.setLayout(new BorderLayout());
                    //Fillers
                    Spanel_index_pane.add(new UI_Panels(350, 20, Color.MAGENTA), BorderLayout.WEST);
                    Spanel_index_pane.add(new UI_Panels(430,20, Color.CYAN), BorderLayout.EAST);
                JPanel SPanel_index = new UI_Panels(500,50, Color.YELLOW);
                SPanel_index.setLayout(new GridLayout(1,10));
                for (String i : int_labels){
                    SPanel_index.add(new Tile_Button(i));
                }

                Spanel_index_pane.add(SPanel_index);


            SPanel.add(Spanel_index_pane, BorderLayout.NORTH);








        Gridpanel = new Tile_Grid(); // size : 720 - 170 - 50


        this.add(Npanel, BorderLayout.NORTH);
        this.add(SPanel, BorderLayout.SOUTH);
        this.add(Wpanel, BorderLayout.WEST);
        this.add(Epanel, BorderLayout.EAST);
        this.add(Gridpanel, BorderLayout.CENTER);
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(1280,720));
        this.setVisible(true); // Add at the end
    }


}
