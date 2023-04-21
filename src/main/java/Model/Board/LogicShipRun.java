package Model.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class LogicShipRun {

	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
		Player p = new Player();

		int j = 1;
		while (j++ <= 2) {

			p.setNumber(j);

			Scanner s = new Scanner(System.in);

			System.out.println("Enter ship: ");
			String shipType = s.nextLine();

			System.out.println("Enter X:");
			int x = s.nextInt();
			System.out.println("Enter Y:");
			int y = s.nextInt();

			if (shipType.equals("carrier")) {
				Ship Carrier = new Ship("Carrier");
				Carrier.setPosition(x, y);
				b.setShip(Carrier.position, Carrier);

				b.printBoard();
			}
			if (shipType.equals("destroyer")) {
				Ship Destroyer = new Ship("Destroyer");
				Destroyer.setPosition(x, y);
				b.setShip(Destroyer.position, Destroyer);

				b.printBoard();
			}
			if (shipType.equals("battleship")) {
				Ship BattleShip = new Ship("BattleShip");
				BattleShip.setPosition(x, y);
				b.setShip(BattleShip.position, BattleShip);
				b.printBoard();
			}
			if (shipType.equals("submarine")) {
				Ship Submarine = new Ship("Submarine");
				Submarine.setPosition(x, y);
				b.setShip(Submarine.position, Submarine);
				b.printBoard();
			}
			if (shipType.equals("patrol")) {
				Ship Patrol = new Ship("Patrol");
				Patrol.setPosition(x, y);
				b.setShip(Patrol.position, Patrol);
				b.printBoard();
			}
		}
		// }

		Player player1 = new Player();
		player1.setNumber(1);
		player1.setStatus(true);

		Player player2 = new Player();
		player2.setNumber(2);
		player2.setStatus(false);

		Scanner scanner = new Scanner(System.in);

		while (player1.getNumSuccessfulMoves() < 10 && player2.getNumSuccessfulMoves() < 10) {
			Player currentPlayer;
			if (player1.isStart()) {
				currentPlayer = player1;
			} else {
				currentPlayer = player2;
			}
			while (currentPlayer.isYourTurn()) {
				System.out.println("Player " + currentPlayer.getNumber() + ", please select a :");
				Scanner scan = new Scanner(System.in);

				int x = scan.nextInt();
				int y = scan.nextInt();
				boolean moveSuccessful = false;
				BoardElements element = b.getBoardElement(new Position(x, y));
				if (element instanceof Ship) {
					// Bomb hit a ship
					currentPlayer.getSuccessfulMoves().add(new Position(x, y));
					moveSuccessful = true;
				} else if (element instanceof Ocean) {
					// Bomb missed
					b.setBomb(x, y, new Bomb(), currentPlayer);
				}
				if (!moveSuccessful) {
					// If move is not successful, switch to other player's turn
					if (currentPlayer == player1) {
						currentPlayer = player2;
					} else {
						currentPlayer = player1;
					}
				}
			}
		}

		if (player1.getNumSuccessfulMoves() == 10) {
			System.out.println("Player 1 wins!");
		} else {
			System.out.println("Player 2 wins!");
		}

	}
}
        

