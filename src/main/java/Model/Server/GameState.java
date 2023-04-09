package Model.Server;

public enum GameState {

    PlaceShips, // wait for both parties

    ChooseFirstPlayer, // randomize who gets to start?

    PlayerSelectsTarget,
    TargetHit,
    TargetMiss,

    SwitchPlayer,

    PlayerOutOfShips,

    AskForRematch,

    Exit,

}
