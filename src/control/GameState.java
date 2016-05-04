/**
 * 
 */
package control;

import java.util.ArrayList;

/**
 * @author chaah
 * 
 * This Calss contains every data releated to the game.
 *
 */
public class GameState {
	public enum Game_Type{
		eSinglePlayer, eMultiPlayer, eDeveloper
	}
	public enum Game_Control_Events{
		
	}
	
	public ArrayList<Food_Drink> FallingObjects; /* List for the objects */
	public Player Plato; /* The player who has to catch the objects */
	public Game_Type eGameType;	/* Gma type of the current game */
	public Game_Control_Events eEvents;	/* Every event that changes the course of the game */
	
	
	public GameState( String myName, Game_Type eGameType )
	{
		this.eGameType = eGameType;
		this.Plato = new Player( myName );
		this.FallingObjects = new ArrayList<Food_Drink>();
	}
	
	/**
	 * @param fallingObjects
	 *            the fallingObjects to set
	 */
	public void addFallingObjects(final Food_Drink fallingObjects) {
		FallingObjects.add(fallingObjects);
	}

	/**
	 * @return the fallingObjects
	 */
	public ArrayList<Food_Drink> getFallingObjects() {
		return FallingObjects;
	}

	/**
	 * @return the plato
	 */
	public Player getPlato() {
		return Plato;
	}
	
	@Override
	public String toString() {
		return "GameState [FallingObjects=" + FallingObjects + ", Plato=" + Plato + ", eGameType=" + eGameType + "]";
	}
	
}
