package battleBoard;
import java.util.Scanner;
public class Run {

	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter X:");
		int x=s.nextInt();
		System.out.println("Enter Y:");
		int y=s.nextInt();
		
		
		Ship titanic = new Ship();
		titanic.setLength(5);
		titanic.setPosition(y, x);
		titanic.setDirection(Direction.HORIZONTAL);
		b.setShip(titanic.position, titanic);
		b.printBoard();
		
		
	
		
		
		
		
		/*
		Scanner s = new Scanner(System.in);
		System.out.println("Enter X:");
		int x=s.nextInt();
		System.out.println("Enter Y:");
		int y=s.nextInt();
		
		Position position = new Position(y,x);
		b.move(position);
		b.printBoard();
		
		*/
		
		
		
		
		
		
		//b.printBoard();
		/*
		int x = 0;
		int y= 5;
		Position position = new Position(x,y);
		b.move(position);
		b.printBoard();
		*/
		
	}
}
