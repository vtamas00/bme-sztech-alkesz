/**
 * 
 */
package control;

import control.GameState.Game_Type;
import gui.Gui;

/**
 * This calls will instantiation the Gamestate and manage the main flow of the game.
 * 
 * @author chaah
 *
 */
public class Main {
	public static GameState currGameState;	/* Descriptor of the current game state */
	
	
	public static void main(String[] args) {
		Control myControl = new Control("Test",Game_Type.eDeveloper);
		Gui	myGui = new Gui(currGameState);
		
		myControl.TestInit();
		
		
		
	}
}
