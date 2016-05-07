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
		
		System.out.println("Hello MIT");
		GameState = new GameState();
		
		Control myControl = new Control(GameState);
		Gui	myGui = new Gui(GameState,myControl);

		(new Thread(new GameTimer(myControl))).start();
		(new Thread(new GuiTimer(myGui))).start();
		System.out.println("Good By MIT!");
		
		
		
	}
}
