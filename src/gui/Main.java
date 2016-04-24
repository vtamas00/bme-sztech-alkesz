/**
 * 
 */
package gui;

import control.Control;
import control.GameState.Game_Type;
import gui.Gui; 

/**
 * @author Dani
 *
 */
public class Main {

	/**
	 * @param args Command line argument to the program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello MIT!");

		Control myControl = new Control("Test",Game_Type.eSinglePlayer);
		Gui myGui = new Gui();
		
		myControl.TestInit();
		
	}

}
