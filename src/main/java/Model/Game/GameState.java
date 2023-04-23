package Model.Game;

public enum GameState {
    ChooseSingleplayerOrMultiplayer,

    PrepareForBattle, // choose name and place ships

    ChooseFirstPlayer, // randomize who gets to start?

    PlayerSelectsTarget,
    TargetHit, // if opponent has ships left : goto PlayerSelectsTarget
               // if opponent is out of ships: goto PlayerOutOfShips
    TargetMiss, // goto switch player

    SwitchPlayer, // wait a few seconds while players switch
                  // and hide all boards

    PlayerOutOfShips, // game over
}
