package Views.PlaceShips.GridShip;

import Controller.PlaceShipsController;
import Views.PlaceShips.PlaceShipsView1;
import io.cucumber.java.sl.In;

import javax.swing.*;
import java.awt.*;

public class OceanButtonGrid_Panel extends JPanel  {
    PlaceShipsController controller;
    JButton[][] buttonArray = new JButton[10][10];

    public OceanButtonGrid_Panel(PlaceShipsController ctr){
        this.controller = PlaceShipsView1.controller;

        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(10,10));
        this.setBounds(50, 0, 500, 500);

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                buttonArray[i][j] = new JButton();
                buttonArray[i][j].setContentAreaFilled(false);
                buttonArray[i][j].addActionListener(controller.getButtonClickListener(i, j));
//                buttonArray[i][j].setText(Integer.toString(i) + Integer.toString(j));
            }
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.add(buttonArray[i][j]);
            }
        }
    }
}
