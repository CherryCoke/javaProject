/*
Tyler Bonnette
16 Mar 2015
Version 0.1.0
 */

package data;


import org.lwjgl.opengl.Display;

//* is a wildcard, so it imports everything
import static org.lwjgl.opengl.GL11.*;
import static helpers.Art.*;


public class Boot {
	//Class handles the creates, defines, and runs the game window
	
	//Creating Boot Constructor
	public Boot() {
		
		//Call BeginSession method from Art helper
		BeginSession();
		
		
		
		float width = 50;
		float height = 50;
		float squarex = 100;
		float squarey = 100;
		
		/*
		Loop to keep the window open
		Line below basically says: while close isn't being pressed
		*/
		while(!Display.isCloseRequested()){
			
			//Drawing a line
			glBegin(GL_LINES); //Begin creating the line
			//Beginning followed by end vertexes for the line
			glVertex2f(10, 10); //2f means 2 floats, 2i means 2 integers
			glVertex2f(100, 100);
			glEnd(); //Finish drawing the line
			
			//Drawing a Square...Vertexes are defined going clockwise
			glBegin(GL_QUADS);
			glVertex2f(squarex, squarey);                  //Top right corner
			glVertex2f(squarex + width, squarey);          //Top left
			glVertex2f(squarex + width, squarey + height); //Bot right
			glVertex2f(squarex, squarey + height);         //Bot left
			glEnd();
			
			
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
