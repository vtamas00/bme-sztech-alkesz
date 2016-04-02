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
	
	private Position myPos;
	private Food_Drinks_Type myType;
	private int mySpeed;
	
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
	 * Default constructor
	 */
	public Food_Drink()
	{
		this.myPos = new Position();
		this.myType = Food_Drinks_Type.ePartyTray;
		setMySpeed(this.myType);
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
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Food_Drink [myPos=" + myPos + ", myType=" + myType + ", mySpeed=" + mySpeed + "]";
	}
	
	
}
