package Model.Board;

import Model.Position;

public class Board {

	public BoardElement[][] board = new WaterElement[10][10];

	public Board() {
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				board[i][j]= new WaterElement();
			}
		}
	}

	//TODO : Method to take player ship collection and place the elements

	public BoardElement getBoardElementAtPosition(Position position){
		return board[position.getX()][position.getY()];
	}
	public void setBoardElementTypeAtPosition(BoardElement element, Position position){
		this.board[position.getX()][position.getY()] = element;
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


//	public void printBoard() {
//		BoardElement_Type elementType;
//		System.out.println("+---------+");
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				elementType = board[i][j].getElementType();
//
//				switch (elementType) {
//					case Ship:
//						System.out.print("+");
//						break;
//					case ShipHit:
//						System.out.print("-");
//						break;
//					case Water:
//						System.out.print("o");
//						break;
//					case WaterHit:
//						System.out.print("x");
//						break;
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("+---------+");
//	}
//	public BoardElement_Type getBoardElementTypeAtPosition(Position pos){
//		int X = pos.getX();
//		int Y = pos.getY();
//		return this.board[X][Y].getElementType();
//	}

}
