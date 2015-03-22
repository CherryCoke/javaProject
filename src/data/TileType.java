package data;

public enum TileType {
	
	/*
	Creating a new enumerator. Enums are useful when
	you have a method or instances where you want only a 
	small possible set of values. In this case, I only want
	tiles to be grass or dirt, because I only have 
	grass and dirt textures (and they each have a specific
	property assigned to them). 
	*/
	Grass("grass64", true), Dirt("dirt64", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}

}
