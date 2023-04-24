package Model.Board;

public class Obstacle extends BoardElements {
	private int length;
	protected Position position;
	
	
	public Obstacle (String ObstacleType) {
		switch (ObstacleType) { 
		case "Volcano":
			this.setLength(1);
			break;
		case "TreasureChest":
			this.setLength(1);
			break;
		}
		
		}
	
	
	public void setLength(int length) {
		this.length=length;
	}
	
	public void setPosition (int x, int y) {
		this.position=new Position (x,y);
	}
}
