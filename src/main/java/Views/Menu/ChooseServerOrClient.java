package Views.Menu;

import Controller.MainController;
import Views.Menu1_ServerConnection.HostClient_Pane;

import java.awt.*;

public class ChooseServerOrClient extends MenuPanel {
    public ChooseServerOrClient(MainController controller) {
        super(controller);

        this.setBackground(Color.green);

//        HostClient_Pane content = new HostClient_Pane();
//        this.add(content);



        this.add(controller.createServerButton());
        this.add(controller.createClientButton());
    }
}
