package Controller;

import Model.SetShips.PlaceShipsModel;
import Views.SetShips.PlaceShipsView;
import Views.PlaceShips.PlaceShipsView1;

public class PlaceShipsController {
    PlaceShipsView1 view;
    PlaceShipsModel model;

    PlaceShipsController() {
        view = new PlaceShipsView1(this);
        model = new PlaceShipsModel();
    }

}
