package Model.Game;

import Model.Difficulty;
import Model.Player.PlayerModel;
import Model.Ship.Ship_Type;

import java.util.ArrayList;

public class GameModel {

    public GameState state;
    public GameMode mode;
    public Difficulty difficulty;
    public ArrayList<Ship_Type> types;

    public PlayerModel playerOne;
    public PlayerModel playerTwo;

    public GameModel() {
        this.state = GameState.ChooseSingleplayerOrMultiplayer;
        this.mode = GameMode.Singleplayer;
        this.difficulty = Difficulty.Easy;

        this.types = new ArrayList<>();
        this.types.add(Ship_Type.SUBMARINE);
        this.types.add(Ship_Type.CARRIER);
        this.types.add(Ship_Type.BATTLESHIP);
    }

}
