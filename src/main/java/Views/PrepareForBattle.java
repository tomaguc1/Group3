package Views;

import Controller.GameController;
import Views.PlaceShips.PlaceShip_ChoosePlyrPane;
import Views.PlaceShips.PlaceShip_ContentPane;

import java.awt.*;

public class PrepareForBattle extends MenuPanel {  // Our Pannel that contains the

    public PrepareForBattle(GameController controller) {
        super(controller);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setBackground(Color.YELLOW);

        this.add(controller.getPlaceShipsView());



    }
}
