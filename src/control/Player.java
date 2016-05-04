/**
 * 
 */
package control;


/**
 * The player represents the object, which has to catch the different falling 
 * object. This object is controlled by the human player.
 *  
 * @author Dani
 */
public class Player {
	
	private Position myLastPos;		/* Holds the last position of the player */
	private Position myPos;		/* Holds the current position of the player */
	public Position NewPos;	/* Set by the GUI */
	private int myBloodAlcoholRatio;	
	private int myScore;		
	private int myHealh;		/* Maximum number of missed objects */
	public String myName;
	
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
	 * @param NewPos is set based on derivation of the movement of the 
	 * player, and the players own blood alcohol ratio.
	 * 
	 * The used method is based on the following equation:
	 * x = x + c*(sqrt(dx0^2+dx1^2))
	 */
	public void setMyPos(Position NewPos) {
		double dx0;	/* Derivative of the last 2 position */
		double dx1;	/* Derivative of the new and old position */
		
		// calculate the derivative
		dx0=this.myPos.x-this.myLastPos.x;
		dx1=NewPos.x-this.myPos.x;
		setMyLastPos(this.myPos); /* Set the current pos to last pos */
		this.myPos = NewPos;

		this.myPos.x+=(int)(this.myBloodAlcoholRatio*Math.sqrt(Math.pow(dx0,2)+Math.pow(dx1,2)));
	}
	/**
	 * @return the myBloodAlcoholRatio
	 */
	public int getMyBloodAlcoholRatio() {
		return myBloodAlcoholRatio;
	}
	/**
	 * @param bloodAlcoholRatio will increase myBloodAlcoholRatio
	 */
	public void setMyBloodAlcoholRatio(int bloodAlcoholRatio) {
		this.myBloodAlcoholRatio += bloodAlcoholRatio;
	}
	/**
	 * @return the myScore
	 */
	public int getMyScore() {
		return myScore;
	}
	/**
	 * @param extraScore will increase myScore
	 */
	public void setMyScore(int extraScore) {
		this.myScore += extraScore;
	}
	
	/**
	 * @return the myHealh
	 */
	public int getMyHealh() {
		return myHealh;
	}
	/**
	 * @param myHealh the myHealh to set
	 */
	private void setMyHealh( ) {
		this.myHealh = 10;	/* Default value, change here if needed! */
	}
	/************************* Constructors ***********************************/
	
	public Player( String myName) {
		this.myLastPos = new Position();
		this.myPos = new Position();
		this.myScore = 0;
		this.myBloodAlcoholRatio = 0;
		this.myName = myName;
		setMyLastPos(new Position());
		setMyPos(new Position());
		setMyHealh( );
	}
	
	
	public Player(Position newPos, String myName) {
		this.myLastPos = newPos;
		this.myPos = newPos;
		this.myScore = 0;
		this.myBloodAlcoholRatio = 0;
		this.myName = myName;
		setMyLastPos(newPos);
		setMyPos(newPos);
		setMyHealh( );
	}
	
	/*********************** Common methods ***********************************/
	
	/**
	 * Decrease the health parameter of the object
	 */
	public void decreaseHealth() {
		this.myHealh = this.myHealh - 1;
		if( 0 == this.myHealh )
		{
			// You are dead!
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [myLastPos=" + myLastPos + ", myPos=" + myPos + ", myBloodAlcoholRatio=" + myBloodAlcoholRatio
				+ ", myScore=" + myScore + ", myHealh=" + myHealh + "]";
	}


}
