package Model.Player;

import Model.Board.Board;
import Model.Position;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;

import java.util.ArrayList;

public interface Kompic {
    ArrayList<Ship> placeShips(ArrayList<Ship_Type> types);
    Position attack(Board board, ArrayList<Ship_Type> types);
}
