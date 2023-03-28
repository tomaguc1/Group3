package STD_Classes;

public class Ship {
	private Direction direction;
	private int length;
	private Position position;
	
	public void setLength (int length) {
		this.length=length;
	}
	public void setPosition (Position position) {
		this.position=position;
	}
	
	public Position getPosition () {
		return position; 
	}
	public void setDirection (Direction direction) {
		this.direction=direction;
	}

}
