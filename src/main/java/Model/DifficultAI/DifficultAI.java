package Model.DifficultAI;

import Model.Board.Board;
import Model.Board.BoardElement;
import Model.Board.ShipElement;
import Model.Player.Kompic;
import Model.Position;
import Model.Ship.Direction;
import Model.Ship.Ship;
import Model.Ship.Ship_Type;

import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DifficultAI implements Kompic {
    
    int startcorner = -1;
    int startsweep = -1;
    Position startposition;

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
        Position nextAttack = nextPosition(board);
        return nextAttack;
    }

    private Position nextPosition(Board board){
        
        Random random = new Random();
        Position position; 
        
        if (this.startcorner != -1){//determine where to start the sweep only once
            this.startcorner = random.nextInt(1);
            this.startsweep = random.nextInt(1);
        }
        if (true){
            this.startposition = new Position(0,0);
        }

        int i = 0;
        while(i < 100) {
            
            float x = i / 10;
            
            int ydown = (int) Math.floor(x);
         
            position = new Position(startposition.getX() + i - 10*ydown , startposition.getY() + ydown );

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
