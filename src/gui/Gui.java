package gui;

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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.GameState;
import control.GameState.Game_Type;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;

	Dimension gridSize = new Dimension(300, 90);

	JLabel bWelcome = new JLabel("Main menu");
	JButton bSinglePlayer = new JButton("Single Player");
	JButton bMultiPlayer = new JButton("Multi Player");
	JButton bSettings = new JButton("Settings");
	JButton bStatistics = new JButton("Statistics");
	
	JButton sw2 = new JButton("Go back to main menu");
	JButton sw3 = new JButton("Go back to main menu");

	JPanel ContainerPanel = new JPanel();
	JPanel MainMenuPanel = new JPanel();
	JPanel SingleGamePanel = new JPanel();
	JPanel MultiGamePanel = new JPanel();
	
	private GameState g;

	public Gui(GameState gameState) {
		
		g = gameState;
	
		
		//setSize(400, 550);
		setTitle("BME MIT Sztech :: Alkesz");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		GridBagConstraints gbc = new GridBagConstraints(); 
		MainMenuPanel.setLayout(new GridBagLayout());

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6, 6, 6, 6);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		bWelcome.setPreferredSize(gridSize);
		bWelcome.setFont(new Font("Serif", Font.BOLD, 35));
		bWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		MainMenuPanel.add( bWelcome, gbc );
		gbc.gridy = 1;
		bSinglePlayer.setPreferredSize(gridSize);
		MainMenuPanel.add( bSinglePlayer, gbc );
		gbc.gridy = 2;
		bMultiPlayer.setPreferredSize(gridSize);
		MainMenuPanel.add( bMultiPlayer, gbc );
		gbc.gridy = 3;
		bSettings.setPreferredSize(gridSize);
		MainMenuPanel.add( bSettings, gbc );
		gbc.gridy = 4;
		bStatistics.setPreferredSize(gridSize);
		MainMenuPanel.add( bStatistics, gbc );
		
		
		SingleGamePanel.add(sw2);
		MultiGamePanel.add(sw3);
		
		
		CardLayout MainLayout = new CardLayout();
		
		ContainerPanel.setLayout(MainLayout);
		ContainerPanel.add(MainMenuPanel,"MMP");
		ContainerPanel.add(SingleGamePanel, "SGP");
		ContainerPanel.setPreferredSize(new Dimension(400, 550));
		
		MainLayout.show(ContainerPanel, "MMP");
		
		bSinglePlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainLayout.show(ContainerPanel, "SGP");
			}
		});
		
		sw2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainLayout.show(ContainerPanel, "MMP");
				
			}
		});
		
		add(ContainerPanel);
		setLayout(MainLayout);
		pack();
		setVisible(true);
	}
	
	void ReDrawAll() { /* This function is scheduled to run every 20 milliseconds. */
		if ( g.eGameType == Game_Type.eSinglePlayer ) { 
			SingleGamePanel.repaint();
		}
	}
	

}