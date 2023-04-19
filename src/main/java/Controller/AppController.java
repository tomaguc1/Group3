package Controller;



public class AppController {
    private MainMenuController menuController;
    private ShipSetController shipSetController;




    public void menuStart(){
        menuController = new MainMenuController(this);
    }


    public static void main(String[] args) {
        AppController app = new AppController();
        app.menuStart();
    }


/*  Method that instantiates the MVC of the set-battleship  */

    public void setShipSet(){

    }
}
