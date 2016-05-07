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
		eSinglePlayer, eMultiPlayer, eMenu, eDeveloper
	}
	public enum Game_Control_Events{
		eMouseMovement, eMouceClick
	}
	
	public ArrayList<Food_Drink> FallingObjects; /* List for the objects */
	public Player Plato; /* The player who has to catch the objects */
	public Game_Type eGameType;	/* Gma type of the current game */
	public Game_Control_Events eEvents;	/* Every event that changes the course of the game */
	public long gebugCntr;
	public GameSettings Settings;
	
	public GameState () {
		this.eGameType = Game_Type.eMenu;
		this.Plato = new Player( "Unknown username" );
		this.FallingObjects = new ArrayList<Food_Drink>();
		gebugCntr=0;
		this.Settings = new GameSettings();
		this.Settings.SizeX = 550;
		this.Settings.SizeY = 700;
		this.Settings.PlatoSizeX = 110;
		this.Settings.PlatoSizeY = 25;
		
		this.Plato.NewPos = new Position();
		this.Plato.NewPos.x = (double)(this.Settings.SizeX/2-this.Settings.PlatoSizeX/2);
		this.Plato.NewPos.y = (double)(this.Settings.SizeY-this.Settings.PlatoSizeY);

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
		if (x<this.Settings.PlatoSizeX/2) {
			x = this.Settings.PlatoSizeX/2;
		}
		if (x>this.Settings.SizeX-this.Settings.PlatoSizeX/2) {
			x = this.Settings.SizeX-this.Settings.PlatoSizeX/2;
		}
		this.Plato.NewPos.x = (double)(x-this.Settings.PlatoSizeX/2);
	}

	public Player getPlato() {
		return Plato;
	}
	
	@Override
	public String toString() {
		return "GameState [FallingObjects=" + FallingObjects + ", Plato=" + Plato + ", eGameType=" + eGameType + "]";
	}
	
}
