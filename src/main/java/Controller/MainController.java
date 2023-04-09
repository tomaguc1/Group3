package Controller;
import Model.Main.MainModel;
import Views.MainView;

public class MainController {

    MainModel model;
    MainView view;

    public MainController(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
        this.updateView();
    }

    void updateView() {
        switch (this.model.getScreen()) {
            case ChooseServerOrClient:
                this.view.showMenu();
                break;
            case ServerWaitingForConnection:

                break;
            case ClientProvideAddress:

                break;
            case ClientConnecting:

                break;
            case Game:
                this.view.showGame();
                break;
        }
    }

}
