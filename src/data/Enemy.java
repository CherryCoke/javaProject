package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;
import static helpers.Clock.*;

public class Enemy {
	
	public int width, height, health;
	public float speed, x, y;
	private Texture texture;
	private Tile startTile;
	
	//temporary movement fix
	private boolean first = true;
	
	public Enemy(Texture texture, Tile startTile, int width, int height, float speed){
		
		this.texture = texture;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.startTile = startTile;
		
	}
	
	public void Update(){
		if (first)
			//If first, do nothing and set first to false (so it doesn't loop)
			first = false;
		else
		//new x is equal to last known location/update * speed
		x += Delta() * speed;
		
	}
	
	public void Draw(){
		DrawQuadTex(texture, x, y, width, height);
	}
	
	//Getters and Setters for each of the above methods
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

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

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	

}
