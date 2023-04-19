package Model.Main;
import java.util.Observable;

public class MainModel extends Observable {

    private Screen screen;

    public MainModel() {
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
