package Controller;

import Helpers.DocumentChangedListener;
import Helpers.MouseClickedListener;
import Helpers.MouseHoverListener;
import Model.Position;
import Model.Ship.PlaceShipsModel;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;
import Views.PlaceShips.PlaceShipsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlaceShipsController {
    GameController gameController;
    PlaceShipsView view;
    PlaceShipsModel model;

    JComponent componentSubmitShipPlacement;
    
    PlaceShipsController(GameController gameController, ArrayList<Ship_Type> types, String hint) {
        this.gameController = gameController;
        this.model = new PlaceShipsModel(types);
        this.view = new PlaceShipsView(this, hint);
        
        if (this.componentSubmitShipPlacement == null)
            throw new NullPointerException();
        
        this.updateView();
    }
    
    private void updateView() {
        boolean isModelValid = this.model.isValid();
        this.componentSubmitShipPlacement.setEnabled(isModelValid);

        this.view.clearShips();
        for (int i = 0; i < this.model.ships.size(); i++) {
            Ship ship = this.model.ships.get(i);
            if (ship.getIsPlaced()) {
                this.view.addShipToBoard(ship.getAllPositions());
            } else {
                boolean isSelected = this.model.isShipSelected && this.model.selectedShipIndex == i;
                this.view.addShipToMenu(ship.getShipType(), i, isSelected);
            }
        }

        boolean hoverValid = this.model.isShipPlacementValid(this.model.selectedShipIndex, false);
        this.view.highlightCoordinates(hoverValid, this.model.getHighlightCoordinates());

        this.view.validate();
        this.view.repaint();
    }
    
    public ActionListener getButtonClickListener(int row, int col){
        return actionEvent -> {
            System.out.println("Button clicked at row " + row + " and column " + col);
        };
    }
    
    public DocumentChangedListener actionUpdateName(JTextField textField) {
        return documentEvent -> {
            this.model.playerName = textField.getText();
            updateView();
        };
    }
    
    public ActionListener actionSubmitShipPlacement(JComponent component) {
        this.componentSubmitShipPlacement = component;
        return actionEvent -> {
            this.gameController.submitPlayerData(this.model.playerName, this.model.ships);
        };
    }

    public MouseClickedListener actionSelectShipFromMenu(int index) {
        return mouseEvent -> {
            this.model.isShipSelected = true;
            this.model.selectedShipIndex = index;
            this.updateView();
        };
    }

    public MouseHoverListener actionHoverOverTile(Position position) {
        return (mouseEvent, isHovering) -> {
            this.model.isCursorOverTheBoard = isHovering;
            if (this.model.isShipSelected && isHovering) {
                Ship ship = this.model.ships.get(this.model.selectedShipIndex);
                ship.setPosition(position);
            }
            if (this.model.isShipSelected) {
                this.updateView();
            }
        };
    }

    public MouseClickedListener actionRotateShip() {
        return mouseEvent -> {
            // only right click
            if (mouseEvent.getButton() != MouseEvent.BUTTON3)
                return;

            if (this.model.isShipSelected && this.model.isCursorOverTheBoard) {
                Ship ship = this.model.ships.get(this.model.selectedShipIndex);
                ship.rotate();
                this.updateView();
            }
        };
    }

    public MouseClickedListener actionPlaceShip() {
        return mouseEvent -> {
            // only left click
            if (mouseEvent.getButton() != MouseEvent.BUTTON1)
                return;

            if (!this.model.isShipSelected || !this.model.isCursorOverTheBoard)
                return;

            if (!this.model.isShipPlacementValid(this.model.selectedShipIndex, false))
                return;

            Ship ship = this.model.ships.get(this.model.selectedShipIndex);
            ship.setIsPlaced(true);
            this.model.isShipSelected = false;
            this.updateView();
        };
    }

}
