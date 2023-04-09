package Model.Board;

public class Board {

	Object[][] board = new Object[10][10];
	private Ocean ocean;
	private Ship ship;

	public Board() {
		
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				board[i][j]= new Ocean(); 
			}
		}
		
	}

	// Vertical ship scenario



	public void setShip(Position position, Ship ship) {
		if (ship.getDirection()== Direction.VERTICAL ) {
			for (int i= 0; i<ship.getLength() ; i++) {
				board[position.getX()+i][position.getY()]= ship;
			}
		}
		
		else if (ship.getDirection()== Direction.HORIZONTAL ) {
			for (int i= 0; i<ship.getLength() ; i++) {
				board[position.getX()][position.getY()+i]= ship;
			}
		}
	}

	// board[position.getX()][position.getY()]= ship;
	// board[position.getX()+ship.getLength()-1][position.getY()]= ship;

	/*
	 * public void initialize() { for ( int i=0; i<10; i++) { for ( int j=0; j<10;
	 * j++) { board[i][j]= new Ocean(); } }
	 * 
	 * }
	 */
	// String [] ship = {"+","+"};
	/*
	 * public void move (Position position) { for (int i =0;i<ship.length;i++) {
	 * board[position.x][position.y+i] = ship; } //board[position.x][position.y] =
	 * ship; //board[position.x+ship.length][position.y] = ship; }
	 * 
	 * 
	 */

	public void printBoard() {
		System.out.println("+---------+");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] instanceof Ocean) {
					System.out.print('o');
				}

				else if (board[i][j] instanceof Ship) {
					System.out.print('+');
				}
			}
			System.out.println();
		}
		System.out.println("+---------+");
	}

}
