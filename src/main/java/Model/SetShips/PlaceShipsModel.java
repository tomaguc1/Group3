package Model.SetShips;

public class PlaceShipsModel {
    public String name;

    public PlaceShipsModel() {
        this.name = "";
    }
    
    public boolean isValid() {
        return this.name.isEmpty() == false;
    }
}
