package gui;

import javax.swing.JPanel;

import control.Control;
import control.Food_Drink;
import control.GameState;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GameSpacePanel extends JPanel implements MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameState g;
	private Control c;
	private boolean ShowGS;
	
	public GameSpacePanel() {
		this.addMouseMotionListener(this);
	}
	
	
	public void setGameState(GameState gs) {
		g = gs;
	}

	public void setControl(Control co) {
		c = co;
	}
	
	public void setShowGS(boolean b) {
		this.ShowGS = b;
	}

	public boolean getShowGS() {
		return this.ShowGS;
	}

	@Override
	public void paintComponent(Graphics g2d) {
		super.paintComponent(g2d);

		final int X = 15;
		int Y = 50;
		final int GAP = 15;
		Font f = new Font("Verdana", Font.BOLD, 13);
		Font l = new Font("Verdana", Font.PLAIN, 8);
		long time_sec;
		long time_min;
		
		String zero_min = "0";
		String zero_sec = "0";
		
		time_min = (this.g.gebugCntr/50) / 60;
		time_sec = (this.g.gebugCntr/50) % 60;
		
		if (time_min < 10) {
			zero_min = "0";
		} else {
			zero_min = "";
		}
		
		if (time_sec < 10) {
			zero_sec = "0";
		} else {
			zero_sec = ""; 	
		}
		
		g2d.setFont(f);
		
		// Print time
		g2d.drawString(zero_min + time_min + ":" + zero_sec + time_sec, X, Y);
		// Print bloodpercent
		g2d.drawString(""+g.Plato.getMyHealh(), (int)(g.Plato.myPos.GetScreenWidth()*0.35), Y);
		// Print bloodpercent
		g2d.drawString(g.Plato.getMyBloodAlcoholRatio()+"%", (int)(g.Plato.myPos.GetScreenWidth()*0.65), Y);
		// Print experience point
		g2d.drawString(g.Plato.getMyScore()+"xp", (int) (g.Plato.myPos.GetScreenWidth()-70), Y);
		
		
		// Draw plato
		//g2d.fillRect((int)g.Plato.NewPos.x, (int)g.Plato.NewPos.y, g.Settings.PlatoSizeX, g.Settings.PlatoSizeY);
		g2d.fillRect((int)g.Plato.getMyPos().x, (int)g.Plato.getMyPos().y, g.Plato.sizeX, g.Plato.sizeY);
		
		//System.out.println("X=" + g.Plato.getMyPos().x + " Y=" + g.Plato.getMyPos().y + " SizeX=" + g.Plato.sizeX + " SizeY=" + g.Plato.sizeY);
		//System.out.println("NewPosX=" + g.Plato.NewPos.x  + " NoewPosY=" + g.Plato.NewPos.y);
		
		if (ShowGS == true) {
			Y += GAP;
			g2d.drawString("GameSate", X, Y);
			Y += GAP;
			g2d.drawString("UserName : " + this.g.Plato.myName, X, Y);
			Y += GAP;
			g2d.drawString("Fallingobjects : " + this.g.FallingObjects.size(), X, Y);

		}
		
		// Draw falling objects
		
		for (Food_Drink item : g.FallingObjects ) {
			g2d.fillOval((int)item.myPos.x-item.mySize/2, (int)item.myPos.y-item.mySize/2, item.mySize, item.mySize);
		}


	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		g.NPos((double)evt.getPoint().x);
		c.HandleUserEvent();				
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		// System.out.println(evt.getPoint().x + ", " + evt.getPoint().y);
		g.NPos((double)evt.getPoint().x);
		c.HandleUserEvent();
	}

}
