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
	
	//Temp class variables for testing features
	Tower tower;
	
	//Following classes are public because they need to be referenced
	//by just about every other class
	public Game(int[][]	 map){
		grid = new TileGrid(map);
		player = new Player(grid);
		waveManager = new WaveManager(new Enemy(QuickLoad("Meep"),
				grid.getTile(4, 5), grid, 64, 64, 50), 4, 5);
		tower = new Tower(QuickLoad("tower_base"), grid.getTile(14, 7), 10);
	
	}
	
	public void update() {
		//Class variables updates
		grid.Draw();
		waveManager.update();
		player.Update();
		
		//Update temp variables
		tower.update();
	}
}
