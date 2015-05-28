package data;

import static helpers.Art.*;
import static helpers.Clock.Delta;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Tower {
	
	//Setting class varaibles
	private float x, y, timeSinceLastShot, firingSpeed, angle; //For setting tower
	private int width, height, damage;
	private Texture texture;
	private Tile startTile;
	private ArrayList<Bullet> bullets;
	private ArrayList<Enemy> enemies;
	private Enemy target; //Find a specific enemy
	
	public Tower(Texture texture, Tile startTile, int damage, 
			ArrayList<Enemy> enemies){
		//Initializing Class Variables
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.damage = damage;
		
		//Setting default values
		this.firingSpeed = 3;
		this.timeSinceLastShot = 0;
		this.bullets = new ArrayList<Bullet>();
		
		this.enemies = enemies;
		
		//Get the target, and the angle they are at from the tower
		this.target = acquireTarget();
		this.angle = calculateAngle();
	}
	
	private Enemy acquireTarget() {
		return enemies.get(0); //Target the "first" enemy/the oldest spawning
	}
	
	private float calculateAngle(){
		double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(angleTemp) - 90; //90 is necessary
	}
		
	private void shoot(){
		//Reset counter
		timeSinceLastShot = 0;
		
		bullets.add(new Bullet(QuickLoad("bullet"), target,  
				x + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, 
				y + Game.TILE_SIZE / 2 - Game.TILE_SIZE / 4, 
				450, 10)); //450 speed, 10 damage (arbitrary at the moment)
		
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
		
		//Continue tracking the enemy's angle
		angle = calculateAngle();
		
		draw(); //and draw them
		
	}
	
	//Same as Enemy's draw method
	public void draw(){
		DrawQuadTex(texture, x, y, width, height);
		DrawQuadTexRot(texture, x, y, width, height, angle);
	}

}
