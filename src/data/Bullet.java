package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;
import static helpers.Clock.*;

public class Bullet {
	
	//Setting class variables
	private Texture texture;
	private float x, y, speed;
	private int damage;
	
	//Variables related to pathfinding/tracking
	private float xVelocity, yVelocity; //way the bullet is moving
	private Enemy target;
	
	public Bullet(Texture texture, Enemy target, float x, float y, float speed, 
			int damage){
		
		//Initializing class variables
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
		this.target = target;
		this.xVelocity = 0;
		this.yVelocity = 0;
		
		/*
		 Always calculate direction before doing anything else whenever a
		 bullet is reference/created/used
		 */
		calculateDirection();
	}
	
	private void calculateDirection(){
		 /*
		  Class to determine which direction an enemy is in relation
		  to the turret and in turn which direction the bullet needs
		  to move to hit an enemy
		  */
		 
		
		 /*
		   Makes the bullet appear to have physics, that is, 
		   it can't "bend," it can only move in a long as single
		   straight path (although the path can be diagonal)
		  */
		 float totalAllowedMovement = 1.0f;
		 
		 //Math.abs(olute value)
		 float xDistanceFromTarget = Math.abs(target.getX() 
				 - x - Game.TILE_SIZE / 4 + Game.TILE_SIZE / 2); 
		 float yDistanceFromTarget = Math.abs(target.getY() 
				 - y - Game.TILE_SIZE / 4 + Game.TILE_SIZE / 2);
		 float totalDistanceFromTarget = xDistanceFromTarget 
				 + yDistanceFromTarget;
		 
		 //How much of the distance will be across the x axis
		 float xPercentOfMovement = xDistanceFromTarget / 
				 totalDistanceFromTarget;
		 
		 /*
		  Determine the vector between bullet and enemy. Also helps
		  ensure the X and Y velocity never exceed 0.1f	
		  */
		 xVelocity = xPercentOfMovement;
		 yVelocity = totalAllowedMovement - xPercentOfMovement;
		 
		 /*
		  Ensures that bullets below or to the right of an enemy will
		  move in reverse since the coordinate system starts at
		  0,0.
		  
		  That way if the bullet is at 150, and the target is at 100,
		  the distance is still 50, but the bullet needs to move to the
		  left/a negative distance on the X axis to hit the target
		  */
		 if (target.getX() < x)
			 xVelocity *= -1;
		 if (target.getY() < y)
			 yVelocity *= -1;
	}
	
	public void update(){
		//Move in the proper direction (xVelocity) at the proper speed
		x += xVelocity * speed * Delta();
		y += yVelocity * speed * Delta();
		
		//Draw the new bullet's position/its "movement"
		draw();
	}
	
	public void draw(){
		DrawQuadTex(texture, x, y, 32, 32);
	}

}
