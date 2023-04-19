package Views.Menu;

import Controller.MainMenuController;

import java.awt.*;

public class ChooseServerOrClient extends MenuPanel {
    public ChooseServerOrClient(MainMenuController controller) {
        super(controller);

        this.setBackground(Color.green);

//        HostClient_Pane content = new HostClient_Pane();
//        this.add(content);



        this.add(controller.createServerButton());
        this.add(controller.createClientButton());
    }
}
