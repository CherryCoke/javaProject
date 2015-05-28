package helpers;

import data.Editor;
import data.Game;
import data.MainMenu;

public class StateManager {
	/*
	 State manager looks at what part of the game is being
	 accessed/used/played, and updates that section of that 
	 program, so it needs a reference/copy of every state/area
	 of the game (the corresponding data classes)
	 */
	
	public static enum GameState {
		//The three different states/areas of the game
		MAINMENU, GAME, EDITOR
	}
	
	//Declaring each enum
	public static GameState gameState = GameState.MAINMENU; //Start with MainM
	public static MainMenu mainMenu;
	public static Game game;
	public static Editor editor;
	
	public static void update(){
		//Look at what gameState is set to, and initilize that case
		switch (gameState){
		case MAINMENU:
			//First time the game is run there will be no main menu
			if (mainMenu == null)
				mainMenu = new MainMenu(); // so create one
			mainMenu.update();
			break;
		case GAME:
			break;
		case EDITOR:
			break;
		}
	}
}
