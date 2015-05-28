package data;

import static helpers.Art.HEIGHT;
import static helpers.Art.QuickLoad;
import helpers.Clock;
import static helpers.Levels.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Editor {

	/*
	 * Class to handle the creation, saving, and loading of custom maps that are
	 * created from inside of the game
	 */
	private TileGrid grid;
	private int index;
	private TileType[] types;
	
	public Editor() {
		// The tile grid/default map is a blank grid of grass
		this.grid = loadMap("savedMap");
		this.index = 0;
		this.types = new TileType[3]; //Currently three tile types
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
	}

	public void update() {
		
		grid.Draw();
		
		// Handle mouse input
		if (Mouse.isButtonDown(0)) {
			SetTile();
		}

		// Handle keyboard input
		while (Keyboard.next()) {
			// If this key is being pressed, do this
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT
					&& Keyboard.getEventKeyState()) {
				ChangeIndex();
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_S
					&& Keyboard.getEventKeyState()) {
				saveMap("savedMap", grid);
			}
		}
	}

	private void SetTile() {
		// Math.floor rounds down to the nearest whole number
		grid.setTile((int) Math.floor(Mouse.getX() / 64),
				(int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64),
				types[index]);
	}
	
	public void ChangeIndex(){
		index++;
		if(index > types.length -1 ){
			index = 0;
		}
	}
}
