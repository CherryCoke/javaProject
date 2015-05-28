package UI;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;
import static helpers.Art.*;

public class UI {
	
	private ArrayList<Button> buttonList;
	
	public UI() {
		
		//Initialize button 
		buttonList = new ArrayList<Button>();
	}
	
	public void addButton(String name, String textureName, int x, int y){
		buttonList.add(new Button(name, QuickLoad(textureName), x, y));
	}
	
	public void draw(){
		for (Button b : buttonList){
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), 
					b.getWidth(), b.getHeight());
		}
	}

}
