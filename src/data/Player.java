package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Art.*;

public class Player {
	
	private TileGrid grid;
	private TileType[] types; //new array
	private int index; //keep track of current tile
	
	public Player(TileGrid grid){
		this.grid = grid;
		this.types = new TileType[3]; //Currently three tile types
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.index = 0;
	}
	
	public void SetTile(){
		//Math.floor rounds down to the nearest whole number
		grid.setTile((int)Math.floor(Mouse.getX()/ 64), 
			(int)Math.floor((HEIGHT - Mouse.getY() - 1)/ 64), types[index]);
	}
	
	public void Update(){
		//0 and 1 are left and right click, respectively
		if (Mouse.isButtonDown(0)){
			SetTile();
		}
		//While keyboard is doing something
		while (Keyboard.next()){
			//If this key is being pressed, do this
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && 
					Keyboard.getEventKeyState()){
				ChangeIndex();
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
