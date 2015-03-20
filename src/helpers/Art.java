package helpers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Art {
	
	/*final means these two ints cannot be changed
	during runtime, nor can they be extended to */
	public static final int WIDTH = 1280, HEIGHT = 960;
	
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
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) { //If the window crashses
			//Prints out the error if game fails to launch
			e.printStackTrace();
		}
				
		//The following section is used to initialize LWJGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		/*
		 glOrtho is the "camera," or bounding box, of the screen
		 So 0 is the top left, 600 is the top right, 400 the bottom
		 left, etc... The last two numbers are for 3d graphics, but
		 this is a 2d project so they are 1 and -1 because they won't 
		 be used
		 */
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D); //Enables drawing textures
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
	
	public static void DrawQuadTex(Texture tex, float x, float y, float width,
			   float height){
		//Bind texture to Opengl/the screen
		tex.bind();

		/*
		glTranslate gets rid of magic numbers. Without it specific numbers have to be 
		defined for each vertex, translate makes it so the top-right coordinate
		becomes the "new" 0,0. This way, rather than having to type x + width,
		you can add just write  width because the top-right vertex is now 0,0

		glTranslate takes a x, y, and z dimension, but the game is 2d so the z is 0 
		 */
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0); //TexCoord is Texture coordinate, the top right is 0,0 
		glVertex2f(0, 0);  
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		
		glEnd();
		glLoadIdentity(); //Prevents screen tearing
		
	}
	
	//A texture needs to be returned, not a void 
	public static Texture LoadTexture(String path, String fileType){
		//Make blank variable...will override 
		Texture tex = null;
		
		// 'Imports' files from out of the program to use them as resources
		InputStream in = ResourceLoader.getResourceAsStream(path);
		
		//Load texture of a fileType at the "in" path
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace(); //Return error if one occurs
		}
		
		return tex;
	}
	
	
	
	//Retrieves path to load textures 
	public static Texture QuickLoad(String name){
		Texture tex = null;
		
		//Automatically get the path to a texture by its name
		tex = LoadTexture("res/" + name + ".png", "PNG");
		
		return tex;
		
		
	}
		

}































