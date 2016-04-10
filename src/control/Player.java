/**
 * 
 */
package control;


/**
 * @author Dani
 * 
 * The player represents the object, which has to catch the different falling 
 * object. This object is controlled by the human player. 
 *
 */
public class Player {
	
	private Position myLastPos;		/* Holds the last position of the player */
	private Position myPos;		/* Holds the current position of the player */
	private int myBloodAlcoholRatio;	
	private int myScore;
	
	/**
	 * @param myLastPos the myLastPos to set
	 */
	private void setMyLastPos(Position myCurrentPos) {
		this.myLastPos = myCurrentPos;
	}
	/**
	 * @return the myPosition
	 */
	public Position getMyPos() {
		return myPos;
	}
	/**
	 * @param myPos is set based on derivation of the movement of the 
	 * player, and the players own blood alcohol ratio.
	 * 
	 * The used method is based on the following equation:
	 * x = x + c*(sqrt(dx0^2+dx1^2))
	 */
	public void setMyPos(Position NewPos) {
		int dx0;	/* Derivative of the last 2 position */
		int dx1;	/* Derivative of the new and old position */
		
		// calculate the derivative
		dx0=this.myPos.x-this.myLastPos.x;
		dx1=NewPos.x-this.myPos.x;
		setMyLastPos(this.myPos); /* Set the current pos to last pos */
		this.myPos = NewPos;

		this.myPos.x+=(int)( this.myBloodAlcoholRatio*Math.sqrt(Math.pow(dx0,2)+Math.pow(dx1,2)));
	}
	/**
	 * @return the myBloodAlcoholRatio
	 */
	public int getMyBloodAlcoholRatio() {
		return myBloodAlcoholRatio;
	}
	/**
	 * @param myBloodAlcoholRatio the myBloodAlcoholRatio to set
	 */
	public void setMyBloodAlcoholRatio(int myBloodAlcoholRatio) {
		this.myBloodAlcoholRatio = myBloodAlcoholRatio;
	}
	/**
	 * @return the myScore
	 */
	public int getMyScore() {
		return myScore;
	}
	/**
	 * @param myScore the myScore to set
	 */
	public void setMyScore(int myScore) {
		this.myScore = myScore;
	}
	
	/************************* Constructors ***********************************/
	
	public Player(Position newPos) {
		setMyLastPos(newPos);
		setMyBloodAlcoholRatio(0);
		setMyPos(newPos);
		setMyScore(0);
	}
	
}
