/**
 * 
 */
package control;

import gui.Gui;

/**
 * This calss has to schedule the whole game.
 * 
 * @author chaah
 *
 */
public class GameTimer implements Runnable{
	/**
	 * Flag that indicates the current state of the game timer.
	 */
	boolean isRunning;
	
	private Control c;
	private Gui g;
	
	/**
	 * Starts the Game timer.
	 * 
	 * @param c Reference to the Control class
	 * @param g reference to the gui class
	 */
	public GameTimer(Control c, Gui g) {
		isRunning=true;
		this.c=c;
		this.g=g;
	}


	@Override
	public void run() {
		try{
			while(true==isRunning)
			{
				// Here comes the control actualize function
				isRunning=c.RefreshData();
				if(isRunning)
				{
					g.repaint();
				}
				Thread.sleep(c.TIME_SAMPLE);
				
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
