package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Art.*;
import static helpers.Clock.*;

public class Bullet {
	
	//Setting class variables
	private Texture texture;
	private float x, y, speed;
	private int damage;
	
	public Bullet(Texture texture, float x, float y, float speed, int damage){
		
		//Initializing class variables
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
	}
	
	public void update(){
		x += Delta() * speed;
		
		draw();
	}
	
	public void draw(){
		DrawQuadTex(texture, x, y, 32, 32);
	}

}
