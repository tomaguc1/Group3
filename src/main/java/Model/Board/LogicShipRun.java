package Model.Board;
import java.util.Scanner;
public class LogicShipRun {

	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
		
		int i=0;
		while(i++ <= 5) {
			Scanner s = new Scanner(System.in);
		
	
			System.out.println("Enter ship: ");
			String shipType = s.nextLine();
			
			System.out.println("Enter X:");
			int x=s.nextInt();
			System.out.println("Enter Y:");
			int y=s.nextInt();
			
//		if (shipType.equals("carrier")) {
//			Ship Carrier = new Ship("Carrier");
//			Carrier.setPosition(x, y);
//			b.setShip(Carrier.position, Carrier);
//
//			b.printBoard();
//		}
//		 if (shipType.equals("destroyer")) {
//			Ship Destroyer = new Ship("Destroyer");
//			Destroyer.setPosition(x, y);
//			b.setShip(Destroyer.position, Destroyer);
//
//			b.printBoard();
//		}
//		 if (shipType.equals("battleship")) {
//			Ship BattleShip = new Ship("BattleShip");
//			BattleShip.setPosition(x, y);
//			b.setShip(BattleShip.position, BattleShip);
//			b.printBoard();
//		}
//		 if (shipType.equals("submarine")) {
//			Ship Submarine = new Ship("Submarine");
//			Submarine.setPosition(x, y);
//			b.setShip(Submarine.position, Submarine);
//			b.printBoard();
//		}
//		 if (shipType.equals("patrol")) {
//			Ship Patrol = new Ship("Patrol");
//			Patrol.setPosition(x, y);
//			b.setShip(Patrol.position, Patrol);
//			b.printBoard();
//		}
		}
	
	/*
	//Making a move :
		 //Bomb bomb= new Bomb();
		 Miss miss = new Miss();
		 System.out.println("Attack: ");
		 System.out.println("Enter X:");
			int x1=s.nextInt();
			System.out.println("Enter Y:");
			int y1=s.nextInt();
			//b.setBomb(x1, y1,bomb,miss );
			b.printBoard();
	*/
	}
}
