package Model.Board;
public class Ship {
	private Direction direction;
	private int length;
	protected Position position;
	protected int x;
	protected int y;
	
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
