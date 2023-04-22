package Model.Board;


public class Ship {
	private Direction direction;
	private boolean isRotated;
	private int length;
	protected Position position;
	protected int x;
	protected int y;
	
	public Ship() {
		
	}
	
	public Ship (String shipType) {
		switch (shipType) {
		case "Carrier": 
			this.setLength(5);
			setDirection(Direction.VERTICAL);
		break;
		
		case "BattleShip":
			this.setLength(4);
			setDirection(Direction.VERTICAL);
		break;
		
		case "Destroyer":
			this.setLength(3);
			setDirection(Direction.HORIZONTAL);
		break;
		
		case "Submarine":
			this.setLength(2);
			setDirection(Direction.HORIZONTAL);
		break;
		
		case "Patrol":
			this.setLength(1);
			setDirection(Direction.HORIZONTAL);
		break;
		
		}
	}
	
	public void setLength (int length) {
		this.length=length;
	}
	public int getLength () {
		return length;
	}
	public void setPosition (int x, int y) {
		this.position=new Position (x,y);
	}
	
	public Position getPosition () {
		return position; 
	}
	public void setDirection (Direction direction) {
		this.direction=direction;
	}
	public Direction getDirection () {
		return this.direction;
	}
}
