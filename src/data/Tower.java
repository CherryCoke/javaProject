package data;

import static helpers.Art.*;
import static helpers.Clock.Delta;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Tower {
	
	//Setting class varaibles
	private float x, y, timeSinceLastShot, firingSpeed; //For setting tower
	private int width, height, damage;
	private Texture texture;
	private Tile startTile;
	private ArrayList<Bullet> bullets;
	
	public Tower(Texture texture, Tile startTile, int damage){
		//Initializing Class Variables
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.damage = damage;
		
		//Setting default values
		this.firingSpeed = 30;
		this.timeSinceLastShot = 0;
		this.bullets = new ArrayList<Bullet>();
	}
	
	private void shoot(){
		//Reset counter
		timeSinceLastShot = 0;
		
		bullets.add(new Bullet(QuickLoad("bullet"), x + 32, y + 32, 
				5, 10)); //5 speed, 10 damage (arbitrary at the moment)
		
	}
	
	public void update(){
		//Keep track of using Delta time
		timeSinceLastShot += Delta();
		
		//Firing speed is the "cooldown" period between shots
		if (timeSinceLastShot > firingSpeed)
			shoot();
		
		//For all bullets active/in the array
		for (Bullet b: bullets)
			b.update(); //Update/move them
		
		draw(); //and draw them
	}
	
	//Same as Enemy's draw method
	public void draw(){
		DrawQuadTex(texture, x, y, width, height);
		DrawQuadTexRot(texture, x, y, width, height, 45);
	}

}
