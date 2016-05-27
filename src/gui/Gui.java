package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.Control;
import control.GameState;
import control.GameState.Game_Difficulty;
import control.GameState.Game_Type;
import control.Stats;

	/**
	 * Implements the main window. 
	 * 
	 * @author vtamas
	 * 
	 */
public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Define the grid size for the grid layout.
	 * 
	 * @author vtamas
	 *
	 */	
	Dimension gridSize = new Dimension(300, 90);
	
	
	/**
	 * Labels on the Main Menu
	 * 
	 * @author vtamas
	 *
	 */	

	JLabel bWelcome = new JLabel("Main menu");
	JLabel bUserName = new JLabel();
	
	
	/**
	 * Buttons on the Main menu
	 * 
	 * @author vtamas
	 *
	 */	

	
	
	JButton bSinglePlayer = new JButton("Single Player");
	JButton bMultiPlayer = new JButton("Multi Player");
	JButton bSettings = new JButton("Settings");
	JButton bStatistics = new JButton("Statistics");
	JButton bChangeUser = new JButton("Change user");

	/**
	 * Buttons on the Game Panel
	 * 
	 * @author vtamas
	 *
	 */	

	
	JButton sw2 = new JButton("Main menu");
	JButton sw3 = new JButton("Main menu");
	JButton sw4 = new JButton("Pasue");
	JButton sw5 = new JButton("Reset");

	/**
	 * ContainerPanel is the active panel, what the user can see
	 * 
	 * GUI Panels for the gamespace and menus.
	 * 
	 * @author vtamas
	 *
	 */	

	
	JPanel ContainerPanel = new JPanel();
	JPanel MainMenuPanel = new JPanel();
	GameSpacePanel SingleGamePanel = new GameSpacePanel();
	GameSpacePanel MultiGamePanel = new GameSpacePanel();
	
	/**
	 * Local reference to the global GameState and Control class.
	 * 
	 * @author vtamas
	 *
	 */	


	private GameState g;
	private Control c;

	/**
	 * The layout class for the container panel.
	 * 
	 * @author vtamas
	 *
	 */	
	
	final CardLayout MainLayout = new CardLayout();

	/**
	 * This function is called when the user click to the Change Username option on the Main menu.
	 * 
	 * @author vtamas
	 *
	 */	
	
	public void chageUserNameDialog() {
		g.Plato.myName = JOptionPane.showInputDialog(this,"What is your username?", "SadUser");
		bUserName.setText("Welcome " + g.Plato.myName + "!");
		this.repaint();
	}

	/**
	 * Constructor in the GUI class. Build the whole menu and the windows.
	 * 
	 * There are the action listener functions for the buttons on the main menu.
	 * 
	 *  @param gameState
	 *  			Reference to the global Gamestate object
	 *  
	 *  @param control
	 *  			Reference to the global Control instance
	 * 
	 * @author vtamas
	 *
	 */	
	

	public Gui(GameState gameState, Control control) {

		this.g = gameState;
		this.c = control;
		SingleGamePanel.setGameState(gameState);
		SingleGamePanel.setControl(control);

		MultiGamePanel.setGameState(gameState);
		MultiGamePanel.setControl(control);

		// setSize(400, 550);
		setTitle("BME MIT Sztech :: Alkesz");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		GridBagConstraints gbc = new GridBagConstraints();
		MainMenuPanel.setLayout(new GridBagLayout());

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(7, 7, 7, 7);
		
		g.Plato.myName = JOptionPane.showInputDialog(this,"What is your username?", "CunciSquirel");
		bUserName.setText("Welcome " + g.Plato.myName + "!");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		bWelcome.setPreferredSize(gridSize);
		bWelcome.setFont(new Font("Serif", Font.BOLD, 35));
		bWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		MainMenuPanel.add(bWelcome, gbc);
		bUserName.setBorder(new EmptyBorder(60,00,0,0));
		bUserName.setHorizontalAlignment(SwingConstants.CENTER);
		MainMenuPanel.add(bUserName, gbc);
		
		gbc.gridy = 1;
		bSinglePlayer.setPreferredSize(gridSize);
		MainMenuPanel.add(bSinglePlayer, gbc);
		gbc.gridy = 2;
		bMultiPlayer.setPreferredSize(gridSize);
		MainMenuPanel.add(bMultiPlayer, gbc);
		gbc.gridy = 3;
		bSettings.setPreferredSize(gridSize);
		MainMenuPanel.add(bSettings, gbc);
		gbc.gridy = 4;
		bStatistics.setPreferredSize(gridSize);
		MainMenuPanel.add(bStatistics, gbc);
		gbc.gridy = 5;
		bChangeUser.setPreferredSize(gridSize);
		MainMenuPanel.add(bChangeUser, gbc);

		SingleGamePanel.add(sw2);
		MultiGamePanel.add(sw3);

		ContainerPanel.setLayout(MainLayout);
		ContainerPanel.add(MainMenuPanel, "MMP");
		ContainerPanel.add(SingleGamePanel, "SGP");
		ContainerPanel.add(MultiGamePanel, "MGP");

		ContainerPanel.setPreferredSize(new Dimension((int)g.Plato.myPos.GetScreenWidth(), (int)g.Plato.myPos.GetScreenHeight()+60));

		MainLayout.show(ContainerPanel, "MMP");

		bSinglePlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainLayout.show(ContainerPanel, "SGP");
				g.eGameType = Game_Type.eSinglePlayer;
				c.resetGame();
				c.StartGame();
				
			}
		});
		
		/**
		 * Generate the modal pop up for the game level choice.
		 * 
		 * @author vtamas
		 *
		 */	
		

		bSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] possibilities = {"Easy", "Normal", "Hardcore","Insane"};
				int level = JOptionPane.showOptionDialog(null, "Please set the game level", "Settings",
				        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				        null, possibilities, possibilities[0]);
				switch(level) {
					case 0:
						g.eGameDiff = Game_Difficulty.eEasy;
						System.out.println("Level: Easy.");
						break;
					case 1:
						g.eGameDiff = Game_Difficulty.eNormal;
						System.out.println("Level: Normal.");
						break;
					case 2:
						g.eGameDiff = Game_Difficulty.eHard;
						System.out.println("Level: Hard.");
						break;
					case 3:
						g.eGameDiff = Game_Difficulty.eInsane;
						System.out.println("Level: Insane.");
						break;
					default:
						g.eGameDiff = Game_Difficulty.eEasy;
						break;
				}
			}
		});

		SingleGamePanel.add(sw4);
		SingleGamePanel.add(sw5);

		// MultiGamePanel.add(sw4);
		// MultiGamePanel.add(sw5);

		// Main menu button
		sw2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainLayout.show(ContainerPanel, "MMP");
				g.eGameType = Game_Type.eMenu;
				c.resetGame();
				c.Pause();

			}
		});

		// Pause button
		sw4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.Pause();
				// EndGameEvent();
			}

		});

		// Restart button
		sw5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.resetGame();
			}
		});
		
		bChangeUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chageUserNameDialog();
			}
		});
		
		bStatistics.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameStatsDisplay();
				MainLayout.show(ContainerPanel, "STAT");
				
			}
		});

				
		add(ContainerPanel);
		setLayout(MainLayout);
		pack();
		setVisible(true);

	}
	
	public void EndGameEvent() {
		this.MainLayout.show(ContainerPanel, "MMP");
		g.eGameType = Game_Type.eMenu;
		String infoMessage = "";
		c.Pause();
		
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
		
		infoMessage = "Congratulations! You are almost the best!\nYour score: " + g.Plato.getMyScore() + "\nGame time: "+zero_min + time_min + ":" + zero_sec + time_sec+"\nBlood percent: " + g.Plato.getMyBloodAlcoholRatio() + "%\nLevel: "+ g.eGameDiff;
		
		JOptionPane.showMessageDialog(this, infoMessage);
	}
	/**
	 * This function is called when the user click to the Statistics option on the Main menu.
	 * Generate the content for the statistics menu.
	 * 
	 * 
	 * The statistics panel consists dynamic data, has to refresh after every play.
	 * 
	 * @author vtamas
	 *
	 */	
	

	public void gameStatsDisplay() {
		
			JPanel statsPanel = new JPanel();
			ContainerPanel.add(statsPanel, "STAT");
			
			//statsPanel.setPreferredSize(new Dimension((int)(g.Plato.myPos.GetScreenWidth()*0.5),(int)(g.Plato.myPos.GetScreenHeight()*0.5)));
			
	        JButton bBackMainMenu = new JButton("Main menu");
	        bBackMainMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MainLayout.show(ContainerPanel, "MMP");					
				}
			});
	        
	        //statsPanel.setLayout(new BorderLayout());

	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Name");
	        model.addColumn("Score");
	        model.addColumn("Game duration");
	        model.addColumn("Blood alcohol ");
	        
	        JTable statTable = new JTable(model);
	        JScrollPane tableContainer = new JScrollPane(statTable);
	        
	        //statTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        tableContainer.setPreferredSize(new Dimension((int)(g.Plato.myPos.GetScreenWidth()*0.8),(int)(g.Plato.myPos.GetScreenHeight()*0.8)));
	        
	        statsPanel.add(bBackMainMenu);
	        statsPanel.add(tableContainer, BorderLayout.CENTER);
	        for ( Stats item : g.gameStats ){
	        	model.addRow(new Object[]{item.name,item.score ,item.duration ,item.bloodAlcoholLevel});
	        }

	        
	        System.out.println("DisplayStatTable");
	        this.repaint();
	}
	/**
	 * This function is called in every 20 milliseconds and responsible for the repaint the whole game space.
	 * 
	 * @author vtamas
	 *
	 */	
	

	public void ReDrawAll() { /*
								 * This function is scheduled to run every 20
								 * milliseconds.
								 */

	if (c.isGameRunning) {
		if (g.eGameType == Game_Type.eSinglePlayer) {
			SingleGamePanel.repaint();
		}

		if (g.eGameType == Game_Type.eMultiPlayer) {
			SingleGamePanel.repaint();
		}
	}
}

}