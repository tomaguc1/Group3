package Views.PlaceShips.GridShip;

import Controller.PlaceShipsController;
import Views.PlaceShips.PlaceShipsView;

import javax.swing.*;
import java.awt.*;

public class OceanButtonGrid_Panel extends JPanel  {
    JButton[][] buttonArray = new JButton[10][10];
    Tile[][] tiles = new Tile[10][10];

    public OceanButtonGrid_Panel(PlaceShipsController controller){
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(10, 10, 2, 2));
        this.setBounds(50, 0, 500, 500);

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tiles[i][j] = new Tile();

                //TODO : add action listener from controller
                // buttonArray[i][j].addActionListener(controller.getButtonClickListener(i, j));


            }
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.add(tiles[i][j]);
            }
        }
    }
//=-=- Tiles that form the ocean =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    class Tile extends JPanel{ // Model Board element

        Tile(){
            this.setPreferredSize(new Dimension(50, 50));
            this.setBackground(Color.red);
        }
    }
//--------------------------------------------------------------------------------------------------------
}
