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
	public static GameState GameState;	/* Descriptor of the current game state */

	
	public static void main(String[] args) {
		
		Gui	myGui = new Gui(GameState);
		Control myControl = new Control(GameState);

		
		
		
	}
}
