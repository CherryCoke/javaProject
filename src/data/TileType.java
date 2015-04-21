package data;

public enum TileType {
	
	/*
	Creating a new enumerator. Enums are useful when
	you have a method or instances where you want only a 
	small possible set of values. In this case, the only 
	values are a texture followed by a boolean value for 
	if towers can be built upon them
	*/
	Grass("grass64", true), Dirt("dirt64", false), Water("water64", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}

}
