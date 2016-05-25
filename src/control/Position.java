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
	
	public static final double screenHeight = 600;	/* in pixels */
	public static final double screenWidth = 450;	/* in pixels */
	
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
	 * @param playerPos position to compare
	 * @param compareValue possible values: [0,1]
	 * @param areaFactor determines the area around the positions
	 * @return true if the the 2 position has matching radius
	 */
	public Boolean isPosAequalsPosB(Position posA, Position playerPos, double compareValue, int areaFactor) {
		Boolean bReturn=false;
		Player dummyPLayer = new Player("def");
		double factor = areaFactor;
		double aLow[] = {posA.x-factor, posA.y+factor};
		double aHigh[] = {posA.x+factor, posA.y+factor};
		double playerLow[] = {playerPos.x-dummyPLayer.sizeX/2, playerPos.y+dummyPLayer.sizeY/2};
		double plyaerHigh[] = {playerPos.x+dummyPLayer.sizeX/2, playerPos.y+dummyPLayer.sizeY/2};
		
		System.out.println("aLow[0]" + aLow[0] + ",aLow[1]" + aLow[1] +", aHigh[0]" + aHigh[0] +", aHigh[1]" + aHigh[1]);
		System.out.println("playerLow[0]" + playerLow[0] + ",playerLow[1]" + playerLow[1] +", plyaerHigh[0]" + plyaerHigh[0] +", plyaerHigh[1]" + plyaerHigh[1]+"...");
		
		// Check the interval overlap
		if( playerLow[1] < aHigh[1] )
		{
			// The object lower part is reached the player central position.
			if( (aLow[0] <= plyaerHigh[0]) && (playerLow[0] <= aHigh[0]) )
			{
				// The x coordinate is overlap
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

