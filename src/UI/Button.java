package UI;

import org.newdawn.slick.opengl.Texture;

public class Button {
	
	//Declaring class variables
	private String name; //name of button so specific ones can be accessed
	private Texture texture;
	private int x, y, width, height;
	
	
	//Buttons where the width and height are not the default/same as the file
	public Button(String name, Texture texture, int x, int y, int width,
			int height){
		
		//Initializing/setting class variables
		this.name = name;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//Second constructor takes different arguments so it is valid as well
	public Button(String name, Texture texture, int x, int y){
		this.name = name;
		this.texture = texture;
		this.x = x;
		this.y = y;
		
		//Get the width and height of our texture
		this.width = texture.getImageWidth();
		this.height = texture.getImageHeight();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}
