package Views.PlaceShips.GridShip;

import Views.PlaceShips.PlaceShipsView1;

import javax.swing.*;
import java.awt.*;

public class BoardAndIndex_Panel extends JPanel {
    OceanButtonGrid_Panel buttonGrid;

    JPanel letterIndex = new JPanel();
    JPanel numberIndex = new JPanel();

    public BoardAndIndex_Panel(){
        buttonGrid = new OceanButtonGrid_Panel(PlaceShipsView1.controller);
        init_GridPane();

        this.add(buttonGrid);
    }



    /**Initializes the grid indexes and leaves space for the ocean grid of button to pe placed
     *
     * @return
     */
    void init_GridPane(){
        setLayout(null);
        setPreferredSize(new Dimension(550, 550));
        setBackground(Color.MAGENTA);

        String[] int_labels = {"1","2","3","4","5","6","7","8","9","10"};
        String[] leter_labels = {"A","B","C","D","E","F","G","H","I","J"};

        numberIndex.setLayout(new GridLayout(10, 1));
        numberIndex.setBounds(0, 0, 50, 500);
        numberIndex.setBackground(Color.LIGHT_GRAY);
        for (String i : int_labels){
            numberIndex.add(new Tile_Button(i));
        }

        letterIndex.setLayout(new GridLayout(1, 10));
        letterIndex.setBounds(50, 500, 500, 50);
        letterIndex.setBackground(Color.GRAY);
        for (String i : leter_labels){
            letterIndex.add(new Tile_Button(i));
        }


        add(letterIndex);
        add(numberIndex);


    }
}
