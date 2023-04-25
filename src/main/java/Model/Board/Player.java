package Model.Board;

import java.util.ArrayList;

public class Player {
	private int number;
	private boolean start;
	private boolean turn;
	ArrayList<Ship> listShip = new ArrayList<Ship>() ;
	private ArrayList<Position> successfulMoves = new ArrayList<Position>();
	ArrayList<Obstacle> listO = new ArrayList<Obstacle>() ;
	
	int length= listShip.size();
	
	public ArrayList getList () {
		return this.listShip;
	}
	
	public ArrayList getListObstacles () {
		return this.listO;
	}
	
	public ArrayList<Position> getSuccessfulMoves() {
        return successfulMoves;
    }

    public int getNumSuccessfulMoves() {
        return successfulMoves.size();
    }
	
    //Checking who has won
	public boolean isWinner() {
		if (getNumSuccessfulMoves()==10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Iterating between players in the beginning of the game when setting ships or obstacles 
	public boolean isYourTurn() {
		if (listShip.size()==5 || listO.size()==2) {
			return false;
		}
		else {
		return true;}
	}
	
	
	//every time we pick a ship it will be added 
	public void AddShip(Ship s) {
		if (listShip.size()<5 ) {
			this.listShip.add(s);
		}
		else { }
	}
	
	public void AddObstacle(Obstacle obstacle) {
		if (listO.size()<2) {
			this.listO.add(obstacle);
		}
		else {}
	}
	
	
	
	
	public Player() {
		
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setStatus(boolean start) {
		this.start = start;
	}
	public boolean isStart() {
		return start;
	}
	
	
	
}
