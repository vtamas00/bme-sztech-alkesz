package gui;

import javax.swing.JPanel;

import control.GameState;

import java.awt.Graphics;

public class GameSpacePanel extends JPanel {

	private GameState g;
	private boolean ShowGS;

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

		if (ShowGS == true) {
			System.out.println("Print GameState.");
			g2d.drawString("GameSate", X, Y);
			Y += GAP;
			g2d.drawString("UserName : " + this.g.Plato.myName, X, Y);
			Y += GAP;
			g2d.drawString("Debug Counter : " + this.g.gebugCntr, X, Y);
		}

		// g2d.drawString("OBJECT", 40, 20);
		// g2d.drawRect(100, 100, 100, 100);

	}

}
