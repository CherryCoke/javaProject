package helpers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import data.Tile;
import data.TileGrid;
import data.TileType;

public class Levels {
	
	public static void saveMap(String mapName, TileGrid grid){
		/*
		 mapName to know what to name the file to be saved, and
		 the TileGrid to keep track of the tileGrid to save
		 
		 mapData is what get passed to the file
		 */
		
		String mapData = "";
		
		//Goes through and saves data for each tile in the grid
		for (int i = 0; i < grid.getTilesWide(); i++){
			for (int j = 0; j < grid.getTilesHigh(); j++){
				mapData += getTileID(grid.getTile(i, j));
			}
		}
		
		//Try catch to report any errors that occur
		try{
			File file = new File(mapName);
			
			//Java's method of writing to a file (one method anyway)
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(mapData);
			bw.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getTileID(Tile t){
		/*
		 For each tile, it will be saved in a file as a character,
		 so each character will need to have an ID/character that
		 means "in-game, this tile goes in all places this character 
		 is present in the text file"
		 */
		
		String ID = "E"; //E for Error/tile does not exist
		
		switch(t.getType()){
		case Grass:
			ID = "0";
			break;
		case Dirt:
			ID = "1";
			break;
		case Water:
			ID = "2";
			break;
		case NULL:
			ID = "3";
			break;
		}
		return ID;
		
	}
	
	//Does literally the opposite of the above method
	public static TileType getTileType(String ID){
		
		TileType type = TileType.NULL;
		
		switch(ID){
		case "0":
			type = TileType.Grass;
			break;
		case "1":
			type = TileType.Dirt;
			break;
		case "2":
			type = TileType.Water;
			break;
		case "3":
			type = TileType.NULL;
			break;
		}
		
		return type;
	}
	
	public static TileGrid loadMap(String mapName){
		TileGrid grid = new TileGrid();
		
		try{
			// (one of) java's method for reading files
			BufferedReader br = new BufferedReader(new FileReader(mapName));
			String data = br.readLine();
			
			for (int i = 0; i < grid.getTilesWide(); i++) {
				for (int j = 0; j < grid.getTilesHigh(); j++){
					grid.setTile(i, j, getTileType(data.
							substring(i * grid.getTilesHigh() + j, 
									  i * grid.getTilesHigh() + j + 1)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return grid;
	}

}
