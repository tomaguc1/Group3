package Model.ShipPlacement;

import Model.Ship.Direction;
import Model.Ship.Ship;

public class Placement {
    public Boolean validPlacement(Ship ship,Integer x,Integer y) {
        if (ship.getDirection() == Direction.HORIZONTAL) {
            if (x + ship.getLength() > 10)  {
                return false;
            }
        } else {
            if (y + ship.getLength() > 10)  {
                return false;
            }
        }
        return true;
    }
}
