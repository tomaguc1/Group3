package Model.Player;

import Model.Board.Board;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;

import java.util.ArrayList;

public class PlayerModel {
    private String name;
    private Board board;
    private ArrayList<Ship> ships;
    private PlayerType type;


    //TODO : Method that fetches ships noses, types, and direction from controller that calls view on lock in

    public PlayerModel(Kompic kompic, ArrayList<Ship_Type> types) {          // Constructor fot the AI
        this.type = PlayerType.Kompic;
        this.name = "BattleshipGPT";
        this.ships = kompic.placeShips(types);
        if (this.ships.size() != types.size())
            throw new IllegalStateException("cheater blin");
        this.board = new Board(this.ships);
    }

    public PlayerModel(String name, ArrayList<Ship> ships) {// Constructor for the human player
        this.type = PlayerType.Human;
        this.name = name;
        this.ships = ships;
        this.board = new Board(ships);

        //TODO : Instantiate shipCollection when controller fetches GUI shipElements with nose, type and direction
    }


}
