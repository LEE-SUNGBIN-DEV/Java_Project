package Test;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Background extends JPanel {
	
	private Image img1;
	private Image img2;
	private Image img3;
	private Image settingImage;
	private ImageIcon settingIcon;
	private SettingPanel settingPanel;
	private JButton settingBtn; //settingBtn�� �����Ͽ� settingPanel�� �߰� �Ѵ�.
	
	
	// �� ���� �̹����� ������ ���
	public Background(Image img1, Image img2, Image img3 ) {

		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
//		this.settingPanel = settingPanel;
		
		
		
		
		
		setSize(View.SCREEN_WIDTH, View.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(View.SCREEN_WIDTH, View.SCREEN_HEIGHT));
		setLayout(null);
		
		
		settingIcon = new ImageIcon("./img/settingimg.png");
		settingImage = settingIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		settingBtn = new JButton();
		settingBtn.setBounds(500, 500, 50, 50);
		settingBtn.setIcon(settingIcon);
		
		
		
		
		
		
		
	} // constructor
	
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
