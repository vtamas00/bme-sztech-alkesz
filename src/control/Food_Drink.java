/**
 * 
 */
package control;


/**
 * @author Dani
 *
 */
public class Food_Drink {

	public enum Food_Drinks_Type{
		eGlassOfBeer, ePintOfBeer, eGlassOfVine, eCoctail,
		eSmallSpirit, eLongSpirit, eHFullofSunfSeed, eHFullofPeanuts,
		eSliceofPizza, eFattyBoard, eGyros, eHamburger, ePartyTray
	}
	
	private Position myPos;		/* Position of the object */
	private Food_Drinks_Type myType;	/* Object type */
	private int mySpeed;		/* [Pixel/ms] */
	private int mySize;			/* Round shape objects, this is the radius [pixels] */
	private int myScore;		/* Value of the object */
	private int bloodAlcoholRatio; 
	private int special;
	
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
	 * @param myType determines the speed of the object
	 */
	private void setMySpeed(Food_Drinks_Type myType) {
		switch(myType)
		{
			case ePartyTray:
			{
				this.mySpeed = 1;
				break;
			}
			case eGlassOfBeer:
			{
				this.mySpeed = 1;
				break;
			}
			case ePintOfBeer:
			{
				this.mySpeed = 1;
				break;
			}
			case eGlassOfVine:
			{
				this.mySpeed = 1;
				break;
			}
			case eCoctail:
			{
				this.mySpeed = 1;
				break;
			}
			case eSmallSpirit:
			{
				this.mySpeed = 1;
				break;
			}
			case eLongSpirit:
			{
				this.mySpeed = 1;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.mySpeed = 1;
				break;
			}
			case eHFullofPeanuts:
			{
				this.mySpeed = 1;
				break;
			}
			case eFattyBoard:
			{
				this.mySpeed = 1;
				break;
			}
			case eSliceofPizza:
			{
				this.mySpeed = 1;
				break;
			}
			case eGyros:
			{
				this.mySpeed = 1;
				break;
			}
			case eHamburger:
			{
				this.mySpeed = 1;
				break;
			}
			default:
			{
				this.mySpeed = 1;
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
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eGlassOfBeer:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case ePintOfBeer:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eGlassOfVine:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eCoctail:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eSmallSpirit:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eLongSpirit:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eHFullofPeanuts:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eFattyBoard:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eSliceofPizza:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eGyros:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			case eHamburger:
			{
				this.bloodAlcoholRatio = 1;
				break;
			}
			default:
			{
				this.bloodAlcoholRatio = 1;
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
				this.mySize = 1;
				break;
			}
			case eGlassOfBeer:
			{
				this.mySize = 1;
				break;
			}
			case ePintOfBeer:
			{
				this.mySize = 1;
				break;
			}
			case eGlassOfVine:
			{
				this.mySize = 1;
				break;
			}
			case eCoctail:
			{
				this.mySize = 1;
				break;
			}
			case eSmallSpirit:
			{
				this.mySize = 1;
				break;
			}
			case eLongSpirit:
			{
				this.mySize = 1;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.mySize = 1;
				break;
			}
			case eHFullofPeanuts:
			{
				this.mySize = 1;
				break;
			}
			case eFattyBoard:
			{
				this.mySize = 1;
				break;
			}
			case eSliceofPizza:
			{
				this.mySize = 1;
				break;
			}
			case eGyros:
			{
				this.mySize = 1;
				break;
			}
			case eHamburger:
			{
				this.mySize = 1;
				break;
			}
			default:
			{
				this.mySize = 1;
				break;
			}
		} // switch
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
				this.myScore = 1;
				break;
			}
			case eGlassOfBeer:
			{
				this.myScore = 1;
				break;
			}
			case ePintOfBeer:
			{
				this.myScore = 1;
				break;
			}
			case eGlassOfVine:
			{
				this.myScore = 1;
				break;
			}
			case eCoctail:
			{
				this.myScore = 1;
				break;
			}
			case eSmallSpirit:
			{
				this.myScore = 1;
				break;
			}
			case eLongSpirit:
			{
				this.myScore = 1;
				break;
			}
			case eHFullofSunfSeed:
			{
				this.myScore = 1;
				break;
			}
			case eHFullofPeanuts:
			{
				this.myScore = 1;
				break;
			}
			case eFattyBoard:
			{
				this.myScore = 1;
				break;
			}
			case eSliceofPizza:
			{
				this.myScore = 1;
				break;
			}
			case eGyros:
			{
				this.myScore = 1;
				break;
			}
			case eHamburger:
			{
				this.myScore = 1;
				break;
			}
			default:
			{
				this.myScore = 1;
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
	 * @param myType is the type of the current objectum
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
	public Food_Drink( int x0, int y0, Food_Drinks_Type myType)
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
	 * 
	 * @param elapsedTime the dynamic time stamp to calculate object position 
	 */
	public void CalcNewPos( int elapsedTime ) {
		double newY = myPos.y+this.mySpeed*elapsedTime;
		myPos.y=newY; 
	}
	
	
	
}
