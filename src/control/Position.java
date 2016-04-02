/**
 * 
 */
package control;

/**
 * @author Dani
 *
 */
public class Position {
	public int x;
	public int y;
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param newX the x to set
	 */
	public void setX(int newX) {
		this.x = newX;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param newY the y to set
	 */
	public void setY(int newY) {
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
	public Position( int newX, int newY) {
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
	
	
}
