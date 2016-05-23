/**
 * 
 */
package control;

/**
 * This class represents a normal position of an object in X,Y coordinate 
 * system. The position will indicates the geometric center of the object.
 * 
 * @author Dani
 *
 */
public class Position {
	
	public static final double screenHeight = 700;	/* in pixels */
	public static final double screenWidth = 550;	/* in pixels */
	
	public double x;
	public double y;
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param newX the x to set
	 */
	public void setX(double newX) {
		this.x = newX;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param newY the y to set
	 */
	public void setY(double newY) {
		this.y = newY;
	}

	
	
	/**
	 * Default constructor
	 */
	public Position() {
		setX(0);
		setY(0);
	}
	
	/**
	 * 
	 * @param newX the x to set
	 * @param newY the y to set
	 */
	public Position( double newX, double newY) {
		setX(newX);
		setY(newY);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	/**
	 * This function compare two positions to each other. Generates a square 
	 * around each position determined by compare value. If the two square has
	 * common area they are "equal".
	 * 
	 * @param posA position to compare
	 * @param posB position to compare
	 * @param compareValue possible values: [0,1]
	 * @param areaFactor determines the area around the positions
	 * @return true if the the 2 position has matching radius
	 */
	public Boolean isPosAequalsPosB(Position posA, Position posB, double compareValue, int areaFactor) {
		Boolean bReturn=false;
//		double factor = areaFactor*(1-compareValue);
//		double factor = Math.pow(1.5,areaFactor)*compareValue;
		double factor = areaFactor;
		double aLow[] = {posA.x-factor, posA.y-factor};
		double aHigh[] = {posA.x+factor, posA.y+factor};
		double bLow[] = {posB.x-factor, posB.y-factor};
		double bHigh[] = {posB.x+factor, posB.y+factor};
		
		// Check the interval overlap
		if( (aLow[0] >= bHigh[0]) && (aHigh[0] >= bLow[0]) )
		{
			// The x coordinate is overlap
			if( (aLow[1] >= bHigh[1]) && (aHigh[1] >= bLow[1]) )
			{
				// The y coordinate is overlap
				bReturn=true;
			}
		}
		return bReturn;
	}
	
	/**
	 * returns the value of the screen height
	 * 
	 * @return The Heigth of the screen
	 */
	public double GetScreenHeight()
	{
		return Position.screenHeight;
	}
	
	/**
	 * returns the value of the screen width
	 * @return the width of the screen
	 */
	public double GetScreenWidth()
	{
		return Position.screenWidth;
	}
}

