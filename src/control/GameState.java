/**
 * 
 */
package control;

import java.util.ArrayList;

/**
 * This Calss contains every data releated to the game.
 * 
 * @author chaah
 *
 */
public class GameState {
	/**
	 * Contains every possible game mode.
	 * 
	 * @author chaah
	 *
	 */
	public enum Game_Type{
		eSinglePlayer, eMultiPlayer, eMenu, eDeveloper
	}
	/**
	 * Contains the possible event which could occure on the side of the player.
	 * 
	 * @author chaah
	 *
	 */
	public enum Game_Control_Events{
		eMouseMovement, eMouceClick
	}
	
	/**
	 * Server or host mode of the multi game.
	 * 
	 * @author chaah
	 *
	 */
	public enum Game_Place
	{
		eServer, eHost	
	}
	
	/**
	 * List for the objects
	 */
	public ArrayList<Food_Drink> FallingObjects;  
	
	/**
	 * The player who has to catch the objects
	 */
	public Player Plato; 
	
	/**
	 * Game type of the current game
	 */
	public Game_Type eGameType;	 
	
	/**
	 * Every event that changes the course of the game
	 */
	public Game_Control_Events eEvents; 
	
	/**
	 * Just a debug counter
	 */
	public long gebugCntr;
	
	
	/**
	 * Location type of the current game.
	 */
	public Game_Place eGameLocationType;
	
	public GameState () {
		this.eGameType = Game_Type.eMenu;
		this.Plato = new Player( "CunciSquirrel" );
		this.FallingObjects = new ArrayList<Food_Drink>();
		gebugCntr=0;
		
		this.Plato.NewPos = new Position();
		this.Plato.NewPos.x = (double)(Position.screenWidth/2-this.Plato.sizeX/2);
		this.Plato.NewPos.y = (double)(Position.screenHeight-this.Plato.sizeY);
		this.Plato.myPos = this.Plato.NewPos;
		this.eGameLocationType = Game_Place.eServer;
	}
	
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

	public void NPos(double x) {
		if (x<this.Plato.sizeX/2) {
			x = this.Plato.sizeX/2;
		}
		if (x>this.Plato.sizeX-this.Plato.sizeX/2) {
			x = this.Plato.sizeX-this.Plato.sizeX/2;
		}
		this.Plato.NewPos.x = (double)(x-this.Plato.sizeX/2);
	}

	public Player getPlato() {
		return Plato;
	}
	
	@Override
	public String toString() {
		return "GameState [FallingObjects=" + FallingObjects + ", Plato=" + Plato + ", eGameType=" + eGameType + "]";
	}
	
}
