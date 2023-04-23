package Model.Ship.SubclassesShip;

import Model.Position;

public interface ShipHealthInterface {

    //TODO : Investigate default method
    default void damageShip(Position position, boolean[] shipHealth){
        // TODO : Get ship occupied tiles and switch to true the correspondent position in the array
    }

}
