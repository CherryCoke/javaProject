package data;

import static helpers.Art.QuickLoad;

public class Game {
	
	/*
	 Handles all code related to starting the game and 
	 updating everything once it has started
	 */
	
	//Setting class variables
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	//final means it can never be changed
	public static final int TILE_SIZE = 64;
	
	//Temp class variables for testing features
	
	
	//Following classes are public because they need to be referenced
	//by just about every other class
	public Game(int[][]	map){
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(QuickLoad("Meep"),
				grid.getTile(4, 5), grid, 64, 64, 70), 2, 5);
		player = new Player(grid, waveManager);
	
	}
	
	public void update() {
		//Class variables updates
		grid.Draw();
		waveManager.update();
		player.Update();
		
		//Update temp variables
		
	}
}
