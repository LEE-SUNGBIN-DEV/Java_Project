package View;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ProcessGameView extends JPanel {
	
	private Image backgroundBufferedImage;
	private Image processBufferedImage;
	private Image gameBoardBufferedImage;
	private JButton exitButton;
	
	// �� ���� �̹����� ������ ���
	public ProcessGameView() {

		setSize(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT));
		setLayout(null);
		
		backgroundBufferedImage = new ImageIcon("./img/Background2.jpg").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		processBufferedImage = new ImageIcon("./img/ProcessGameScreen.png").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH - 120, OrchardView.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
		gameBoardBufferedImage = new ImageIcon("./img/Texture.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		
		exitButton = new JButton();
		exitButton.setBounds(500, 20, 30, 30);
		add(exitButton);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(91, 180, 300, 400);
		g.drawImage(backgroundBufferedImage, 0, 0, null);
		g.drawImage(processBufferedImage, 0, 75, null);
		
		// Game Board �̹����� �������ϰ� ��µǾ���ϹǷ�  Graphics2D ��ü�� ��ȯ�Ͽ� ������ �����Ͽ� ����Ѵ�.
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		g2d.drawImage(gameBoardBufferedImage, 91, 180, null);
		
		paintComponents(g);
		this.repaint();
	}
	
}
