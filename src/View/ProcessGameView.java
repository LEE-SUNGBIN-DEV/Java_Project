package View;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

<<<<<<< HEAD
import Model.ResourceData;
=======
import Model.ImageData;
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87


@SuppressWarnings("serial")
public class ProcessGameView extends JPanel {
	
<<<<<<< HEAD
=======
//	private Image backgroundBufferedImage;
//	private Image processBufferedImage;
//	private Image gameBoardBufferedImage;
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87
	private JButton exitButton;
	
	// 세 개의 이미지로 구성된 배경
	public ProcessGameView() {

		setSize(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT));
		setLayout(null);
		
<<<<<<< HEAD
=======
//		backgroundBufferedImage = new ImageIcon("./img/Background2.jpg").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
//		processBufferedImage = new ImageIcon("./img/ProcessGameScreen.png").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH - 120, OrchardView.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
//		gameBoardBufferedImage = new ImageIcon("./img/Texture.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87
		exitButton = new JButton();
		exitButton.setBounds(500, 20, 30, 30);
		add(exitButton);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(91, 180, 300, 400);
<<<<<<< HEAD
		g.drawImage(ResourceData.backgroundBufferedImage, 0, 0, null);
		g.drawImage(ResourceData.processBufferedImage, 0, 75, null);
=======
		g.drawImage(ImageData.getBackgroundBufferedImage2(), 0, 0, null);
		g.drawImage(ImageData.getProcessBufferedImage(), 0, 75, null);
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87
		
		// Game Board 이미지는 반투명하게 출력되어야하므로  Graphics2D 객체로 변환하여 투명도를 조정하여 출력한다.
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
<<<<<<< HEAD
		g2d.drawImage(ResourceData.gameBoardBufferedImage, 91, 180, null);
=======
		g2d.drawImage(ImageData.getGameBoardBufferedImage(), 91, 180, null);
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87
		
		paintComponents(g);
		this.repaint();
	}
	
}
