package Model.Ship;


import Model.Position;

import java.util.ArrayList;

import Model.Board.BoardElement;
public class Ship extends BoardElement {

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
		return this.shipType.length();
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
	}

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
