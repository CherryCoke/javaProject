package helpers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Art {
	
	/*final means these two ints cannot be changed
	during runtime, nor can they be extended to */
	public static final int WIDTH = 600, HEIGHT = 400;
	
	public static void BeginSession(){
		//Class to Begin the session/start the game
		
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
	}
	
	public static void DrawQuad(float x, float y, float width, float height){
		//Draws a square/rectangle
		glBegin(GL_QUADS);
		glVertex2f(x, y);                  //Top right corner
		glVertex2f(x + width, y);          //Top left
		glVertex2f(x + width, y + height); //Bot right
		glVertex2f(x, y + height);         //Bot left
		glEnd();
	}
		

}































