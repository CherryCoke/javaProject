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
		
		//Creating new tiles
		Tile tile = new Tile(0, 0, 64, 64, TileType.Grass);
		Tile tile2 = new Tile(64, 0, 64, 64, TileType.Dirt);
		
		/*
		Loop to keep the window open
		Line below basically says: while close isn't being pressed
		*/
		
		while(!Display.isCloseRequested()){	
			
			//Draw/render the tiles made above
			DrawQuadTex(tile.getTexture(), tile.getX(), tile.getY(),
						tile.getWidth(), tile.getHeight());
			
			DrawQuadTex(tile2.getTexture(), tile2.getX(), tile2.getY(),
					tile2.getWidth(), tile2.getHeight());
			
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
