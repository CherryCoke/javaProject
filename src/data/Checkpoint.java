package data;

public class Checkpoint {
	
	/*
	 Purpose of class is to hold data/variables related to 
	 enemy AI and turning/checking corners/turns/etc...
	 */
	
	private Tile tile; //keep track of current tile
	/*
	 X/Y direction are the directions from the enemie's current
	 position that he will look in to decide where his next move 
	 will be/which direction he will head in
	 */
	private int xDirection, yDirection;
	
	public Checkpoint(Tile tile, int xDirection, int yDirection){
		//Initializing class variables
		this.tile = tile;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
}
