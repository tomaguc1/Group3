package Model.MainMenu;
import Model.Screen;

import java.util.Observable;

public class MainMenuModel extends Observable {

    private Screen screen;

    public MainMenuModel() {
        this.screen = Screen.ChooseServerOrClient;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void setScreen(Screen newValue) {
        Screen oldValue = this.screen;
        this.screen = newValue;

//        if (oldValue != newValue) {
//            this.setChanged();
//            this.notifyObservers(newValue);
//        }
    }

}
