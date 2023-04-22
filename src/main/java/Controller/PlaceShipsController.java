package Controller;

import Model.SetShips.PlaceShipsModel;
import Views.SetShips.PlaceShipsView;

public class PlaceShipsController {
    PlaceShipsView view;
    PlaceShipsModel model;

    PlaceShipsController() {
        view = new PlaceShipsView(this);
    }

}
