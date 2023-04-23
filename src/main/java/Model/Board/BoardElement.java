package Model.Board;

public class BoardElement {

    private BoardElement_Type elementType;
    public BoardElement_Type getElementType() { return elementType; }
    public void setElementType(BoardElement_Type elementType) { this.elementType = elementType; }

    public BoardElement(){
        elementType = BoardElement_Type.Water;
    }
}
