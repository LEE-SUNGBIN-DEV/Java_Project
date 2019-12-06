package root;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class Background extends JPanel {
	
	private Image img1;
	private Image img2;
	private Image img3;
	
	// 세 개의 이미지로 구성된 배경
	public Background(Image img1, Image img2, Image img3) {

		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		
		setSize(View.SCREEN_WIDTH, View.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(View.SCREEN_WIDTH, View.SCREEN_HEIGHT));
		setLayout(null);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(91, 180, 300, 400);
		g.drawImage(img1, 0, 0, null);
		g.drawImage(img2, 0, 75, null);
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		g2d.drawImage(img3, 91, 180, null);
		paintComponents(g);
		this.repaint();
	}
}
