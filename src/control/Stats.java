/**
 * 
 */
package control;

/**
 * This class contains every usefull information to store the different games
 * 
 * @author chaah
 *
 */
public class Stats {
	/**
	 * Score of the actual game
	 */
	public int score;
	
	/**
	 * Player name, which played this game
	 */
	public String name;
	
	/**
	 * achieved maximum boold alkhol level during the gameplay
	 */
	public double bloodAlcoholLevel;
	
	/**
	 * length of the game in time.
	 */
	public int duration;
	
	Stats()
	{
		this.name="CunciSquirel";
		this.bloodAlcoholLevel=1;
		this.duration=0;
	}
}
