/*
Tyler Bonnette
16 Mar 2015
Version 0.1.0
 */

package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

//* is a wildcard, so it imports everything
import static org.lwjgl.opengl.GL11.*;


public class Boot {
	//Class handles the creates, defines, and runs the game window
	
	//Creating Boot Constructor
	public Boot() {
		
		//Setting game window title/description
		Display.setTitle("Java Tower Defense");
		
		/*
		Try catch, more or less, means, "if something
		goes wrong, don't blow up the computer, just stop
		where it is, and print out what went wrong
		*/
		try {
			//Setting dimensions for and creating screen
			Display.setDisplayMode(new DisplayMode(600, 400));
			Display.create();
		} catch (LWJGLException e) { //If the window crashses
			//Prints out the error if game fails to launch
			e.printStackTrace();
		}
		
		//The following section is used to initialize LWJGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glMatrixMode(GL_MODELVIEW);
		/*
		 glOrtho is the "camera," or bounding box, of the screen
		 So 0 is the top left, 600 is the top right, 400 the bottom
		 left, etc... The last two numbers are for 3d graphics, but
		 this is a 2d project so they are 1 and -1 because they won't 
		 be used
		 */
		glOrtho(0, 600, 400, 0, 1, -1);
		
		
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
