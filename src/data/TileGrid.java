package data;

//import static helpers.Art.*;

public class TileGrid {
	
	//Creating a double array called map
	public Tile[][] map;
	//To keep track of how many tiles there are in the map
	private int tilesWide, tilesHigh;
	
	public TileGrid() {
		this.tilesWide = 22;
		this.tilesHigh = 13;
		//	Setting grid dimensions
		map = new Tile[22][13];
		
		//Filling the grid with tiles
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
			}
		}
		
	}
	
	/*
	 TileGrid is the "level editor" so to say where the texture draw is
	 on-screen will change depending on if (in this case) 0 or a 
	 different value is typed into the double array (see Boot.java)
	 */
	public TileGrid(int[][] newMap){
		map = new Tile[22][13];
		
		//Defining the number of tiles long/high the map is
		this.tilesHigh = newMap.length;
		this.tilesWide = newMap[0].length;
		
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				/*
				  Because the newMap variable is always the one being changed, 
				  a switch statement is being used rather than an if/else to 
				  avoid extra/redundant code
				 */
				switch (newMap[j][i]){
				case 0:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
					break;
				case 1:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Dirt);
					break;
				case 2:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water);
					break;
					
				}
			}
		}
	}
	
	public void setTile(int xCoord, int yCoord, TileType type){
		map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type);
	}
	
	public Tile getTile(int xCoord, int yCoord){
		
		if (xCoord < tilesWide && yCoord < tilesHigh && xCoord > -1  &&
					yCoord > -1)
			//If the tile is valid, just return that tile
			return map[xCoord][yCoord];
		else 
			//Return a "throw away"/non existent tile to say you've hit the border
			return new Tile(0, 0, 0, 0, TileType.NULL);
	}
	
	public void Draw(){
		//Drawing textures to each tile in the grid
		for (int i= 0; i < map.length; i ++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j].Draw();
			}
		}
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}

	public int getTilesWide() {
		return tilesWide;
	}

	public void setTilesWide(int tilesWide) {
		this.tilesWide = tilesWide;
	}

	public int getTilesHigh() {
		return tilesHigh;
	}

	public void setTilesHigh(int tilesHigh) {
		this.tilesHigh = tilesHigh;
	}
	
	
}
