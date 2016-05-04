/**
 * 
 */
package control;

import gui.Gui;

/**
 * @author chaah
 *
 */
public class GuiTimer implements Runnable {
	boolean isRunning;
	private Gui g;

	GuiTimer(Gui G)
	{
		this.g=G;
		this.isRunning=true;
	}
	
	@Override
	public void run() {
		try{
			while(isRunning==true)
			{
				// Here comes the control actualize function
				Thread.sleep(20);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
