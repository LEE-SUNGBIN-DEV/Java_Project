package root;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class OptionPanel extends JPanel
{
	Image img1;
	
	public OptionPanel(Image img1) {
		
		this.img1 = img1;
		
		setSize(400, 400);
		setLayout(null);
		setVisible(false);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		g2d.drawImage(img1, 100, 240, null);
		paintComponents(g);
		this.repaint();
	}
}
