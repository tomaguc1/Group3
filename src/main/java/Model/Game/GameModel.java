package Model.Game;

import Model.Player.PlayerModel;

public class GameModel {

    public GameState state;
    public GameMode mode;
    public PlayerModel playerOne;
    public PlayerModel playerTwo;

    public GameModel() {
        this.state = GameState.ChooseSingleplayerOrMultiplayer;
        this.mode = GameMode.Singleplayer;
    }

}
