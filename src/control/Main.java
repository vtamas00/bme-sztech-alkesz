/**
 * 
 */
package control;

import gui.Gui;

/**
 * This calls will instantiation the Gamestate and manage the main flow of the game.
 * 
 * @author chaah
 *
 */
public class Main {
	public static GameState GameState;	/* Descriptor of the current game state */
	
	public static void main(String[] args) {
		
		System.out.println("Hello MIT");
		/**
		 * The gamestate descriptor common variable.
		 */
		GameState = new GameState();
		
		Control myControl = new Control(GameState);
		Gui	myGui = new Gui(GameState,myControl);

		(new Thread(new GameTimer(myControl,myGui))).start();
		System.out.println("Good By MIT!");
		
	}
}
