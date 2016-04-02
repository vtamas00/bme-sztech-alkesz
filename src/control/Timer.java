/**
 * 
 */
package control;

/**
 * @author Dani
 * 
 * This module provide global synchronization for the control system 
 * of the project.
 *
 */
public class Timer {
	private long lTime;
	
	public Timer( ) {
		setlTime( );
	}

	/**
	 * @return the lTime
	 */
	public long getlTime() {
		return lTime;
	}

	/**
	 * @param lTime sets by System.currentTimeMillis()
	 */
	public void setlTime( ) {
		this.lTime = System.currentTimeMillis();
	}
}
