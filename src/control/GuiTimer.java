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
				
				this.g.ReDrawAll();
				
				Thread.sleep(20);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
