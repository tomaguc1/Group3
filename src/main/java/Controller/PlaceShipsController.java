package Controller;

import Helpers.DocumentChangedListener;
import Model.SetShips.PlaceShipsModel;
import Views.PlaceShips.PlaceShipsView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PlaceShipsController {
    GameController gameController;
    PlaceShipsView view;
    PlaceShipsModel model;

    JComponent componentSubmitShipPlacement;
    
    PlaceShipsController(GameController gameController) {
        this.gameController = gameController;
        this.model = new PlaceShipsModel();
        this.view = new PlaceShipsView(this);
        
        if (this.componentSubmitShipPlacement == null)
            throw new NullPointerException();
        
        this.updateView();
    }
    
    private void updateView() {
        boolean isModelValid = this.model.isValid();
        this.componentSubmitShipPlacement.setEnabled(isModelValid);
    }
    
    public ActionListener getButtonClickListener(int row, int col){
        return actionEvent -> {
            System.out.println("Button clicked at row " + row + " and column " + col);
        };
    }
    
    public DocumentChangedListener actionUpdateName(JTextField textField) {
        return documentEvent -> {
            this.model.name = textField.getText();
            updateView();
        };
    }
    
    public ActionListener actionSubmitShipPlacement(JComponent component) {
        this.componentSubmitShipPlacement = component;
        return actionEvent -> {
            System.out.println("submit ship placement");
            
        };
    }

}
