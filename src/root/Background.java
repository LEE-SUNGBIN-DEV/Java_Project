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
	
	
//	private OptionPanel optionPanel;
//	//test
//	private Image optionBufferedImage;
//	private JButton optionButton;
	private SettingPanel settingPanel;
	
	private Image settingBufferedImage1;
	private Image settingBufferedImage2;
	private Image settingBufferedImage3;
	private Image settingImage;
	private ImageIcon settingIcon;
	
	
	
	private JButton settingBtn;
	private JButton resumeBtn; // 게임화면으로 돌아가는 버튼을 만든다.
	private JButton optionBtn; // 옵션패널로 들어가는 버튼을 만든다.
	private JButton exitBtn; // 게임을 종료하는 버튼을 만든다.
	
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
		settingBufferedImage1 = new ImageIcon("./img/resumeBtnImg.png").getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
		settingBufferedImage2 = new ImageIcon("./img/optionBtnImg.png").getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
		settingBufferedImage3 = new ImageIcon("./img/exitBtnImg.png").getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
		
		

		
		settingBtn = new JButton();
		settingIcon = new ImageIcon("./img/settingimg.png");
		settingImage = settingIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		settingBtn.setIcon(settingIcon);
		settingBtn.setSize(60,60);
		settingBtn.setBounds(530,500,50,50);
		
		resumeBtn = new JButton();
		resumeBtn.setIcon(new ImageIcon("./img/resumeBtnImg.png"));
		resumeBtn.setSize(250,100);

		
		optionBtn = new JButton();
		optionBtn.setIcon(new ImageIcon("./img/optionBtnImg.png"));
		optionBtn.setSize(250,100);

		
		exitBtn = new JButton();
		exitBtn.setIcon(new ImageIcon("./img/exitBtnImg.png"));
		exitBtn.setSize(250,100);

		
		settingPanel = new SettingPanel(settingBufferedImage1, settingBufferedImage2, settingBufferedImage3, resumeBtn, optionBtn, exitBtn);
		this.add(settingPanel);
		
		ActionListener listener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(btnOnOff == false ) btnOnOff = true;
						else if(btnOnOff == true) btnOnOff = false;
						
						if(btnOnOff == false) {
							settingPanel.setVisible(false);

							TileGrid.isSettingPanelOn = false;
						}
						
						else if(btnOnOff == true) {
							settingPanel.setVisible(true);

							TileGrid.isSettingPanelOn = true;
							if(TileGrid.isSettingPanelOn == true)
								System.out.println("NO");
						}
					}
			
				};
		settingBtn.addActionListener(listener);
		
		add(settingBtn);

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
