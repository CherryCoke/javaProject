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

}
