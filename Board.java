
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
	
	public void move (Position position) {
		board[position.x][position.y] = '+';
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
