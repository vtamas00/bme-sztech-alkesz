/**
 *
 */
package control;

import java.util.ArrayList;

import control.Food_Drink.Food_Drinks_Type;

/**
 * @author Dani
 *
 */
public class Control {
	private ArrayList<Food_Drink> FallingObjects; /* List for the objects */
	private Player Plato; /* The player who has to catch the objects */

	/*********************** Constructors *************************************/

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
	 * @param elapsedTime
	 */
	public void ActualizeData(final int newPosX, final int elapsedTime) {
		// Calc the new pos of the Player
		Plato.setMyPos(new Position(newPosX, 0));
		// Determine the New pos of the Falling objects.
		for (int i = 0; i < FallingObjects.size(); i++) {
			FallingObjects.get(i).CalcNewPos(elapsedTime);

			if (true == FallingObjects.get(i).getMyPos().isPosAequalsPosB(FallingObjects.get(i).getMyPos(),
					Plato.getMyPos(), Plato.getMyBloodAlcoholRatio(), FallingObjects.get(i).getMySize())) {
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

	public void TestInit() {
		Food_Drink myFD = new Food_Drink(3, 5, Food_Drinks_Type.ePartyTray);
		Control myControl = new Control();
		System.out.println(myFD.toString());
		myControl.addFallingObjects(myFD);
		myControl.addFallingObjects(new Food_Drink(10, 3, Food_Drinks_Type.eHamburger));
		myControl.addFallingObjects(new Food_Drink(14, 4, Food_Drinks_Type.eLongSpirit));
		myControl.addFallingObjects(new Food_Drink(17, 5, Food_Drinks_Type.ePintOfBeer));

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

}
