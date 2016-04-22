/**
 *
 */
package control;

import java.util.ArrayList;
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
		for (int i = 0; i < FallingObjects.size(); i++) {
			FallingObjects.get(i).CalcNewPos(elapsedTime);

			if (true == FallingObjects.get(i).getMyPos().isPosAequalsPosB(FallingObjects.get(i).getMyPos(), Plato.getMyPos(), Plato.getMyBloodAlcoholRatio(), FallingObjects.get(i).getMySize())) {
				// Plato and falling object pos is equal....
				Plato.setMyScore(FallingObjects.get(i).getMyScore());
				Plato.setMyBloodAlcoholRatio(FallingObjects.get(i).getBloodAlcoholRatio());

				// FIXME if we delete here and continue the iteration, we will
				// jump over one element, or if
				// this is the element before the last one, there will be an
				// IndexOutOfBoundException. An
				// Iterator should be used: list.iterator();
				// for(iterator.hasNext()) {Element e =
				// iterator.next(); ... iterator.remove()}
				FallingObjects.remove(i);
			} else {
				if (0 > FallingObjects.get(i).getMyPos().y) {
					Plato.decreaseHealth();
					FallingObjects.remove(i); // remove object
				}
			}

		}
	}

	/**
	 * Simple test function is to try the main methods of the class.
	 */
	public void TestInit() {
		Control myControl = new Control();

		
		myControl.GenerateObjectsRandom();
		myControl.GenerateObjectsRandom();
		myControl.GenerateObjectsRandom();
		myControl.GenerateObjectsRandom();
		myControl.GenerateObjectsRandom();


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
