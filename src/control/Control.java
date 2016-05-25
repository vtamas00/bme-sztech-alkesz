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
	/**
	 * Default time sample used by the whole game. 
	 */
	final public int TIME_SAMPLE = 20;
	private GameState currGameState;
	private boolean isEvent;
	public boolean isGameRunning;
	private long ObjGenCntr=0;
	/**
	 *  Counter to minimalize the amximum object number per sec.
	 */
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
				Food_Drink currObj = (Food_Drink) iteral.next();
				currObj.IncreaseMytime(TIME_SAMPLE);
				currObj.CalcNewPos(elapsedTime);
				
				
				// Compare the i.th object and the player position 
				if (true == currObj.getMyPos().isPosAequalsPosB(currObj.getMyPos(), currGameState.Plato.getMyPos(), currGameState.Plato.getMyBloodAlcoholRatio(), currObj.getMySize())) {
					// Plato and falling object pos is equal....
					currGameState.Plato.setMyScore(currObj.getMyScore());
					currGameState.Plato.setMyBloodAlcoholRatio(currObj.getBloodAlcoholRatio());
					System.out.println("\n\n The object was catched by the player:\n" + currObj.toString());
					System.out.println("Player Position:\t" + currGameState.getPlato().getMyPos().toString() +"\n" );
					
					iteral.remove();
				} else {
					// See if object is missed
					if (Position.screenHeight < currObj.getMyPos().y) { 
						currGameState.Plato.decreaseHealth();	// The player will lose some amount of health
						System.out.println("\n\n The object reached the zero point! :\n" + currObj.toString());
						System.out.println("Player Position:\t" + currGameState.getPlato().getMyPos().toString() +"\n" );
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
	 * This function will generate one new falling object with random parameters, in every 500 ms
	 */
	public void GenerateObjectsRandom( )
	{
		double objGenSpeed;
		// Need here some refactor 
		ObjGenCntr++;
		objGenSpeed=this.currGameState.Plato.getMyBloodAlcoholRatio()/5;
		switch(this.currGameState.eGameDiff){
		case eEasy:
			objGenSpeed=120-8*objGenSpeed;
			break;
		case eNormal:
			objGenSpeed=120-9*objGenSpeed;
			break;
		case eHard:
			objGenSpeed=120-10*objGenSpeed;
			break;
		case eInsane:
			objGenSpeed=100-10*objGenSpeed;
			break;
		}
//		System.out.println("objGenSpeed :" + objGenSpeed);
		if( ObjGenCntr > objGenSpeed)
		{
			Random rand = new Random();
			double newPosX = rand.nextDouble() * Position.screenWidth +1;
			Food_Drink newItem = new Food_Drink(newPosX, 0, new Food_Drink().RandomType());
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
		Food_Drink newItem = new Food_Drink(objectPos.x, 0, new Food_Drink().RandomType());
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
		if(this.isGameRunning)
		{
			this.isGameRunning=false;
		}
		else
		{
			this.isGameRunning=true;
		}
		
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
		if(this.isGameRunning )
		{
			currGameState.gebugCntr++;
			GenerateObjectsRandom();
			ActualizeData(TIME_SAMPLE);
			// just for debug
//			System.out.println("Player Position:\t" + currGameState.getPlato().getMyPos().toString() +"\n" );
			
			if( 0>= currGameState.Plato.getMyHealh())
			{
				bReturn=false;
			}
		}
		else
		{
			bReturn=false;
		}
		//FIXME .....
		
		return bReturn;
	}
	
	/**
	 * This function triggers the control to clear the game data, so it make the game to restart the game.
	 */
	public void RestartGame( )
	{
		try
		{
			this.isGameRunning=false;
			Thread.sleep(100);
			Iterator iteral = currGameState.FallingObjects.iterator();
			while(iteral.hasNext())
			{ 
				iteral.next();
				iteral.remove();

			}
			this.currGameState.Plato.ResetPlayer();
			this.currGameState.gebugCntr=0;
			this.ObjGenCntr=0;
			this.isGameRunning=true;
		}
		catch (InterruptedException e)
		{
			System.out.println("problem");
			e.printStackTrace();
		}
	}

}
