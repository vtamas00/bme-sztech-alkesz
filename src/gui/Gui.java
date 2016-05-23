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

import control.Control;
import control.Food_Drink;
import control.GameState;
import control.Position;
import control.GameState.Game_Type;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;

	Dimension gridSize = new Dimension(300, 90);

	JLabel bWelcome = new JLabel("Main menu");
	JButton bSinglePlayer = new JButton("Single Player");
	JButton bMultiPlayer = new JButton("Multi Player");
	JButton bSettings = new JButton("Settings");
	JButton bStatistics = new JButton("Statistics");

	JButton sw2 = new JButton("Main menu");
	JButton sw3 = new JButton("Main menu");
	JButton sw4 = new JButton("Pasue");
	JButton sw5 = new JButton("Reset");

	JPanel ContainerPanel = new JPanel();
	JPanel MainMenuPanel = new JPanel();
	GameSpacePanel SingleGamePanel = new GameSpacePanel();
	JPanel MultiGamePanel = new JPanel();

	private GameState g;
	private Control c;

	public Gui(GameState gameState, Control control) {

		this.g = gameState;
		this.c = control;
		SingleGamePanel.setGameState(gameState);
		SingleGamePanel.setControl(control);

		// setSize(400, 550);
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
		MainMenuPanel.add(bWelcome, gbc);
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

		SingleGamePanel.add(sw2);
		MultiGamePanel.add(sw3);

		final CardLayout MainLayout = new CardLayout();

		ContainerPanel.setLayout(MainLayout);
		ContainerPanel.add(MainMenuPanel, "MMP");
		ContainerPanel.add(SingleGamePanel, "SGP");
		ContainerPanel.setPreferredSize(new Dimension(g.Settings.SizeX, g.Settings.SizeY));

		MainLayout.show(ContainerPanel, "MMP");

		bSinglePlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainLayout.show(ContainerPanel, "SGP");
				g.eGameType = Game_Type.eSinglePlayer;
				c.StartGame();
				
			}
		});

		SingleGamePanel.add(sw4);
		SingleGamePanel.add(sw5);

		sw2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainLayout.show(ContainerPanel, "MMP");

			}
		});

		sw4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.Pause();
			}
		});

		sw5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.RestartGame();
			}
		});

		
		add(ContainerPanel);
		setLayout(MainLayout);
		pack();
		setVisible(true);

	}

	public void ReDrawAll() { /*
								 * This function is scheduled to run every 20
								 * milliseconds.
								 */
		
		if (g.eGameType == Game_Type.eSinglePlayer) {
			SingleGamePanel.repaint();
		}
	}

}