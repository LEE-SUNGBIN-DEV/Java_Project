package View;

import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class OrchardView extends JFrame{

	public static int SCREEN_WIDTH = 480 + 120, SCREEN_HEIGHT = 600 + 80;

	private StartView loginPanel;
	private ProcessGameView processGamePanel;
	
	public OrchardView() {
		initialize();
	}

	private void initialize() {	
	
		// Frame�ʱ�ȭ
		setUndecorated(true);
		setVisible(true);
		setTitle("Orchard");
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ���α׷��� �ʿ��� �гε��� �̸� ����
		loginPanel = new StartView();
		loginPanel.setVisible(true);
		add(loginPanel);
		
		processGamePanel = new ProcessGameView();
		processGamePanel.setVisible(false);
		add(processGamePanel);
		
		pack();

		setLocationRelativeTo(null);
	}
	
	public void changeToGameView(GameBoardPanel gameBoard) {
		loginPanel.setVisible(false);
		processGamePanel.add(gameBoard);
		processGamePanel.setVisible(true);
	}
	
	public void changeToLoginView() {
		processGamePanel.setVisible(false);
		loginPanel.setVisible(true);
	}
	
	public void addStartbtnListener(MouseListener listener) {
		loginPanel.addStartbtnListener(listener);
	}
	
	public void addExitbtnListener(MouseListener listener) {
		loginPanel.addExitbtnListner(listener);
	}
}
