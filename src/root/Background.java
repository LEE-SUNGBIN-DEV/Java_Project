package root;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Background extends JPanel {
	
	private Image img1;
	private Image img2;
	private Image img3;
	private OptionPanel optionPanel;
	//test
	private Image optionBufferedImage;
	private JButton optionButton;
	private boolean btnOnOff;
	
	// 세 개의 이미지로 구성된 배경
	public Background(Image img1, Image img2, Image img3) {

		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		
		setSize(View.SCREEN_WIDTH, View.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(View.SCREEN_WIDTH, View.SCREEN_HEIGHT));
		setLayout(null);
		
		//test
		btnOnOff = false;
		optionBufferedImage = new ImageIcon("./img/gimochi.png").getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
		optionPanel = new OptionPanel(optionBufferedImage);
		this.add(optionPanel);
		
		optionButton = new JButton("Option");
		optionButton.setBackground(Color.white);
		optionButton.setSize(100, 100);
		
		ActionListener listener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(btnOnOff == false ) btnOnOff = true;
						else if(btnOnOff == true) btnOnOff = false;
						
						if(btnOnOff == false) {
							optionPanel.setVisible(false);
						}
						
						else if(btnOnOff == true) {
							optionPanel.setVisible(true);
						}
					}
			
				};
		optionButton.addActionListener(listener);
		add(optionButton);
		//
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
