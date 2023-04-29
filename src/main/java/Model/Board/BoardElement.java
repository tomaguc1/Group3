package Model.Board;

//<<<<<<< HEAD
import Model.Position;
//import javafx.geometry.Pos;
//=======
//>>>>>>> branch 'main' of https://github.com/tomaguc1/Group3.git

public class BoardElement {

    protected boolean wasHit;
    public boolean getWasHit() { return this.wasHit; }
    public void setWasHit(boolean wasHit) { this.wasHit = true; }

    public BoardElement(){
        this.wasHit = false;
    }
}
