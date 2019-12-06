package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrchardView extends JFrame{
	
	private JPanel 		 mainPanel;
	private MenuPanel	 menuPanel;
	private TitlePanel	 titlePanel;
	private OrchardBoard gameBoard;
	private final int WIDTH  = 720;
	private final int HEIGHT = 720;
	public OrchardView()
	{
		// initialize main Frame
		setTitle("Orchard");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		mainPanel.setLayout(new BorderLayout());
		
		gameBoard = new OrchardBoard();
		menuPanel = new MenuPanel();
		titlePanel = new TitlePanel();
		
		
		mainPanel.add(gameBoard, BorderLayout.CENTER);
		mainPanel.add(menuPanel, BorderLayout.EAST);
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		
		getContentPane().add(mainPanel);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void gridDraw()
	{
		
	}
	
	public void Update(int[][] intGrid)
	{
	}
}
