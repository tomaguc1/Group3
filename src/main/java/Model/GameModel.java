package Model;

public class GameModel {

    private GameState state;
    private GameMode mode;
    private PlayerModel playerOne;
    private PlayerModel playerTwo;

    public GameModel() {
        this.state = GameState.ChooseSingleplayerOrMultiplayer;
        this.mode = GameMode.Singleplayer;
        this.playerOne = new PlayerModel("Vadim");
        this.playerTwo = new PlayerModel("Galea");
    }

    public GameState getState() {
        return this.state;
    }

    public void setState(GameState newValue) {
        this.state = newValue;
    }

    public GameMode getMode() {
        return this.mode;
    }

    public void setMode(GameMode newValue) {
        this.mode = newValue;
    }

}
