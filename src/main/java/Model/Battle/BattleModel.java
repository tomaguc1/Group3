package Model.Battle;

import Model.Player.PlayerModel;
import Model.Ship.Ship_Type;

import java.util.ArrayList;

public class BattleModel {
    public PlayerModel playerOne;
    public PlayerModel playerTwo;
    public boolean isPlayerTwoNext;
    public boolean isPlayerReady;
    public ArrayList<Ship_Type> types;

    public BattleModel(PlayerModel one, PlayerModel two, ArrayList<Ship_Type> types) {
        this.playerOne = one;
        this.playerTwo = two;
        this.isPlayerTwoNext = false;
        this.isPlayerReady = false;
        this.types = types;
    }

    public PlayerModel playerOnTurn() {
        return this.isPlayerTwoNext ? this.playerTwo : this.playerOne;
    }

    public PlayerModel playerOpponent() {
        return this.isPlayerTwoNext ? this.playerOne : this.playerTwo;
    }

    public void switchPlayers() {
        this.isPlayerTwoNext = !this.isPlayerTwoNext;
    }

    public boolean isGameOver() {
        return this.getWinner() != null;
    }

    public PlayerModel getWinner() {
        if (this.playerOne.board.getHealth() == 0) {
            return this.playerTwo;
        }
        if (this.playerTwo.board.getHealth() == 0) {
            return this.playerOne;
        }
        return null;
    }
}
