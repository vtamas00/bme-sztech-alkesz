package gui;

import javax.swing.JPanel;

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
	private boolean ShowGS;
	
	public GameSpacePanel() {
		this.addMouseMotionListener(this);
	}
	
	
	public void setGameState(GameState gs) {
		g = gs;
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
		g2d.drawString(""+g.Plato.getMyHealh(), (int)(g.Settings.SizeX*0.35), Y);
		// Print bloodpercent
		g2d.drawString(g.Plato.getMyBloodAlcoholRatio()+"%", (int)(g.Settings.SizeX*0.65), Y);
		// Print experience point
		g2d.drawString(g.Plato.getMyScore()+"xp", g.Settings.SizeX-70, Y);
		
		
		// Draw plato
		g2d.fillRect((int)g.Plato.NewPos.x, (int)g.Plato.NewPos.y, g.Settings.PlatoSizeX, g.Settings.PlatoSizeY);
		
		if (ShowGS == true) {
			Y += GAP;
			g2d.drawString("GameSate", X, Y);
			Y += GAP;
			g2d.drawString("UserName : " + this.g.Plato.myName, X, Y);
			Y += GAP;
		}
		
		
		
		
		
		

		// g2d.drawString("OBJECT", 40, 20);
		// g2d.drawRect(100, 100, 100, 100);

	}

	@Override
	public void mouseDragged(MouseEvent evt) {
				
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		//System.out.println(evt.getPoint().x + ", " + evt.getPoint().y);
		g.NPos((double)evt.getPoint().x);
	}

}
