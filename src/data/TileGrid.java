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
				if (newMap[j][i] == 0)
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
				else
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Dirt);
					
			}
		}
	}
	
	public void Draw(){
		//Drawing textures to each tile in the grid
		for (int i= 0; i < map.length; i ++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];

				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(),
						t.getHeight());
			}
		}
	}
}
