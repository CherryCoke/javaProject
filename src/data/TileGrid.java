package data;

import static helpers.Art.*;

public class TileGrid {
	
	//Creating a double array called map
	public Tile[][] map;
	
	
	public TileGrid() {
		//Setting grid dimensions
		map = new Tile[20][15];
		
		//Filling the grid with tiles
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map.length; j++){
				map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
			}
		}
		
	}
	
	public void Draw(){
		//Drawing textures to each tile in the grid
		for (int i= 0; i < map.length; i ++){
			for (int j = 0; j < map.length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(),
						t.getHeight());
			}
		}
	}
}
