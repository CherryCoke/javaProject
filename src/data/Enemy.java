package data;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;
import static helpers.Clock.*;
import static data.Checkpoint.*;

public class Enemy {
	
	public int width, height, health;
	public float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private TileGrid grid;
	
	//temporary movement fix
	private boolean first = true;
	
	//Variables related to AI/enemy pathing
	private ArrayList<Checkpoint> checkpoints; //Array of checkpoints
	private int[] directions; //Integer array of directions 
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed){
		
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
		directions = findNextDirection(startTile);
	}
	
	public void Update(){
		if (first)
			//If first, do nothing and set first to false (so it doesn't loop)
			first = false;
		else{
			x += Delta() * directions[0];
			y += Delta() * directions[1];
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
			 until he comes across a tile that doesn't match the one he's currently on,
			 or in other words a corner/checkpoint.
			 
			 From this checkpoint, he needs to find which of the directions is valid (that
			 isn't the one he just came from)
			 */
			if (start.getType() != grid.getTile(start.getXPlace() + dir[0] * counter, 
					start.getYPlace() + dir[1] * counter).getType()){
				found = true; //once a tile is found
				//counter needs to be subtracted so that the checkpoint is in the correct spot
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
	private int[] findNextDirection(Tile start){
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
		
		if (start.getType() == up.getType()){
			dir[0] = 0;
			dir[1] = -1;
		} else if (start.getType() == down.getType()){
			dir[0] = 0;
			dir[1] = 1;
		} else if (start.getType() == right.getType()){
			dir[0] = 1;
			dir[1] = 0;
		} else if (start.getType() == left.getType()){
			dir[0] = -1;
			dir[1] = 0;
		} else {
			//Report if there are no walkable directions (for debugging)
			System.out.println("No Walkable Direction"); 
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
