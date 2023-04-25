package Views.PlaceShips.GridShip;

import Controller.PlaceShipsController;
import Model.Position;
import Views.PlaceShips.PlaceShipsView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardAndIndex_Panel extends JPanel {
    boardGrid_Panel boardGrid;

    JPanel letterIndex = new JPanel();
    JPanel numberIndex = new JPanel();

    public BoardAndIndex_Panel(PlaceShipsController controller) {
        boardGrid = new boardGrid_Panel(controller);
        init_IndexPanes();

        this.add(boardGrid);
    }

    public void clearShips() {
        this.boardGrid.clearShips();
    }

    public void addShip(ArrayList<Position> list) {
        this.boardGrid.addShip(list);
    }

    public void highlightCoordinates(boolean valid, ArrayList<Position> list) {
        this.boardGrid.highlightCoordinates(valid, list);
    }

//=-=-  Initializes the grid indexes and leaves space for the ocean grid of button to pe placed =-=-=-=-=-=-=-=
    void init_IndexPanes(){
        setLayout(null);
        setPreferredSize(new Dimension(550, 550));
        setBackground(Color.MAGENTA);

        String[] int_labels = {"1","2","3","4","5","6","7","8","9","10"};
        String[] letter_labels = {"A","B","C","D","E","F","G","H","I","J"};


        numberIndex.setLayout(new GridLayout(10, 1));
        numberIndex.setBounds(0, 0, 50, 500);
        numberIndex.setBackground(Color.LIGHT_GRAY);
        for (String i : int_labels){

            numberIndex.add(new JButton(i));
        }

        letterIndex.setLayout(new GridLayout(1, 10));
        letterIndex.setBounds(50, 500, 500, 50);
        letterIndex.setBackground(Color.GRAY);
        for (String i : letter_labels){
            letterIndex.add(new JButton(i));
        }

        add(letterIndex);
        add(numberIndex);
//---------------------------------------------------------------------------------------------------------

    }
}
