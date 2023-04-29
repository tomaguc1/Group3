package Controller;

import Helpers.MouseClickedListener;
import Model.Battle.BattleModel;
import Model.Board.BoardElement;
import Model.Board.ShipElement;
import Model.Board.WaterElement;
import Model.Player.PlayerModel;
import Model.Player.PlayerType;
import Model.Position;
import Model.Ship.Ship_Type;
import Views.BattleUI.BattleView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BattleController {
    BattleModel model;
    BattleView view;

    public BattleController(PlayerModel playerOne, PlayerModel playerTwo, ArrayList<Ship_Type> types) {
        this.model = new BattleModel(playerOne, playerTwo, types);
        this.view = new BattleView(this);
        this.updateView();
    }

    private void updateView() {
        PlayerModel player = this.model.playerOnTurn();
        PlayerModel opponent = this.model.playerOpponent();

        this.view.setBoardsVisible(false);
        this.view.clearPlayerData();
        this.view.populateAllyBoard(player.board);
        this.view.populateEnemyBoard(opponent.board);
        // this.view.addWeapons();

        this.view.setStatusText(player.name + "'s turn");
        this.view.setReadyText(player.name + ", are you ready?");
        this.view.setBoardsVisible(this.model.isPlayerReady);

        this.view.validate();
        this.view.repaint();
    }

    public boolean kompicAttack() {
        if (this.model.playerOpponent().type == PlayerType.Human)
            return false;

        PlayerModel player = this.model.playerOnTurn();
        PlayerModel kompic = this.model.playerOpponent();

        for (int i = 0; i < 100; i++) {
            Position position = kompic.kompic.attack(player.board, this.model.types);
            BoardElement tile = player.board.getBoardElementAtPosition(position);

            if (tile.getWasHit())
                break;

            tile.setWasHit();

            if (this.model.isGameOver()) {
                this.updateView();
                JOptionPane.showMessageDialog(null, "Too bad, " + player.name + ", you lose!");
                return true;
            }

            if (tile instanceof WaterElement)
                break;
        }

        return true;
    }

    public MouseClickedListener actionAttack(Position position) {
        return mouseEvent -> {
            if (this.model.isGameOver())
                return;

            PlayerModel player = this.model.playerOnTurn();
            PlayerModel opponent = this.model.playerOpponent();

            BoardElement tile = opponent.board.getBoardElementAtPosition(position);
            if (tile.getWasHit())
                return;

            tile.setWasHit();

            if (tile instanceof ShipElement) {
                PlayerModel winner = this.model.getWinner();
                if (winner != null) {
                    this.updateView();
                    JOptionPane.showMessageDialog(null, "Congrats, " + winner.name + ", you win!");
                    return;
                }
            } else if (tile instanceof WaterElement) {
                this.updateView();

                if (this.kompicAttack()) {
                    this.updateView();
                    return;
                }

                JOptionPane.showMessageDialog(null, "oh no, you missed!");
                this.model.isPlayerReady = false;
                this.model.switchPlayers();
            }

            this.updateView();
        };
    }


    public ActionListener actionReady() {
        return actionEvent -> {
            this.model.isPlayerReady = true;
            this.updateView();
        };
    }

}
