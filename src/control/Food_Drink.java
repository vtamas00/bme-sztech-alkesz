/**
 * 
 */
package control;

import java.util.Random;

/**
 * This class contains the handles the different objects of the game.
 * 
 * @author Dani
 *
 */
public class Food_Drink {

	/**
	 * Contains the every possible object that the player has to catch.
	 * 
	 * @author chaah
	 *
	 */
	public enum Food_Drinks_Type{
		eGlassOfBeer, ePintOfBeer, eGlassOfVine, eCoctail,
		eSmallSpirit, eLongSpirit, eHFullofSunfSeed, eHFullofPeanuts,
		eSliceofPizza, eFattyBoard, eGyros, eHamburger, ePartyTray
	}
	
	/**
	 * Position of the object
	 */
	public Position myPos;		
	/**
	 * Object type
	 */
	private Food_Drinks_Type myType;
	/**
	 * [Pixel/ms]
	 */
	private int mySpeed;		
	/**
	 * Round shape objects, this is the radius [pixels]
	 */
	public int mySize;			
	/**
	 * Value of the object 
	 */
	private int myScore;		
	private int bloodAlcoholRatio; 
	private int special;
	/**
	 * This variable indicates that how old it this object is.
	 */
	public int timeInGame;
	
	/**
	 * @return the myPos
	 */
	public Position getMyPos() {
		return myPos;
	}
	/**
	 * @param myPos the myPos to set
	 */
	public void setMyPos(Position myPos) {
		this.myPos = myPos;
	}
	/**
	 * @return the myType
	 */
	public Food_Drinks_Type getMyType() {
		return myType;
	}
	/**
	 * @param myType the myType to set
	 */
	public void setMyType(Food_Drinks_Type myType) {
		this.myType = myType;
	}
	/**
	 * @return the mySpeed
	 */
	public int getMySpeed() {
		return mySpeed;
	}
	
	/**
	 * Increase the value of timeInGame variable with the global Time sample constants: 20[ms].
	 * @param elapsedTime Time elapsed since the last check.
	 */
	public void IncreaseMytime(int elapsedTime )
	{
		this.timeInGame=this.timeInGame+elapsedTime;
	}
	/**
	 * @param myType determines the speed of the object
	 */
	private void setMySpeed(Food_Drinks_Type myType) {
		switch(myType)
		{
			case ePartyTray:
			{
				this.mySpeed = 9;
				break;
			}
			case eGlassOfBeer:
			{
				this.mySpeed = 2;
				break;
			}
			case ePintOfBeer:
			{
				this.mySpeed = 3;
				break;
			}
			case eGlassOfVine:
			{
				this.mySpeed = 4;
				break;
			}
			case eCoctail:
			{
				this.mySpeed = 5;
				break;
			}
			case eSmallSpirit:
			{
				this.mySpeed = 6;
				break;
			}
			case eLongSpirit:
			{
				this.mySpeed = 7;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.mySpeed = 2;
				break;
			}
			case eHFullofPeanuts:
			{
				this.mySpeed = 3;
				break;
			}
			case eFattyBoard:
			{
				this.mySpeed = 4;
				break;
			}
			case eSliceofPizza:
			{
				this.mySpeed = 5;
				break;
			}
			case eGyros:
			{
				this.mySpeed = 6;
				break;
			}
			case eHamburger:
			{
				this.mySpeed = 7;
				break;
			}
			default:
			{
				this.mySpeed = 2;
				break;
			}
		} // switch
		
	}
	/**
	 * @return the bloodAlcoholRatio
	 */
	public int getBloodAlcoholRatio() {
		return bloodAlcoholRatio;
	}
	/**
	 * @param myType Type of the current object
	 */
	private void setBloodAlcoholRatio(Food_Drinks_Type  myType) {
		switch(myType)
		{
			case ePartyTray:
			{
				this.bloodAlcoholRatio = 0;
				break;
			}
			case eGlassOfBeer:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case ePintOfBeer:
			{
				this.bloodAlcoholRatio = 2;
				break;
			}
			case eGlassOfVine:
			{
				this.bloodAlcoholRatio = 4;
				break;
			}
			case eCoctail:
			{
				this.bloodAlcoholRatio = 8;
				break;
			}
			case eSmallSpirit:
			{
				this.bloodAlcoholRatio = 12;
				break;
			}
			case eLongSpirit:
			{
				this.bloodAlcoholRatio = 20;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.bloodAlcoholRatio = -1;
				break;
			}
			case eHFullofPeanuts:
			{
				this.bloodAlcoholRatio = -2;
				break;
			}
			case eFattyBoard:
			{
				this.bloodAlcoholRatio = -4;
				break;
			}
			case eSliceofPizza:
			{
				this.bloodAlcoholRatio = -5;
				break;
			}
			case eGyros:
			{
				this.bloodAlcoholRatio = -8;
				break;
			}
			case eHamburger:
			{
				this.bloodAlcoholRatio = -12;
				break;
			}
			default:
			{
				this.bloodAlcoholRatio = 0;
				break;
			}

		} // switch
	}
	/**
	 * @return the mySize
	 */
	public int getMySize() {
		return mySize;
	}
	/**
	 * @param myType is the type of the current object
	 */
	private void setMySize(Food_Drinks_Type  myType) {
		switch(myType)
		{
			case ePartyTray:
			{
				this.mySize = 3;
				break;
			}
			case eGlassOfBeer:
			{
				this.mySize = 10;
				break;
			}
			case ePintOfBeer:
			{
				this.mySize = 8;
				break;
			}
			case eGlassOfVine:
			{
				this.mySize = 7;
				break;
			}
			case eCoctail:
			{
				this.mySize = 6;
				break;
			}
			case eSmallSpirit:
			{
				this.mySize = 5;
				break;
			}
			case eLongSpirit:
			{
				this.mySize = 4;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.mySize = 10;
				break;
			}
			case eHFullofPeanuts:
			{
				this.mySize = 8;
				break;
			}
			case eFattyBoard:
			{
				this.mySize = 7;
				break;
			}
			case eSliceofPizza:
			{
				this.mySize = 6;
				break;
			}
			case eGyros:
			{
				this.mySize = 5;
				break;
			}
			case eHamburger:
			{
				this.mySize = 4;
				break;
			}
			default:
			{
				this.mySize = 2;
				break;
			}
		} // switch
		this.mySize=4*this.mySize;
	}
	/**
	 * @return the myScore
	 */
	public int getMyScore() {
		return myScore;
	}
	/**
	 * @param myType is the type of the current object
	 */
	private void setMyScore(Food_Drinks_Type  myType) {
		switch(myType)
		{
			case ePartyTray:
			{
				this.myScore = 1000;
				break;
			}
			case eGlassOfBeer:
			{
				this.myScore = 30;
				break;
			}
			case ePintOfBeer:
			{
				this.myScore = 50;
				break;
			}
			case eGlassOfVine:
			{
				this.myScore = 100;
				break;
			}
			case eCoctail:
			{
				this.myScore = 200;
				break;
			}
			case eSmallSpirit:
			{
				this.myScore = 300;
				break;
			}
			case eLongSpirit:
			{
				this.myScore = 500;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.myScore = 10;
				break;
			}
			case eHFullofPeanuts:
			{
				this.myScore = 30;
				break;
			}
			case eFattyBoard:
			{
				this.myScore = 50;
				break;
			}
			case eSliceofPizza:
			{
				this.myScore = 100;
				break;
			}
			case eGyros:
			{
				this.myScore = 200;
				break;
			}
			case eHamburger:
			{
				this.myScore = 300;
				break;
			}
			default:
			{
				this.myScore = 0;
				break;
			}
		} // switch
	}
	/**
	 * @return the spcial
	 */
	public int getSpcial() {
		return special;
	}
	/**
	 * @param myType is the type of the current object
	 */
	private void setSpcial(Food_Drinks_Type  myType) {
		if(Food_Drinks_Type.ePartyTray == myType)
		{
			this.special = 3;
		}
		else
		{
			this.special = 0;
		}
		
	}
	
	/*************************** Contructors **********************************/
	/**
	 * Default constructor
	 */
	public Food_Drink()
	{
		this.myPos = new Position();
		this.myType = Food_Drinks_Type.ePartyTray;
		setMySpeed(this.myType);
		setBloodAlcoholRatio(this.myType);
		setMySize(this.myType);
		setMyScore(this.myType);
		setSpcial(this.myType);
		
	}
	
	/**
	 * 
	 * @param x0 is the first x coordinate
	 * @param y0 is the first y coordinate
	 * @param myType is the type of the object
	 */
	public Food_Drink( double x0, double y0, Food_Drinks_Type myType)
	{
		this.myPos = new Position(x0, y0);
		this.myType = myType;
		setMySpeed(this.myType);
		setBloodAlcoholRatio(this.myType);
		setMySize(this.myType);
		setMyScore(this.myType);
		setSpcial(this.myType);
	}
	/**
	 * 
	 * @param myPos is the first position is x-y system
	 * @param myType is the type of the object
	 */
	public Food_Drink( Position myPos, Food_Drinks_Type myType )
	{
		this.myPos = myPos;
		this.myType = myType;
		setMySpeed(this.myType);
		setBloodAlcoholRatio(this.myType);
		setMySize(this.myType);
		setMyScore(this.myType);
		setSpcial(this.myType);
	}
	
	/************************ Other methods ***********************************/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Food_Drink [myPos=" + myPos + ", myType=" + myType + ", mySpeed=" + mySpeed + ", mySize=" + mySize
				+ ", myScore=" + myScore + ", bloodAlcoholRatio=" + bloodAlcoholRatio + ", spcial=" + special + "]";
	}
	/**
	 * Calculate the new position of the object depended on its speed and 
	 * the elapsed time parameter.
	 *
	 * @param elapsedTime the dynamic time stamp to calculate object position 
	 */
	public void CalcNewPos( int elapsedTime ) {
		//FIXME MAGIC!!!
//		double newY = myPos.y+this.mySpeed*elapsedTime*0.01;
		double newY = Math.pow(this.mySpeed,this.timeInGame*0.001);
		
		myPos.y=myPos.y+newY; 
	}
	
	/**
	 * This function generates the new type of an object. We use a gaussian pszeudo 
	 * random number to determine the type of the object. The low value objects are closer to the
	 * mean value and the higher value objects are far from the mean value.
	 * 
	 */
	public Food_Drinks_Type RandomType( )
	{
		Random rand = new Random();
		Food_Drinks_Type newType = Food_Drinks_Type.eGlassOfBeer;
		
		double seed = rand.nextGaussian();
//		System.out.println("seed:" + seed + ",SeedAbs: "+ seed_abs);
		
		
		if(seed >0)
		{
			seed = Math.abs(seed);
			// Generate some alkohol
			if(seed < 0.2)
				newType = Food_Drinks_Type.eGlassOfBeer;
			else if(seed >=0.2 && seed < 0.35)
				newType = Food_Drinks_Type.ePintOfBeer;
			else if(seed >= 0.35 && seed < 0.5 )
				newType = Food_Drinks_Type.eGlassOfVine;
			else if(seed >= 0.5 && seed < 0.75)
				newType = Food_Drinks_Type.eCoctail;
			else if(seed >= 0.75 && seed < 1.2)
				newType = Food_Drinks_Type.eSmallSpirit;
			else if(seed >= 1.2 && seed < 2)
				newType = Food_Drinks_Type.eLongSpirit;
			else if( seed >= 2 )
				newType = Food_Drinks_Type.ePartyTray;
		}
		else
		{
			seed = Math.abs(seed);
			// Generate some food
			if(seed < 0.2)
				newType = Food_Drinks_Type.eHFullofSunfSeed;
			else if(seed >=0.2 && seed < 0.35)
				newType = Food_Drinks_Type.eHFullofPeanuts;
			else if(seed >= 0.35 && seed < 0.5 )
				newType = Food_Drinks_Type.eSliceofPizza;
			else if(seed >= 0.5 && seed < 0.75)
				newType = Food_Drinks_Type.eFattyBoard;
			else if(seed >= 0.75 && seed < 1.2)
				newType = Food_Drinks_Type.eGyros;
			else if(seed >= 1.2 && seed < 2)
				newType = Food_Drinks_Type.eHamburger;
			else if( seed >= 2 )
				newType = Food_Drinks_Type.ePartyTray;

		}
		
		// U have to use some intervvals to determine the different objects
		
		
		return newType;
	}
	
	
	
}
