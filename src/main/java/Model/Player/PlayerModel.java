package Model.Player;

import Model.Board.Board;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;

import java.util.ArrayList;

public class PlayerModel {
    private String name;
    private Board board;
    private PlayerType type;

    static Ship_Type[] shipSetOfTypes = {Ship_Type.SUBMARINE, Ship_Type.SUBMARINE,
            Ship_Type.DESTROYER, Ship_Type.BATTLESHIP, Ship_Type.CARRIER };


    private ArrayList<Ship> shipCollection;
    //TODO : Method that fetches ships noses, types, and direction from controller that calls view on lock in

    public PlayerModel() {          // Constructor fot the AI
        this.name = "BattleshipGPT";
        this.board = new Board();
        this.type = PlayerType.Kompic;
    }

    public PlayerModel(String name) {// Constructor for the human player
        this.name = name;
        this.board = new Board();
        this.type = PlayerType.Human;

        //TODO : Instantiate shipCollection when controller fetches GUI shipElements with nose, type and direction
    }


}
