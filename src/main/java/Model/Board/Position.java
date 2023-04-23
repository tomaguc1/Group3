package Model.Board;

public class Position {
	protected int x;
	public int getX() {
		return x;
	}

	protected int y;
	public int getY() {
		return y;
	}

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