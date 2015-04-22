package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;

public class Enemy {
	
	public int width, height, health;
	public float speed, x, y;
	private Texture texture;
	private Tile startTile;
	
	public Enemy(Texture texture, Tile startTile, int width, int height, float speed){
		
		this.texture = texture;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		
	}
	
	public void Draw(){
		DrawQuadTex(texture, x, y, width, height);
	}

}
