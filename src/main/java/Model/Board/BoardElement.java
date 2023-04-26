package Model.Board;


public class BoardElement {

    private boolean wasHit;
    public boolean getWasHit() { return this.wasHit; }
    public void setWasHit() { this.wasHit = true; }

    public BoardElement(){
        this.wasHit = false;
    }
}
