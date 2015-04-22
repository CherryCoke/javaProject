package helpers;

import org.lwjgl.Sys;

public class Clock {
	
	private static boolean paused = false;
	
	//Long because the integer will be huge
	public static long  lastFrame, totalTime;
	
	//d stands for delta time; multiplier is for speed/movement
	public static float d = 0, multiplier = 1;
	
	public static long getTime() {
		//*1000 because getTime returns a number in milliseconds
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	//Used by moving entities (enemies/towers)
	public static float getDelta() {
		/*
		 Delta time is the difference between right now/
		 that specific moment, and the last update of that 
		 entities data, so that even if there's lag everything
		 is moving at the same speed.
		 */
		long currentTime = getTime();
		
		//(int) makes sure the result will be an integer
		int delta = (int)(currentTime - lastFrame);
		lastFrame = getTime(); //reset lastFrame to right now
		return delta * 0.01f; //return delta time
	}
	
	public static float Delta(){
		if (paused)
			return 0;
		else
			//Multiplier is a speed multiplier
			return d * multiplier;
	}
	
	//Getters for totalTime and Multiplier
	public static float TotalTime(){
		return totalTime;
	}
	
	public static float Multiplier(){
		return multiplier;
	}
	
	//For everytime the game does thorugh an update cycle
	public static void update(){
		d = getDelta();
		totalTime += d;
	}
	
	//Used to change multiplier from other classes
	public static void ChangeMultiplier(int change){
		// || stands for NOT
		if (multiplier + change < -1 || multiplier + change > 7){
			
		} else {
			multiplier += change;
		}
	}
	
	//Allows game to be (un)paused from other classes
	public static void Pause(){
		if (paused)
			paused = false;
		else
			paused = true;
	}
}
