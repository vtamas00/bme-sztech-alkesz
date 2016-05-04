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
	
	private Control C;
	
	
	/**
	 * @param locTimer
	 */
	public GameTimer(Control C) {
		isRunning=true;
		this.C=C;
	}


	@Override
	public void run() {
		try{
			while(true==isRunning)
			{
				// Here comes the control actualize function
				isRunning=C.RefreshData();
				Thread.sleep(20);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
