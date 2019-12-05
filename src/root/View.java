package root;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {

	public static int SCREEN_WIDTH = 480 + 120, SCREEN_HEIGHT = 600 + 80;
	private JFrame frame;
	private Background backgroundPanel;
	private Image backgroundBufferedImage;
	private Image processBufferedImage;
	private Image gameBoardBufferedImage;
	private TileGrid grid;
	private Match match;
	private Thread matchThread;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public View() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Orchard");
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		backgroundBufferedImage = new ImageIcon("./img/Background2.jpg").getImage().getScaledInstance(View.SCREEN_WIDTH, View.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		processBufferedImage = new ImageIcon("./img/ProcessGameScreen.png").getImage().getScaledInstance(View.SCREEN_WIDTH - 120, View.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
		gameBoardBufferedImage = new ImageIcon("./img/Texture.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		
		backgroundPanel = new Background(backgroundBufferedImage, processBufferedImage, gameBoardBufferedImage);
		
		grid = new TileGrid();

		match = new Match(grid);
		matchThread = new Thread(match);
		matchThread.start();
		
		backgroundPanel.add(grid);
		frame.add(backgroundPanel);
		frame.pack();
		
		Music titleMusic = new Music("ProcessGameMusic.mp3", true);
		Thread musicThread = new Thread(titleMusic);
		musicThread.start();
	}
}
