package View;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Model.ResourceData;
import Model.ImageData;


@SuppressWarnings("serial")
public class ProcessGameView extends JPanel {
	
	private JButton exitButton;
	
	// �� ���� �̹����� ������ ���
	public ProcessGameView() {

		setSize(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT));
		setLayout(null);
		
		exitButton = new JButton();
		exitButton.setBounds(500, 20, 30, 30);
		add(exitButton);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(91, 180, 300, 400);
		g.drawImage(ResourceData.backgroundBufferedImage, 0, 0, null);
		g.drawImage(ResourceData.processBufferedImage, 0, 75, null);
		g.drawImage(ImageData.getBackgroundBufferedImage2(), 0, 0, null);
		g.drawImage(ImageData.getProcessBufferedImage(), 0, 75, null);
		
		// Game Board �̹����� �������ϰ� ��µǾ���ϹǷ�  Graphics2D ��ü�� ��ȯ�Ͽ� ������ �����Ͽ� ����Ѵ�.
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		g2d.drawImage(ResourceData.gameBoardBufferedImage, 91, 180, null);
		g2d.drawImage(ImageData.getGameBoardBufferedImage(), 91, 180, null);
		
		paintComponents(g);
		this.repaint();
	}
	
}
