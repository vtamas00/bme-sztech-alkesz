/**
 * 
 */
package control;

import java.util.Timer;

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
		
		GameState = new GameState();
		
		Gui	myGui = new Gui(GameState);
		Control myControl = new Control(GameState);

		GameTimer gT = new GameTimer(myControl);
		
		
		// Where you can now call the Control and Gui run methods.!
//		gT.run();
		
	}
}
