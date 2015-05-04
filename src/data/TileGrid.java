package data;

import static helpers.Art.*;

public class TileGrid {
	
	//Creating a double array called map
	public Tile[][] map;
	
	
	public TileGrid() {
		//Setting grid dimensions
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
		return map[xCoord][yCoord];
	}
	
	public void Draw(){
		//Drawing textures to each tile in the grid
		for (int i= 0; i < map.length; i ++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j].Draw();
			}
		}
	}
}
