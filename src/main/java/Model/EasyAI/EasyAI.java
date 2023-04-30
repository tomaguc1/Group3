package Model.EasyAI;

import Model.Board.Board;
import Model.Board.BoardElement;
import Model.Player.Kompic;
import Model.Position;
import Model.Ship.Direction;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;

import java.util.Random;
import java.util.ArrayList;

public class EasyAI implements Kompic {
    // public static void main(String[] args) {
        
    // }

    @Override
    public ArrayList<Ship> placeShips(ArrayList<Ship_Type> types) {
        ArrayList<Ship> ships = new ArrayList<>();
        Random rand = new Random();
        int min = 0;
        int max = 99;
        int i=0;

    	while(i < types.size()) {
            int testing = rand.nextInt(max - min + 1) + min;//random number for a coordinate in the array

            Position position = new Position(testing % 10, testing / 10);
            Direction direction = testing % 2 == 0 ? Direction.HORIZONTAL : Direction.VERTICAL;
            Ship ship = new Ship(types.get(i), position, direction);
            boolean isGood = true;
            for (Ship other: ships) {
                if (!ship.isInBounds() || ship.doesItOverlapWith(other))
                    isGood = false;
            }

            if(isGood) {
                //method to set ship
                ship.setIsPlaced(true);
                ships.add(ship);// Removes the space from the array, keeps array length
            } else {
                i=i-1;
            }
            i++;
        }

        return ships;
    }


    @Override
    public Position attack(Board board, ArrayList<Ship_Type> types) {
        Random rand = new Random();


        int i = 0;
        while(i < 100) {

            int min = 0;
            int max = 99 - i;

            int rCoordinate = rand.nextInt(max - min + 1) + min;//random number for a coordinate in the array

            Position position = new Position(rCoordinate % 10, rCoordinate / 10);
            BoardElement boardElement = board.getBoardElementAtPosition(position);

            if (!boardElement.getWasHit()) {//an array containing all the coordinates in which enemy ships are placed) {
                //method to set missile
                return position;
                //end turn
            }

            i++;
        }

        return new Position(0, 0);
    }
}
