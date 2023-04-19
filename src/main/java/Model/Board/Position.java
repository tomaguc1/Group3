package Model.Board;

public class Position {
	protected int x;
	protected int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj == this) return true;
		if (! (obj instanceof Position)) return false;
		
		Position other =(Position) obj;
		return other.x == this.x && other.y == this.y;
	}
}