package Model.Board;

import Model.Position;
//import javafx.geometry.Pos;

public class BoardElement {

    private Position elementPosition;
    public Position getElementPosition() { return elementPosition; }
    public void setElementPosition(Position pos){ this.elementPosition = pos; }

    private boolean wasHit;
    public boolean getElementHitBool() { return this.wasHit; }
    public void setWasHit() { this.wasHit = true; }
//    public void setWasHit(BoardElement boardElement) { boardElement.wasHit = true; } // No bool arg because wasHit is boolean and not interchangable

    public BoardElement(){
        this.wasHit = false;

    }
}
