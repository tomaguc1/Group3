package Model.Board;

//<<<<<<< HEAD
import Model.Position;
//import javafx.geometry.Pos;
//=======
//>>>>>>> branch 'main' of https://github.com/tomaguc1/Group3.git

public class BoardElement {

    private boolean wasHit;
    public boolean getWasHit() { return this.wasHit; }
    public void setWasHit() { this.wasHit = true; } // used to recive (boolean wasHit) but did nothing with imput

    public BoardElement(){
        this.wasHit = false;
    }
}
