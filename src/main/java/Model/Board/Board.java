package Model.Board;

import Model.Position;
import Model.Ship.Ship;

public class Board {

	public BoardElement[][] board = new BoardElement[10][10];

	public Board() {
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				// TODO : Replace new Ocean with Board_Element
				board[i][j]= new Ocean();
			}
		}
	}


//	public void setShip(Position position, Ship ship) {
//		if (ship.getDirection()== Direction.VERTICAL ) {
//			for (int i= 0; i<ship.getLength() ; i++) {
//				board[position.getX()+i][position.getY()]= ship;
//			}
//		} else if (ship.getDirection()== Direction.HORIZONTAL ) {
//			for (int i= 0; i<ship.getLength() ; i++) {
//				board[position.getX()][position.getY()+i]= ship;
//			}
//		}
//	}


	public void printBoard() {
		BoardElement_Type elementType;
		System.out.println("+---------+");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				elementType = board[i][j].getElementType();

				switch (elementType) {
					case Ship:
						System.out.print("+");
						break;
					case ShipHit:
						System.out.print("-");
						break;
					case Water:
						System.out.print("o");
						break;
					case WaterHit:
						System.out.print("x");
						break;
				}
			}
			System.out.println();
		}
		System.out.println("+---------+");
	}
	public BoardElement_Type getBoardElementTypeAtPosition(Position pos){
		int X = pos.getX();
		int Y = pos.getY();
		return this.board[X][Y].getElementType();
	}

}
