package Controller;

import Model.SetShips.PlaceShipsModel;
import Views.PlaceShips.PlaceShipsView1;
import io.cucumber.java.en_lol.BUT;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceShipsController {
    PlaceShipsView1 view;
    PlaceShipsModel model;

    PlaceShipsController() {
        view = new PlaceShipsView1(this);
        model = new PlaceShipsModel();
    }



    static class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked at row " + row + " and column " + col);

        }
    }
    public ButtonClickListener getButtonClickListener(int x, int y){
        return new ButtonClickListener(x, y);
    }

}
