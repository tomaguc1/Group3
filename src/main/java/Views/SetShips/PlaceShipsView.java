package Views.SetShips;

import Controller.PlaceShipsController;
import Helpers.ImageLibrary;
import Views.SetShips.Grid.Layer0_panel;
import Views.SetShips.Grid.Layer1_panel;

import javax.swing.*;
import java.awt.*;

public class PlaceShipsView extends JPanel {

    public static ImageLibrary graphics = new ImageLibrary();

    private PlaceShipsController setShipController;
    SetShipLayerPane layerPane;


    public PlaceShipsView(PlaceShipsController controller) {
        setShipController = controller;
        layerPane = new SetShipLayerPane();
        initGuiFrame();
        this.add(layerPane);

    }

    private void initGuiFrame(){
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("SetShipFrame !");
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBounds(0, 0, 1280, 720);
        setSize(1280, 720);
//        setResizable(false);
        setVisible(true);
    }








//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//      Inner class for the LayerPane which will be placed on ShipPlace view Frame
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    private static class SetShipLayerPane extends JLayeredPane {
        JPanel lay0, lay1;

        SetShipLayerPane() {
            initGuiLayerPane();
        }
    


    /*  Method used in constructor that initialized the base structure of the layered pane
                                                                        for placing ships*/
        private void initGuiLayerPane() {
            this.setLayout(null);
            this.setBounds(0, 0, 1280, 720);
    
            lay0 = new Layer0_panel();
    
            lay1 = new Layer1_panel();
    
    
            this.add(lay0, new Integer(0));
            this.add(lay1, new Integer(1));
            this.setBackground(Color.BLUE);
            this.setPreferredSize(new Dimension(1280, 720));
            this.setVisible(true); // Add at the end
        }
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


}
