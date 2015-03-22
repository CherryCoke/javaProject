package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;

public class Tile {
	
	//For each tile/square, the following is needed
	private float x, y, width, height;
	
	/*Eventually a texture will also be needed
	lwjgl uses the data type Texture to define textures*/
	private Texture texture; 
	
	private TileType type;
	
	//Class to create tiles
	public Tile(float x, float y, float width, float height, TileType type){
		
		//this references the current object
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		
		//Get the texture by quickloading according to the TileName
		this.texture = QuickLoad(type.textureName);
				
	}
	
	/*
	Creating abunch of "getters and setters," that is, methods
	to get and set a each of the values (x, y, width, height, type),
	so that other methods/classes can use/reference/edit each of those
	values/private variables that were made above
	 */
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
	
	

}
