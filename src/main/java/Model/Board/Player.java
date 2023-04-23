package Model.Board;

public class Player {
	
	private int number;
	private boolean start;
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setStatus(boolean start) {
		this.start = start;
	}
	public boolean isStart() {
		return start;
	}
	
}
