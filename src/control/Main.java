/**
 * 
 */
package control;

import control.GameState.Game_Type;

/**
 * This calls will instantiation the Gamestate and manage the main flow of the game.
 * 
 * @author chaah
 *
 */
public class Main {
	
	
	
	public static void main(String[] args) {
		Control myControl = new Control("Test",Game_Type.eDeveloper);
		
		myControl.TestInit();
		
		
	}
}
