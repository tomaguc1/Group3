package Views;

import Controller.GameController;
import Views.PlaceShips.PlaceShip_ChoosePlyrPane;
import Views.PlaceShips.PlaceShip_ContentPane;

import java.awt.*;

public class PrepareForBattle extends MenuPanel {  // Our Pannel that contains the

    PlaceShip_ChoosePlyrPane upperPanel = new PlaceShip_ChoosePlyrPane();
    PlaceShip_ContentPane contentPanel = new PlaceShip_ContentPane();

    public PrepareForBattle(GameController controller) {
        super(controller);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setBackground(Color.MAGENTA);

//        this.add(controller.getPlaceShipsView()); FIXME : Sorry Frid I commented this
        this.add(upperPanel);
        this.add(contentPanel);


    }
}
