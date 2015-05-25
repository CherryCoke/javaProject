package data;

import static helpers.Art.DrawQuadTex;

import org.newdawn.slick.opengl.Texture;

public class Tower {
	
	private float x, y; //For setting tower
	private int width, height, damage;
	private Texture texture;
	private Tile startTile;
	
	public Tower(Texture texture, Tile startTile, int damage){
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.damage = damage;
	}
	
	public void update(){
		
	}
	
	//Same as Enemy's draw method
	public void draw(){
		DrawQuadTex(texture, x, y, width, height);
	}

}
