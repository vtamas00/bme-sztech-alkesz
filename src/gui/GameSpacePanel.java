package gui;

import javax.swing.JPanel;

import control.GameState;

import java.awt.Graphics;

public class GameSpacePanel extends JPanel {
	
		private GameState g;
		private Graphics g2d;
		
		public void setGameState(GameState gs) {
			g = gs;
		}
	
	   @Override
	    public void paintComponent(Graphics rg2d) {
	        super.paintComponent(rg2d);
	        
	        this.g2d = rg2d;
	        System.out.println("Init g2d.");
	        
	        //g2d.drawString("OBJECT", 40, 20);
	        //g2d.drawRect(100, 100, 100, 100);

	    }
	   
	   public void printGameState(GameState g) {
		   
		   final int X = 15;
		   int Y = 20;
		   final int GAP = 15;
		   
		   System.out.println("Print GameState.");
		   this.g2d.drawString( "GameSate" , X , Y);
		   Y += GAP;
		   
	   }
}
