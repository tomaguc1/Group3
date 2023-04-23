package Model.Board;

public enum Direction {
	
	VERTICAL("vertical"), HORIZONTAL("horizontal"), DIAGONAL("diagonal");
	
	private final String d;

	Direction(String string) {
		this.d = string;
	}
	

}
