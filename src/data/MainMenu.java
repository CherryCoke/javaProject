package data;

import static helpers.Art.*;
import helpers.StateManager;
import helpers.StateManager.GameState;

import org.lwjgl.input.Mouse;
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
		menuUI.addButton("Play", "button", WIDTH / 2 - 200, (int) 
				(HEIGHT * 0.45f) - 200);
		menuUI.addButton("Editor", "button", WIDTH / 2 - 200, (int) 
				(HEIGHT * 0.45f) - 100);
		menuUI.addButton("Quit", "button", WIDTH / 2 - 200, (int) 
				(HEIGHT * 0.45f));
	}
	
	private void updateButtons(){
		//If the mouse has been clicked
		if (Mouse.isButtonDown(0)){
			//And a button has been clicked, do that action
			if(menuUI.isButtonClicked("Play"))
				StateManager.setState(GameState.GAME);
			if(menuUI.isButtonClicked("Editor"))
				StateManager.setState(GameState.EDITOR);
			if(menuUI.isButtonClicked("Quit"))
				System.exit(0);
		}
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1496);
		menuUI.draw();
		updateButtons();
	}

}
