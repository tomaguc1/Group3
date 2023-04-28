package Model.Ship;

import Model.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlaceShipsModel {
    public String playerName;

    public ArrayList<Ship> ships;

    public boolean isShipSelected;
    public int selectedShipIndex;

    public boolean isCursorOverTheBoard;
//    public Position hoveredTileCoordinates;

    public PlaceShipsModel(ArrayList<Ship_Type> types) {
        this.playerName = "";

        this.ships = new ArrayList<Ship>();
        for (Ship_Type type: types) {
            this.ships.add(new Ship(type));
        }

        this.isShipSelected = false;
        this.selectedShipIndex = 0;

        this.isCursorOverTheBoard = false;
//        this.hoveredTileCoordinates = new Position(0, 0);
    }

    public ArrayList<Position> getHighlightCoordinates() {
        ArrayList<Position> list = new ArrayList<Position>();

        if (!this.isShipSelected || !this.isCursorOverTheBoard)
            return new ArrayList<>();

        Ship ship = this.ships.get(this.selectedShipIndex);
        return ship.getAllPositions();
    }

    public boolean isShipPlacementValid(int index, boolean requirePlacement) {
        Ship selectedShip = this.ships.get(index);

        if (requirePlacement && !selectedShip.getIsPlaced())
            return false;

        if (!selectedShip.isInBounds())
            return false;

        for (int i = 0; i < this.ships.size(); i++) {
            if (i == index)
                continue;

            Ship other = this.ships.get(i);
            if (!other.getIsPlaced())
                continue;

            if (selectedShip.doesItOverlapWith(this.ships.get(i)))
                return false;
        }

        return true;
    }

    public boolean isValid() {
        if (this.playerName.isEmpty())
            return false;

        for (int i = 0; i < this.ships.size(); i++) {
            if (!this.isShipPlacementValid(i, true))
                return false;
        }

        return true;
    }
}
