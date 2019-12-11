package View;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Model.ImageData;
import Model.TileGrid;


@SuppressWarnings("serial")
public class ProcessGameView extends JPanel {
	
//	private Image backgroundBufferedImage;
//	private Image processBufferedImage;
//	private Image gameBoardBufferedImage;
	private JButton exitButton;
	private JButton settingButton;
	
	private JButton resumeBtn; // ����ȭ������ ���ư��� ��ư�� �����.
	private JButton optionBtn; // �ɼ��гη� ���� ��ư�� �����.
	private JButton exitBtn; // ������ �����ϴ� ��ư�� �����.
	private SettingView settingPanel;
	
	private boolean btnOnOff;
	
	// �� ���� �̹����� ������ ���
	public ProcessGameView() {

		setSize(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT);
		setPreferredSize(new Dimension(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT));
		setLayout(null);
		
//		backgroundBufferedImage = new ImageIcon("./img/Background2.jpg").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
//		processBufferedImage = new ImageIcon("./img/ProcessGameScreen.png").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH - 120, OrchardView.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
//		gameBoardBufferedImage = new ImageIcon("./img/Texture.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		
		btnOnOff = false;
		
		exitButton = new JButton();
		exitButton.setBounds(500, 20, 30, 30);
		add(exitButton);
		
		
		settingButton = new JButton();
		
		settingButton.setIcon(ImageData.getSettingIcon());
		settingButton.setSize(60,60);
		settingButton.setBounds(530,500,50,50);
		
		resumeBtn = new JButton();
		resumeBtn.setSize(250,100);

		
		optionBtn = new JButton();
		optionBtn.setSize(250,100);

		
		exitBtn = new JButton();
		exitBtn.setSize(250,100);
		
		
		settingPanel = new SettingView(resumeBtn, optionBtn, exitBtn);
		add(settingPanel);
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnOnOff == false) btnOnOff = true;
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
		settingButton.addActionListener(listener);

		add(settingButton);

	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(91, 180, 300, 400);
		g.drawImage(ImageData.getBackgroundBufferedImage2(), 0, 0, null);
		g.drawImage(ImageData.getProcessBufferedImage(), 0, 75, null);
		
		// Game Board �̹����� �������ϰ� ��µǾ���ϹǷ�  Graphics2D ��ü�� ��ȯ�Ͽ� ������ �����Ͽ� ����Ѵ�.
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		g2d.drawImage(ImageData.getGameBoardBufferedImage(), 91, 180, null);
		
		paintComponents(g);
		this.repaint();
	}
	
}
