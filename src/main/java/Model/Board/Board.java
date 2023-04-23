package Model.Board;

public class Board {

	BoardElement[][] board = new BoardElement[10][10];

	private Ship ship;
	private Bomb bomb;
	private int X;
	private int Y;
	private Miss miss;

	public Board() {
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
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

	public BoardElement getBoardElement (Position position) {
		return board [position.getX()][position.getY()];

	}/*
	public void setBomb ( int X, int Y, Bomb bomb, Miss miss) {
		if(board[X][Y]== ship) {
			board[X][Y]=bomb; 
		}
		else  {
			board[X][Y]= miss;
			board[X][Y]= miss;
			
		}
	}
*/

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

}
