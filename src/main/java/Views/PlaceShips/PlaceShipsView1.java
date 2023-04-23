package Views.PlaceShips;

import Controller.PlaceShipsController;

import javax.swing.*;
import java.awt.*;

public class PlaceShipsView1 extends JPanel {
    PlaceShipsController controller;

    PlaceShip_ContentPane contentPane;
    PlaceShip_ChoosePlyrPane plyChoosePane;

    public PlaceShipsView1(PlaceShipsController controller){
        this.controller = controller;

        this.contentPane = new PlaceShip_ContentPane();
        this.plyChoosePane = new PlaceShip_ChoosePlyrPane();

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setPreferredSize(new Dimension(1280,720));
        this.setBackground(Color.yellow);

        this.add(plyChoosePane);
        this.add(contentPane);


    }
}
