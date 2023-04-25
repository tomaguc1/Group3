package Model.Ship;


import Model.Board.Board;
import Model.Board.BoardElement;
import Model.Board.ShipElement;
import Model.Position;

public class Ship {

	private Direction direction;
	public Direction getDirection(){ return this.direction; }
	public void setDirection (Direction direction) { this.direction=direction; }

	private Position noseShip;
	public Position getNoseShip(){ return this.noseShip; }
	public void setPosition (int x, int y) { this.noseShip = new Position (x,y); }

	private Ship_Type shipType;
	public Ship_Type getShipType() { return shipType; }
	public void setShipType(Ship_Type shipType) { this.shipType = shipType; }

	private int length;
	public int getLength(){
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

	private BoardElement[] shipCells;


	public Ship(){
	}
	public Ship(Ship_Type type, Position nose, Direction direction) { // Before instantiation check if it fits

		this.setShipType(type);
		this.setLength(type);
		this.noseShip = nose;
		this.setDirection(direction);

	//=-=- Instantiate and set position of ship elements =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		shipCells = new ShipElement[this.getLength()]; // Adapts lenght to the ShipType
		switch (this.getDirection()){
			case HORIZONTAL:
				for(int i = 0; i < this.getLength(); i++){
					shipCells[i].setElementPosition(new Position(nose.getX() + i, nose.getY()));
				}
				break;

			case VERTICAL:
				for(int i = 0; i < this.getLength(); i++){
					shipCells[i].setElementPosition(new Position(nose.getX(), nose.getY() + i));
				}
				break;
		}
	//-------------------------------------------------------------------------------------------------
	}

//=-=-=-=-    Placement Checks =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//	public boolean checkShipPlacement(Board board, Ship ship, Position noseShip){
//
//		Direction dir = ship.getDirection();
//		int lenShip = ship.getLength();
//
//		int X = noseShip.getX();// Ship Position
//		int Y = noseShip.getY();
//
//		boolean shipFits = lenghtCheckFits(ship.getShipType(), noseShip);
//		switch (dir){
//			case HORIZONTAL:
//				for( int y = Y; y < Y + lenShip; y++){ // checks the ship body coordinates for water
//					Position newPos = new Position(X, y);
//					if((board.getBoardElementTypeAtPosition(newPos) != BoardElement_Type.Water)
//						|| !shipFits){
//						return false;
//					}
//				}
//				break;
//			case VERTICAL:
//				for(int x = X; x < X + lenShip; x++){ // checks the ship body coordinates for water
//					Position newPos = new Position(x, Y);
//					if((board.getBoardElementTypeAtPosition(newPos) != BoardElement_Type.Water)
//						|| !shipFits){
//						return false;
//					}
//				}
//			default:
//				return true;
//		}
//		return true;
//	}
//
////HELPER Function for checkingShipPlacement
//	public boolean lenghtCheckFits(Ship_Type type, Position posit){
//		int Y = posit.getY();
//		int X = posit.getX();
//		switch (type){
//			case CARRIER:
//				if(Y > 5 || X > 5){ return false; }
//				break;
//			case BATTLESHIP:
//				if(Y > 6 || X > 6){ return false; }
//				break;
//			case DESTROYER:
//				if(Y > 7 || X > 7){ return false; }
//				break;
//			case SUBMARINE:
//				if(Y > 8 || X > 8){ return false; }
//				break;
//			default:
//				return true;
//		}
//		return false;
//	}
//----------------------------------------------------------------------------------------------------------

}
