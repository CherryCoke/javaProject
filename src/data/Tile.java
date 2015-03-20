package data;

import org.newdawn.slick.opengl.Texture;

public class Tile {
	
	//For each tile/square, the following is needed
	private float x, y, width, height;
	
	/*Eventually a texture will also be needed
	lwjgl uses the data type Texture to define textures*/
	private Texture texture; 
	
	//Class to create tiles
	public Tile(float x, float y, float width, float height,
				Texture texture){
		
		//this references the current object
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		
	}

}
