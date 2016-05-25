/**
 * 
 */
package control;

import gui.Gui;

/**
 * This class run the gui in its own thread.
 * 
 * @author chaah
 *
 */
public class GuiTimer implements Runnable {
	/**
	 * flag that indicates the current state of the gui.
	 */
	boolean isRunning;	
	private Gui g;

	GuiTimer(Gui g)
	{
		this.g=g;
		this.isRunning=true;
	}
	
	@Override
	public void run() {
		try{
			while(isRunning==true)
			{
				
				//this.g.ReDrawAll();
				
				Thread.sleep(20);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
