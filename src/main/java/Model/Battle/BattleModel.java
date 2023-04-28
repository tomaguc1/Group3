package Model.Battle;

import Model.Player.PlayerModel;

public class BattleModel {
    public PlayerModel playerOne;
    public PlayerModel playerTwo;
    public boolean isPlayerTwoNext;

    public BattleModel(PlayerModel one, PlayerModel two) {
        this.playerOne = one;
        this.playerTwo = two;
        this.isPlayerTwoNext = false;
    }
}
