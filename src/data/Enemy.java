package data;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;
import static helpers.Clock.*;
//import static data.Checkpoint.*;

public class Enemy {
	
	//Declaring class variables
	public int width, height, health, currentCheckpoint;
	public float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private TileGrid grid;
	
	//temporary movement fix
	private boolean first = true;
	
	//Variables related to AI/enemy pathing
	private ArrayList<Checkpoint> checkpoints; //Array of checkpoints
	private int[] directions; //Integer array of directions 
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width,
			int height, float speed){
		
		//Initializing class variables
		this.texture = texture;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.startTile = startTile;
		this.grid = grid;
		
		//Initializing pathing/AI related variables
		this.checkpoints = new ArrayList<Checkpoint>();
		this.directions = new int[2];
		//0 and 1 are X and Y directions respectively
		this.directions[0] = 0;
		this.directions[1] = 1;
		directions = FindNextDirection(startTile);
		this.currentCheckpoint = 0; //Initial checkpoint will be zero
		AddCheckpointList();
	}
	
	public void Update(){
		if (first)
			//If first, do nothing and set first to false (so it doesn't loop)
			first = false;
		else{
			if (CheckpointReached()){
				if (currentCheckpoint + 1 == checkpoints.size())
					System.out.println("Enemy Reached End of Maze");
				else
					currentCheckpoint++;
			} else {
				x += Delta() * checkpoints.get(currentCheckpoint)
						.getxDirection() * speed;
				y += Delta() * checkpoints.get(currentCheckpoint)
						.getyDirection() * speed;
				}
			}
		}

	
	private boolean CheckpointReached(){
		boolean reached = false; //By default they've not reached the end
		
		Tile t = checkpoints.get(currentCheckpoint).getTile();
		//Check to see if enemies current position is within +- 3 pixels of checkpoint
		if (x > t.getX() - 3 && 
				x < t.getX() + 3 &&
				y > t.getY() - 3 &&
				y < t.getY() + 3){
			//Set checkpoint reached as true
			reached = true;
			//Then set X/Y to match the checkpoint perfectly 
			x = t.getX();
			y = t.getY();
		}
		return reached;
	}
	
	private void AddCheckpointList(){
		//Have to manually code in the first checkpoint (special case)
		checkpoints.add(FindNextCheckpoint(startTile, directions = 
				FindNextDirection(startTile)));
		
		//But for every other checkpoint
		int counter = 0;
		boolean cont = true; //cont(inue)
		
		while (cont){
			int[] currentDirection = FindNextDirection(checkpoints.get(counter)
					.getTile());
			//If no currentDirection exists, or there are more than 20 (arbitrary) then:
			if (currentDirection[0] == 2 || counter == 20){ //If no other direction is found
				cont = false; //Set continue to false
			} else { //Unless there is a next direction
				checkpoints.add(FindNextCheckpoint(checkpoints.get(counter)
						.getTile(), directions = FindNextDirection(checkpoints
						.get(counter).getTile())));
				
			}
			
			counter++;
		}
		
	}
	
	private Checkpoint FindNextCheckpoint(Tile start, int[] dir){
		//For the time being make these intial values null/nothing
		Tile next = null;
		Checkpoint c = null;
		
		//As in "is the next checkpoint found?
		boolean found = false; 
		
		//Keep track of while loop iterations
		int counter = 1;
		
		//While a next tile to move to isn't selected yet
		while (!found){
			
			/*
			 From the tile the enemy is currently standing on, he will keep moving
			 until he comes across a tile that doesn't match the one he's 
			 currently on, or in other words a corner/checkpoint.
			 
			 From this checkpoint, he needs to find which of the directions is valid 
			 (that isn't the one he just came from)
			 */
			if (start.getXPlace() + dir[0] * counter == grid.getTilesHigh() ||
				start.getYPlace() + dir[1] * counter == grid.getTilesWide() ||
				start.getType() != grid.getTile(start.getXPlace() + dir[0] * counter, 
				start.getYPlace() + dir[1] * counter).getType()){
				found = true; //once a tile is found
				//Subtract one so the correct checkpoint is made
				counter -= 1;
				next = grid.getTile(start.getXPlace() + dir[0] * counter, 
						start.getYPlace() + dir[1] * counter);
				
			}
			//Set and return the checkpoint/corner
			c = new Checkpoint(next, dir[0], dir[1]);
			counter ++;
		}
		return c; //Return checkpoint
		
	}
	private int[] FindNextDirection(Tile start){
		/*
		 Method grabs current (start) tile, and returns an array of integers of
		 the surrounding tiles/next possible directions
		 */
		
		int[] dir = new int[2];
		
		//Setting variables for the four possible options/directions for enemies
		
		//Up is - 1 and Down is +1 because 0, 0 starts are the top right
		Tile up = grid.getTile(start.getXPlace(), start.getYPlace() - 1);
		Tile down = grid.getTile(start.getXPlace(), start.getYPlace() + 1);
		
		//Left is still -1  and right is still + 1, however
		Tile right = grid.getTile(start.getXPlace() + 1, start.getYPlace());
		Tile left = grid.getTile(start.getXPlace() - 1, start.getYPlace());
		
		/*
		 Enemy decides which direction to move depending on which direction he
		 (up/down/right/left) a friendly/walkable tile is from him
		 */
		
		if (start.getType() == up.getType() && directions[1] != 1){
			dir[0] = 0;
			dir[1] = -1;
		} else if (start.getType() == right.getType() && directions[0] != -1){
			dir[0] = 1;
			dir[1] = 0;
		} else if (start.getType() == down.getType() && directions[1] != -1){
			dir[0] = 0;
			dir[1] = 1;
		} else if (start.getType() == left.getType() && directions[0] != 1){
			dir[0] = -1;
			dir[1] = 0;
		} else {
			/*
			 Set both directions to 2 so that the computer knows that
			 no valid direction was found
			 */
			dir[0] = 2;
			dir[1] = 2;
		}
		
		
		
		return dir;
	}
	
	public void Draw(){
		DrawQuadTex(texture, x, y, width, height);
	}
	
	//Getters and Setters for each of the above methods
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public TileGrid getTileGrid(){
		return grid;
	}
	
	

}
