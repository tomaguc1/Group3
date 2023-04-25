package Model.Ship;


import Model.Position;

import java.util.ArrayList;

public class Ship {

	private boolean isPlaced;

	public boolean getIsPlaced() { return isPlaced; }

	public void setIsPlaced(boolean isPlaced) { this.isPlaced = isPlaced; }

	private Direction direction;

	public Direction getDirection(){ return this.direction; }

	public void setDirection (Direction direction) { this.direction=direction; }

	public void rotate() {
		this.direction = this.direction == Direction.HORIZONTAL ? Direction.VERTICAL : Direction.HORIZONTAL;
	}

	private Position position;

	public Position getPosition(){ return this.position; }

	public void setPosition (int x, int y) { this.position = new Position (x,y); }
	public void setPosition (Position position) { this.position = position; }

	private Ship_Type shipType;

	public Ship_Type getShipType() { return shipType; }

	public void setShipType(Ship_Type shipType) { this.shipType = shipType; }

	public int getLength() {
		switch(this.shipType){
			case SUBMARINE:
				return 2;
			case DESTROYER:
				return 3;
			case BATTLESHIP:
				return 4;
			case CARRIER:
				return 5;
			default:
				return -1;
		}
	}

//	private BoardElement[] shipCells; // FIXME: Maps ship body cells to the board

	public Ship(Ship_Type type) {
		this.shipType = type;
		this.direction = Direction.HORIZONTAL;
		this.position = new Position(0, 0);
	}

	public Ship(Ship_Type type, Position nose, Direction direction) { // Before instantiation check if it fits

		this.setShipType(type);

		this.position = nose;
		this.setDirection(direction);

		//=-=- Instantiate and set position of ship elements =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//		shipCells = new ShipElement[this.getLength()]; // Adapts lenght to the ShipType
//		switch (this.getDirection()){
//			case HORIZONTAL:
//				for(int i = 0; i < this.getLength(); i++){
//					shipCells[i].setElementPosition(new Position(nose.getX() + i, nose.getY()));
//				}
//				break;
//
//			case VERTICAL:
//				for(int i = 0; i < this.getLength(); i++){
//					shipCells[i].setElementPosition(new Position(nose.getX(), nose.getY() + i));
//				}
//				break;
//		}
		//-------------------------------------------------------------------------------------------------
	}

//=-=-=-=-    Placement Checks =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//public boolean checkShipPlacement(Board board, Ship ship, Position noseShip){
//
//	Direction dir = ship.getDirection();
//	int lenShip = ship.getLength();
//
//	int X = noseShip.getX();// Ship Position
//	int Y = noseShip.getY();
//
//	boolean shipFits = isInBounds(ship.getShipType(), noseShip);
//	switch (dir){
//		case HORIZONTAL:
//			for( int y = Y; y < Y + lenShip; y++){ // checks the ship body coordinates for water
//				Position newPos = new Position(X, y);
//				if((board.getBoardElementTypeAtPosition(newPos) != BoardElement_Type.Water)
//						|| !shipFits){
//					return false;
//				}
//			}
//			break;
//		case VERTICAL:
//			for(int x = X; x < X + lenShip; x++){ // checks the ship body coordinates for water
//				Position newPos = new Position(x, Y);
//				if((board.getBoardElementTypeAtPosition(newPos) != BoardElement_Type.Water)
//						|| !shipFits){
//					return false;
//				}
//			}
//		default:
//			return true;
//	}
//	return true;
//}

	public ArrayList<Position> getAllPositions() {
		ArrayList<Position> positions = new ArrayList<Position>();
		int length = this.getLength();
		for (int offset = 0; offset < length; offset++) {
			positions.add(this.position.offset(this.direction, offset));
		}
		return positions;
	}

	public boolean doesItOverlapWith(Ship other) {
		ArrayList<Position> thisPositions = this.getAllPositions();
		ArrayList<Position> otherPositions = other.getAllPositions();

		for (Position thisPosition: thisPositions) {
			for (Position otherPosition: otherPositions) {
				if (thisPosition.equals(otherPosition)) {
					return true;
				}
			}
		}

		return false;
	}

////HELPER Function for checkingShipPlacement
	public boolean isInBounds() {
		int y = this.position.getY();
		int x = this.position.getX();

		if (x < 0 || y < 0)
			return false;

		if (x > 9 || y > 9)
			return false;

		int coord = this.direction == Direction.HORIZONTAL ? x : y;
		int maxCoord = 10 - this.getLength();

		return coord <= maxCoord;
	}
//----------------------------------------------------------------------------------------------------------

}
