package Model.Ship;
public class Ship extends BoardElement {
	private Direction direction;
	private int length;
	protected Position position;
	protected int x;
	protected int y;
	
	public Ship() {
		
	}
	
	public Ship (String shipType) {
		switch (shipType) {
		case "Carrier": 
			this.setLength(5);
			setDirection(Direction.VERTICAL);
		break;
		
		case "BattleShip":
			this.setLength(4);
			setDirection(Direction.VERTICAL);
		break;
		
		case "Destroyer":
			this.setLength(3);
			setDirection(Direction.HORIZONTAL);
		break;
		
		case "Submarine":
			this.setLength(2);
			setDirection(Direction.HORIZONTAL);
		break;
		
		case "Patrol":
			this.setLength(1);
 			setDirection(Direction.HORIZONTAL);
 		break;

 		case "Test":
 			this.setLength(2);
 			setDirection(Direction.DIAGONAL);
 		break;

 		}
 	}

	public void setLength (int length) {
		this.length=length;
	}
	
	
	public int getLength () {
		return length;
	}
	public void setPosition (int x, int y) {
		this.position=new Position (x,y);
	}
	
	
	
	public Position getPosition () {
		return position; 
	}
	public void setDirection (Direction direction) {
		this.direction=direction;
	}
	public Direction getDirection () {
		return this.direction;
	}
}



















/*
package Model.Ship;


import Model.Board.Board;
import Model.Board.BoardElement;
import Model.Board.BoardElement_Type;
import Model.Position;

public class Ship extends BoardElement {

	private Direction direction;
	public Direction getDirection(){ return this.direction; }
	public void setDirection (Direction direction) { this.direction=direction; }

	private Ship_Type shipType;
	public Ship_Type getShipType() { return shipType; }
	public void setShipType(Ship_Type shipType) { this.shipType = shipType; }

	private Position position;
	public Position getPosition(){ return this.position; }
	public void setPosition (int x, int y) { this.position=new Position (x,y); }

	private boolean[] shipHealth;


	private int length;
	public int getLenght(){
		switch(this.shipType){
			case CARRIER:
				return 5;
			case BATTLESHIP:
				return 4;
			case DESTROYER:
				return 3;
			case SUBMARINE:
				return 2;
			default:
				return 0;
		}
	}
	public void setLength(Ship_Type type){
		switch (type){
			case SUBMARINE:
				this.length = 2;
				break;
			case DESTROYER:
				this.length = 3;
				break;
			case BATTLESHIP:
				this.length = 4;
				break;
			case CARRIER:
				this.length = 5;
				break;
		}
	}

	public Ship() {
		
	}
	public boolean checkShipPlacement(Board board, Ship ship, Position posit){
		Direction dir = ship.getDirection();
		int X = posit.getX();
		int Y = posit.getY();
		boolean shipFits = lenghtCheckFits(ship.getShipType(), posit);
		switch (dir){
			case HORIZONTAL:
				for( int y = Y; y < 10; y++){
					Position newPos = new Position(X, y);
					if((board.getBoardElementTypeAtPosition(newPos) != BoardElement_Type.Water)
						|| !shipFits){
						return false;
					}
				}
				break;
			case VERTICAL:
				for(int x = X; x < 10; x++){
					Position newPos = new Position(x, Y);
					if((board.getBoardElementTypeAtPosition(newPos) != BoardElement_Type.Water)
						|| !shipFits){
						return false;
					}
				}
			default:
				return true;
		}
		return false;


	}
//HELPER Function for checkingShipPlacement
	public boolean lenghtCheckFits(Ship_Type type, Position posit){
		int Y = posit.getY();
		int X = posit.getX();
		switch (type){
			case CARRIER:
				if(Y > 5 || X > 5){ return false; }
				break;
			case BATTLESHIP:
				if(Y > 6 || X > 6){ return false; }
				break;
			case DESTROYER:
				if(Y > 7 || X > 7){ return false; }
				break;
			case SUBMARINE:
				if(Y > 8 || X > 8){ return false; }
				break;
			default:
				return true;
		}
		return false;
	}

}
*/