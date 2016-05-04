/**
 *
 */
package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TimerTask;

import control.Food_Drink.Food_Drinks_Type;
import control.GameState.Game_Type;

/**
 * This class contains the main logic of the game.    
 * 
 * @author Dani
 *
 */
public class Control{
	
	private GameState currGameState;
	private boolean isEvent;
	private boolean isGameRunning;
	private long ObjGenCntr=0;
	public long cntr=0;
	
	
	/*********************** Constructors *************************************/
	
	/**
	 * Default constructor of the Control class.
	 */
	public Control(GameState GameState) {
		currGameState = GameState;
		this.isEvent = false;
		this.isGameRunning=false;
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
	public void ActualizeData(final int elapsedTime){
		
		if(true == this.isEvent)
		{
			// Calc the new pos of the Player
			currGameState.Plato.setMyPos(currGameState.Plato.NewPos);
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
		ObjGenCntr++;
		if( ObjGenCntr*currGameState.Plato.getMyBloodAlcoholRatio() > 50)
		{
			Random rand = new Random();
			double newPosX = rand.nextDouble() * Position.screenWidth +1;
			Food_Drink newItem = new Food_Drink(newPosX, Position.screenHeight, new Food_Drink().RandomType());
			this.currGameState.addFallingObjects(newItem);
			ObjGenCntr=0;
		}
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
	
	/**
	 *	Indicates to the control class, that some changes was in the game field by the user. 
	 */
	public void HandleUserEvent( )
	{
		this.isEvent=true;
	}
	
	/**
	 * This function sets the flag of the control class that will start the actul game.
	 */
	public void StartGame( ){
		this.isGameRunning=true;
	}
	
	/**
	 * This function pause the game, with the start function you can continue it.
	 */
	public void Pause(){
		this.isGameRunning=false;
	}
	/**
	 * Force kill the player, this function will and the game!
	 */
	public void ForceGameOver(){
		for(int i=0;i<50;i++)
		{
			this.currGameState.Plato.getMyHealh();
		}
	}
	
	
	/**
	 * Just a sily teszt funciton
	 * @return if the counter is higher then the threadhol value the funciton returns false
	 */
	public boolean Tssshhh()
	{
		boolean bReturn = true;;
		cntr++;
		System.out.println("Tssssshhhh!\t" + System.currentTimeMillis());
		if( cntr > 100 )
		{
			bReturn=false;
		}
		return bReturn;
	}
	
	
	/**
	 * This method called by the timer class, and this makes the main process of the control class.
	 * @return false, is the game is over.
	 */
	public boolean RefreshData()
	{
		boolean bReturn = true;
		if( true == this.isGameRunning )
		{
			currGameState.gebugCntr++;
			GenerateObjectsRandom();
			ActualizeData(20);
			if( 0>= currGameState.Plato.getMyHealh())
			{
				bReturn=false;
			}
		}
		return bReturn;
	}

}
