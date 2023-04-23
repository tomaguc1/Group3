package Model;

public class Position {
	private int x;
	private int y;

	public int getX() {
		return x;
	}
	public void setX(int X){ this.x = X; }

	public int getY() {
		return y;
	}
	public void setY(int Y){ this.y = Y; }

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (! (obj instanceof Position)) return false;
		
		Position other =(Position) obj;
		return other.x == this.x && other.y == this.y;
	}
}