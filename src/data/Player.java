package data;

import helpers.Clock;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Art.*;

public class Player {
	
	//Declaring class variables
	private TileGrid grid;
	private TileType[] types; //new array
	private int index; //keep track of current tile
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	
	//Prevents "extra clicks" from being registered.
	private boolean leftMouseButtonDown;
	
	public Player(TileGrid grid, WaveManager waveManager){
		//Initializing Class Variables
		this.grid = grid;
		this.types = new TileType[3]; //Currently three tile types
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.index = 0;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
		this.leftMouseButtonDown = false;
	}
	
	public void SetTile(){
		//Math.floor rounds down to the nearest whole number
		grid.setTile((int)Math.floor(Mouse.getX()/ 64), 
			(int)Math.floor((HEIGHT - Mouse.getY() - 1)/ 64), types[index]);
	}
	
	
	public void Update(){
		
		for (Tower t : towerList){
			t.update();
		}
		
		//Handle mouse input
		
		/*
		 0 and 1 are left and right click, respectively
		 !leftMouseButtonDown because it is false by default
		*/
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown){
			//Place a tower on the map at the mouse's location 
			towerList.add(new Tower(QuickLoad("tower_base"), 
					grid.getTile(Mouse.getX() / 64, 
					(HEIGHT - Mouse.getY() - 1) / 64), 10, 
					waveManager.getCurrentWave().getEnemyList()));
			//SetTile(); //Will later be used in an editor mode
		}
		
		//Continue to keep the Mouse button registered as down
		leftMouseButtonDown = Mouse.isButtonDown(0);
		
		//Handle keyboard input
		while (Keyboard.next()){
			//If this key is being pressed, do this
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && 
					Keyboard.getEventKeyState()){
				Clock.ChangeMultiplier(0.2f);
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && 
					Keyboard.getEventKeyState()){
				Clock.ChangeMultiplier(-0.2f);
			}
		}
	}
	
	public void ChangeIndex(){
		index++;
		if(index > types.length -1 ){
			index = 0;
		}
	}
}
