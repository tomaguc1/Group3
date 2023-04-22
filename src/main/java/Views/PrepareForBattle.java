package Views;

import Controller.GameController;

import java.awt.*;

public class PrepareForBattle extends MenuPanel {
    public PrepareForBattle(GameController controller) {
        super(controller);

        this.setBackground(Color.green);

        this.add(controller.getPlaceShipsView());

//        HostClient_Pane content = new HostClient_Pane();
//        this.add(content);


//
//        this.add(controller.createSingleplayerButton());
//        this.add(controller.createMultiplayerButton());
    }
}
