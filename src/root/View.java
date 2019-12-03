package root;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {

	private JFrame frame;
	private JPanel primary;
	private GameBoard board;
	private TileGrid grid;
	private Match match;
	
	Graphics gc;
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public View() {
	
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		grid = new TileGrid();
		match = new Match(grid);
		Thread th = new Thread(match);
		th.start();
		primary = new GameBoard(grid);
		frame.getContentPane().add(primary, BorderLayout.CENTER);
		
		SoundPanel newPanel = new SoundPanel();
		frame.getContentPane().add(newPanel, BorderLayout.SOUTH);
	}
	
}
