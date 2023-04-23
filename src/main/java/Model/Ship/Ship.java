package Model.Ship;


import Model.Board.BoardElement;
import Model.Position;
import Model.Ship.Direction;

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

}
