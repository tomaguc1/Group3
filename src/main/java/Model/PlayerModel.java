package Model;

import Model.Board.Board;

public class PlayerModel {
    private String name;
    private Board board;
    private PlayerType type;

    public PlayerModel() {          // Constructor fot the AI
        this.name = "BattleshipGPT";
        this.board = new Board();
        this.type = PlayerType.Kompic;
    }

    public PlayerModel(String name) {// Constructor for the human player
        this.name = name;
        this.board = new Board();
        this.type = PlayerType.Human;
    }

    public enum PlayerType {
        Human,
        Kompic,
    }

}
