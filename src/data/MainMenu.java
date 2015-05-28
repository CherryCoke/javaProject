package data;

import static helpers.Art.*;

import org.newdawn.slick.opengl.Texture;

import UI.UI;

public class MainMenu {
	
	//Declaring variables
	private Texture background;
	
	//Variable to hold screen's UI
	private UI menuUI;	
	
	
	public MainMenu(){
		background = QuickLoad("MainMenu");
		menuUI = new UI();
		menuUI.addButton("Play", "button",  WIDTH / 2 - 200, (int) (HEIGHT * 0.45f) - 100);
		menuUI.addButton("Editor", "button",  WIDTH / 2 - 200, (int) (HEIGHT * 0.45f));
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1496);
		menuUI.draw();
	}

}
