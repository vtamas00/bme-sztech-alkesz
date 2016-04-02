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
	ArrayList<Food_Drink> FallingObjects = new ArrayList<Food_Drink>();

	/**
	 * @return the fallingObjects
	 */
	public ArrayList<Food_Drink> getFallingObjects() {
		return FallingObjects;
	}

	/**
	 * @param fallingObjects the fallingObjects to set
	 */
	public void addFallingObjects(Food_Drink fallingObjects) {
		FallingObjects.add(fallingObjects);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String myString = new String();
		for(int i=0;i<FallingObjects.size();i++)
		{
			myString += "[FallingObjects("+i+")=" + FallingObjects.get(i) + "]\n";
		}
		return myString;
	} 
	
	public Control() {}
	
	public void TestInit( ) {
		Position Pos = new Position(3, 2);
		Food_Drink myFD = new Food_Drink(3, 5, Food_Drinks_Type.ePartyTray);
		Control myControl = new Control();
		System.out.println(Pos.toString());
		System.out.println(myFD.toString());
		myControl.addFallingObjects(myFD);
		myControl.addFallingObjects(new Food_Drink(10, 3, Food_Drinks_Type.eHamburger));
		myControl.addFallingObjects(new Food_Drink(14, 4, Food_Drinks_Type.eLongSpirit));
		myControl.addFallingObjects(new Food_Drink(17, 5, Food_Drinks_Type.ePintOfBeer));
		
		System.out.println(myControl.toString());
	}

}
