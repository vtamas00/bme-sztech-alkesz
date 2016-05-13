/**
 * 
 */
package control;

import java.util.Timer;

/**
 * This calss has to schedule the whole game
 * 
 * @author chaah
 *
 */
public class GameTimer implements Runnable{
	boolean isRunning;
	
	private Control c;
	
	
	/**
	 * @param locTimer
	 */
	public GameTimer(Control c) {
		isRunning=true;
		this.c=c;
	}


	@Override
	public void run() {
		try{
			while(true==isRunning)
			{
				// Here comes the control actualize function
				isRunning=c.RefreshData();
				Thread.sleep(c.TIME_SAMPLE);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
