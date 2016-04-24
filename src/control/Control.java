/**
 *
 */
package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import control.Food_Drink.Food_Drinks_Type;
import control.GameState.Game_Type;

/**
 * This class contains the main logic of the game.    
 * 
 * @author Dani
 *
 */
public class Control {
	public GameState currGameState;	/* Descriptor of the current game state */
	
	
	
	/*********************** Constructors *************************************/
	
	/**
	 * Default constructor of the Control class.
	 */
	public Control(String playerName, Game_Type eGameType) {
		
		this.currGameState = new GameState(playerName, eGameType);
	}

	/************************* General methods ********************************/
	
	/**
	 * ActualizeData function is recalculate every dynamic variable. Has to call
	 * it in every time stamp.
	 *
	 * @param newPosX
	 *            New position of the player
	 * @param elapsedTime
	 *            Elapsed time since the last call - Sampling Time if it is a
	 *            constant variable.
	 */
	public void ActualizeData(final int newPosX, final int elapsedTime) {
		// Calc the new pos of the Player
		currGameState.Plato.setMyPos(new Position(newPosX, 0));
		// Determine the New pos of the Falling objects.
		Iterator iteral = currGameState.FallingObjects.iterator();
		while(iteral.hasNext()) {
			Food_Drink CurrObj = (Food_Drink) iteral.next();
			CurrObj.CalcNewPos(elapsedTime);
			
			// Compare the i.th object and the player position 
			if (true == CurrObj.getMyPos().isPosAequalsPosB(CurrObj.getMyPos(), currGameState.Plato.getMyPos(), currGameState.Plato.getMyBloodAlcoholRatio(), CurrObj.getMySize())) {
				// Plato and falling object pos is equal....
				currGameState.Plato.setMyScore(CurrObj.getMyScore());
				currGameState.Plato.setMyBloodAlcoholRatio(CurrObj.getBloodAlcoholRatio());
				System.out.println("\n\n The object was catched by the player:\n" + CurrObj.toString());
				
				iteral.remove();
			} else {
				// See if object is missed
				if (0 > CurrObj.getMyPos().y) {
					currGameState.Plato.decreaseHealth();
					System.out.println("\n\n The object reached the zero point! :\n" + CurrObj.toString());
					iteral.remove(); // remove object
				}
			}

		}
	}

	/**
	 * Simple test function is to try the main methods of the class.
	 */
	public void TestInit() {
		Control myControl = new Control("LocalTest",Game_Type.eSinglePlayer);

		
		for(int i=1;i<30;i++)
		{
			myControl.GenerateObjectsRandom();
		}

		System.out.println(myControl.toString());

		myControl.ActualizeData(10, 5);
		System.out.println(myControl.toString());
		myControl.ActualizeData(10, 10);
		System.out.println(myControl.toString());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String myString = new String();
		for (int i = 0; i < currGameState.FallingObjects.size(); i++) {
			myString += "[FallingObjects(" + i + ")=" + currGameState.FallingObjects.get(i) + "]\n";
		}
		myString += currGameState.Plato.toString();
		return myString;
	}
	
	/**
	 * This function will generate one new falling object with random parameters.
	 */
	public void GenerateObjectsRandom( )
	{
		Random rand = new Random();
		
		double newPosX = rand.nextDouble() * Position.screenWidth +1;
		Food_Drink newItem = new Food_Drink(newPosX, Position.screenHeight, new Food_Drink().RandomType());
		this.currGameState.addFallingObjects(newItem);
	}
	
	/**
	 * This function generates an object with the given parameters.
	 * 
	 * @param objectPos position of the new object
	 */
	public void GenerateObject( Position objectPos )
	{
		Food_Drink newItem = new Food_Drink(objectPos.x, Position.screenHeight, new Food_Drink().RandomType());
		this.currGameState.addFallingObjects(newItem);
	}

}
