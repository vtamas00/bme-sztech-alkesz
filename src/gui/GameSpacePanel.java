package gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import control.Control;
import control.Food_Drink;
import control.Food_Drink.Food_Drinks_Type;
import control.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * This class is responsible for the game space.
 */

public class GameSpacePanel extends JPanel implements MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameState g;
	private Control c;
	private boolean ShowGS;
	
	// The images will load to this objects
	private BufferedImage pia1,pia2,pia3,pia4,pia5,kv,udito;
	private BufferedImage kaja1,kaja2,kaja3,kaja4,kaja5,hamb;

	private URL resource;

	
	public GameSpacePanel() {
		this.addMouseMotionListener(this);
		
		loadAllImages();
			}
	
	/**
	 * Load all Image when the game is starting.
	 */	
	private void loadAllImages() {

		try {
        
        	resource = getClass().getResource("images/pia1.png");
        	pia1 = ImageIO.read(resource);

        	resource = getClass().getResource("images/pia2.png");
        	pia2 = ImageIO.read(resource);

        	resource = getClass().getResource("images/pia3.png");
        	pia3 = ImageIO.read(resource);
        	
        	resource = getClass().getResource("images/pia4.png");
        	pia4 = ImageIO.read(resource);
        
        	resource = getClass().getResource("images/pia5.png");
        	pia5 = ImageIO.read(resource);

        	resource = getClass().getResource("images/kv.png");
        	kv = ImageIO.read(resource);

        	resource = getClass().getResource("images/udito.png");
        	udito = ImageIO.read(resource);

        	resource = getClass().getResource("images/kaja1.png");
        	kaja1 = ImageIO.read(resource);
        	
        	resource = getClass().getResource("images/kaja2.png");
        	kaja2 = ImageIO.read(resource);
        	
        	resource = getClass().getResource("images/kaja3.png");
        	kaja3 = ImageIO.read(resource);
        	
        	resource = getClass().getResource("images/kaja4.png");
        	kaja4 = ImageIO.read(resource);
        	
        	resource = getClass().getResource("images/kaja5.png");
        	kaja5 = ImageIO.read(resource);
        	
        	resource = getClass().getResource("images/hamb.png");
        	hamb = ImageIO.read(resource);
        	

        } catch (IOException e) {
            e.printStackTrace();
        }
		
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
		//super.paintComponent(g2d);
		
		BufferedImage background, foreground, output;
		foreground = new BufferedImage((int)g.Plato.myPos.GetScreenWidth(),(int)g.Plato.myPos.GetScreenHeight()+60,BufferedImage.TYPE_INT_ARGB);
		output = new BufferedImage((int)g.Plato.myPos.GetScreenWidth(),(int)g.Plato.myPos.GetScreenHeight()+60,BufferedImage.TYPE_INT_ARGB);
	    Graphics2D canvas = output.createGraphics();
	    Graphics2D overlay = foreground.createGraphics();
	    
		
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
		
		// Draw white background
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, (int)g.Plato.myPos.GetScreenWidth(), (int)g.Plato.myPos.GetScreenHeight()+60);
		
		g2d.setColor(Color.black);
		g2d.setFont(f);
		
		// Print time
		g2d.drawString(zero_min + time_min + ":" + zero_sec + time_sec, X, Y);
		// Print bloodpercent
		g2d.drawString(""+g.Plato.getMyHealh(), (int)(g.Plato.myPos.GetScreenWidth()*0.35), Y);
		// Print bloodpercent
		g2d.drawString(g.Plato.getMyBloodAlcoholRatio()+"%", (int)(g.Plato.myPos.GetScreenWidth()*0.65), Y);
		// Print experience point
		g2d.drawString(g.Plato.getMyScore()+"xp", (int) (g.Plato.myPos.GetScreenWidth()-70), Y);

		// Draw falling objects
		
		for (Food_Drink item : g.FallingObjects ) {
			// g2d.fillOval((int)item.myPos.x-item.mySize/2, (int)item.myPos.y-item.mySize/2, item.mySize, item.mySize);
			overlay.drawImage(imageOfFoodDring(item.getMyType()), (int)item.myPos.x-item.mySize/2, (int)item.myPos.y-item.mySize/2, item.mySize, item.mySize, this);
		}

		
		// Draw plato
		overlay.setColor(Color.black);
		overlay.fillRect((int)g.Plato.getMyPos().x, (int)g.Plato.getMyPos().y, g.Plato.sizeX, g.Plato.sizeY);
		
		//System.out.println("X=" + g.Plato.getMyPos().x + " Y=" + g.Plato.getMyPos().y + " SizeX=" + g.Plato.sizeX + " SizeY=" + g.Plato.sizeY);
		//System.out.println("NewPosX=" + g.Plato.NewPos.x  + " NoewPosY=" + g.Plato.NewPos.y);
		
		
		// Draw cover
		overlay.setColor(Color.white);
		overlay.fillRect(0, 0, (int)g.Plato.myPos.GetScreenWidth(), 0);	

		
		
		canvas.drawImage(foreground, 0, 60, null);
	    overlay.dispose();
	    canvas.dispose();
	    g2d.drawImage(output, 0, 0, null);
	}
	
	private BufferedImage imageOfFoodDring(Food_Drinks_Type myType) {
		BufferedImage fallingImage;

		switch (myType) {
		
		default: 
			fallingImage = pia1;
			System.out.println("FoodDring image choose error. [GUI - GameSpacePanel]");
			break;
		
		case eGlassOfBeer:
			fallingImage = pia1;
			break;
		
		case ePintOfBeer:
			fallingImage = pia2;
			break;

		case eGlassOfVine:
			fallingImage = pia3;
			break;

		case eCoctail:
			fallingImage = pia4;
			break;

		case eSmallSpirit:
			fallingImage = pia5;
			break;

		case eLongSpirit:
			fallingImage = udito;
			break;

		case eHFullofSunfSeed:
			fallingImage = kaja1;
			break;

		case eHFullofPeanuts:
			fallingImage = kaja2;
			break;

		case eSliceofPizza:
			fallingImage = kaja3;
			break;

		case eFattyBoard:
			fallingImage = kaja4;
			break;

		case eGyros:
			fallingImage = kaja5;
			break;

		case eHamburger:
			fallingImage = hamb;
			break;

		case ePartyTray:
			fallingImage = kaja5;
			break;

		}
		
		
		return fallingImage;
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
