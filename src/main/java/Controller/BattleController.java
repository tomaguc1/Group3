package Controller;

import Model.Battle.BattleModel;
import Model.Player.PlayerModel;
import Views.BattleUI.BattleView;

public class BattleController {
    BattleModel model;
    BattleView view;

    public BattleController(PlayerModel playerOne, PlayerModel playerTwo) {
        this.model = new BattleModel(playerOne, playerTwo);
        this.view = new BattleView(this);
    }

}
