package Model.Board;

import Model.Position;
import Model.Ship.Direction;
import Model.Ship.Ship;

import java.util.ArrayList;

public class Board {

	public BoardElement[][] board = new BoardElement[10][10];
	
	public Board() {
		
	}

	public Board(ArrayList<Ship> ships) {
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				board[i][j]= new WaterElement();
			}
		}

		for (Ship ship: ships) {
			for (Position position: ship.getAllPositions()) {
				board[position.getY()][position.getX()] = new ShipElement();
			}
		}
	}

	public BoardElement getBoardElementAtPosition(Position position){
		return board[position.getY()][position.getX()];
	}

//Mila setShipMethod TODO: Check it out
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

	public void setBoardElementTypeAtPosition(BoardElement element, Position position){
		this.board[position.getY()][position.getX()] = element;
	}

	public int getHealth() {
		int health = 0;
		for ( int i=0; i<10; i++) {
			for ( int j=0; j<10; j++) {
				BoardElement boardElement = board[i][j];
				if (boardElement instanceof ShipElement) {
					if (!boardElement.getWasHit()) {
						health++;
					}
				}
			}
		}
		return health;
	}

	public void printBoard() {
		System.out.println("+---------+");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				BoardElement element = board[i][j];

				if (element.getClass().equals(ShipElement.class)) {
					if (element.getWasHit()) {
						System.out.print("-");
					} else {
						System.out.print("+");
					}
				} else if (element.getClass().equals(WaterElement.class)) {
					if (element.getWasHit()) {
						System.out.print("x");
					} else {
						System.out.print("o");
					}
				}
			}
			System.out.println();
		}
		System.out.println("+---------+");
	}
}
