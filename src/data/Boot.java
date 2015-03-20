/*
Tyler Bonnette
16 Mar 2015
Version 0.1.0
 */

package data;


import org.lwjgl.opengl.Display;

//* is a wildcard, so it imports everything
import static helpers.Art.*;


public class Boot {
	//Class handles the creates, defines, and runs the game window
	
	//Creating Boot Constructor
	public Boot() {
		
		//Call BeginSession method from Art helper
		BeginSession();
		
		/*
		Loop to keep the window open
		Line below basically says: while close isn't being pressed
		*/
		while(!Display.isCloseRequested()){	
			
			//Draw a pair of squares on the screen
			DrawQuad(50, 50, 100, 100);
			DrawQuad(150, 150, 100, 100);
			
			//Everytime the loop finishes update the screen
			Display.update();
			//Sync is the (maximum) FPS
			Display.sync(100);
		}
		
		//While the above ISN'T true, destroy the game window
		Display.destroy();
	}
	
	//Entry point for program
	public static void main(String[] args){
		//Run the game window/an instance of the Boot class
		new Boot();
	}
	

}
