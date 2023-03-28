package STD_Classes;

public class Board {
	
	Object[][] board = new Object [10][10];
	private Ocean ocean; 
	
	public void initialize() {
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				board[i][j]= new Ocean();
			}
		}
		
	}
	
	String [] ship = {"+","+"};
	
	public void move (Position position) {
		for (int i =0;i<ship.length;i++) {
			board[position.x][position.y+i] = ship;
		}
		//board[position.x][position.y] = ship;
		//board[position.x+ship.length][position.y] = ship;
	}
	
	
	
	
	
	
	public void printBoard() {
		System.out.println("+---------+");
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				if (board[i][j]== ocean) {
					System.out.print('o');
				}
				else {
					System.out.print('+');
				}
			}
			System.out.println();
		}
		System.out.println("+---------+");
	}
	
}
