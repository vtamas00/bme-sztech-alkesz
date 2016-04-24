/**
 *
 */
package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import control.Food_Drink.Food_Drinks_Type;

/**
 * This class contains the main logic of the game.    
 * 
 * @author Dani
 *
 */
public class Control {
	private ArrayList<Food_Drink> FallingObjects; /* List for the objects */
	private Player Plato; /* The player who has to catch the objects */
	
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

	/**
	 * @param plato
	 *            the plato to set
	 */
	private void setPlato(final Player plato) {
		Plato = plato;
	}
	
	/*********************** Constructors *************************************/

	/**
	 * Default constructor of the Control class.
	 */
	public Control() {
		setPlato(new Player());
		this.FallingObjects = new ArrayList<Food_Drink>();
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
		Plato.setMyPos(new Position(newPosX, 0));
		// Determine the New pos of the Falling objects.
		Iterator iteral = FallingObjects.iterator();
		while(iteral.hasNext()) {
			Food_Drink CurrObj = (Food_Drink) iteral.next();
			CurrObj.CalcNewPos(elapsedTime);
			
			// Compare the i.th object and the player position 
			if (true == CurrObj.getMyPos().isPosAequalsPosB(CurrObj.getMyPos(), Plato.getMyPos(), Plato.getMyBloodAlcoholRatio(), CurrObj.getMySize())) {
				// Plato and falling object pos is equal....
				Plato.setMyScore(CurrObj.getMyScore());
				Plato.setMyBloodAlcoholRatio(CurrObj.getBloodAlcoholRatio());
				System.out.println("\n\n The object was catched by the player:\n" + CurrObj.toString());
				
				iteral.remove();
			} else {
				// See if object is missed
				if (0 > CurrObj.getMyPos().y) {
					Plato.decreaseHealth();
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
		Control myControl = new Control();

		
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
		for (int i = 0; i < FallingObjects.size(); i++) {
			myString += "[FallingObjects(" + i + ")=" + FallingObjects.get(i) + "]\n";
		}
		myString += Plato.toString();
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
		this.addFallingObjects(newItem);
	}
	
	/**
	 * This function generates an object with the given parameters.
	 * 
	 * @param objectPos position of the new object
	 */
	public void GenerateObject( Position objectPos )
	{
		Food_Drink newItem = new Food_Drink(objectPos.x, Position.screenHeight, new Food_Drink().RandomType());
		this.addFallingObjects(newItem);
	}

}
