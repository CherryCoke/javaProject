package UI;

import static helpers.Art.DrawQuadTex;
import static helpers.Art.HEIGHT;
import static helpers.Art.QuickLoad;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

public class UI {
	
	private ArrayList<Button> buttonList;
	
	public UI() {
		
		//Initialize button 
		buttonList = new ArrayList<Button>();
	}
	
	public void addButton(String name, String textureName, int x, int y){
		buttonList.add(new Button(name, QuickLoad(textureName), x, y));
		
	}
	
	//Determine if a button has been clicked
	public boolean isButtonClicked(String buttonName){
		Button b = getButton(buttonName);
		float mouseY = HEIGHT - Mouse.getY() - 1;
		
		if (Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth()
				&& mouseY > b.getY() && mouseY < b.getY() + b.getHeight()){
			return true;
		}
		return false;
	}
	
	private Button getButton(String buttonName){
		//If a button in button list is clicked
		for (Button b : buttonList){
			if (b.getName().equals(buttonName)){
				return b; //return that button
			}
		}
		return null; //else do nothing
	}
	
	public void draw(){
		for (Button b : buttonList){
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), 
					b.getWidth(), b.getHeight());
		}
	}

}
