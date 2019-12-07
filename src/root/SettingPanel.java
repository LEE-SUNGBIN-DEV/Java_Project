package root;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingPanel extends JPanel {
//환경설정 패널을 만든다.
	private JButton settingBtn; //settingBtn을 누르면 settingPanel이 뜨는 버튼을 만든다.
	private JButton resumeBtn; // 게임화면으로 돌아가는 버튼을 만든다.
	private JButton optionBtn; // 옵션패널로 들어가는 버튼을 만든다.
	private JButton exitBtn; // 게임을 종료하는 버튼을 만든다.
	private JPanel optionPanel; //옵션패널을 만든다.
	private Image settingImage1; //
	private Image settingImage2;
	private Image settingImage3;
	private ImageIcon settingIcon; // 버튼에 세팅이미지를 넣을 객체 생성.
	private boolean resumebtnOnOff;
	
//	private ButtonListener buttonL;
	
	public SettingPanel(Image img1, Image img2, Image img3, JButton btn1, JButton btn2, JButton btn3)
	{
		//SettingPanel 생성자를 파라미터 생성자로 만든다.
		// 파라미터에는 이미지 파일 3개와, 버튼 3 개를 받는다.
//		this.settingImage1 = img1;
//		this.settingImage2 = img2;
//		this.settingImage3 = img3;
		//SettingPanel의 각 이미지에 각 파라미터의 이미지를 저장한다.
		
		this.resumeBtn = btn1;
		this.optionBtn = btn2;
		this.exitBtn = btn3;
		//각 버튼에 각 파라미터의 버튼을 연결한다.
		
		setSize(600, 680);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setVisible(false);
		// SettigPanel의 크기를 600x680으로 설정하고 배경색을 LIGHT_GRAY로 설정해준다.
		// layoutManager를 null로 하여 배치를 사용자가 지정해준다.
		// 처음에는 안보여주게 설정해준다.
		
		
//		this.resumeBtn = resumeBtn;
//		resumeBtn.setIcon(new ImageIcon("./img/resumeBtnImg.png"));
//		resumeBtn.setSize(250,100);
//		resumeBtn.setBounds(150,140,250,100);
		
		resumebtnOnOff = false;
		//resume버튼을 눌렀을 때 화면이 다시 표시해야 하기 위한 boolean변수 resumebtnOnOff에다가 처음엔 false로 설정해준다.
		
		Font font = new Font("Verdana", Font.BOLD,40);
		//font 객체를 생성하여 추후에 계속 사용한다.
		
		resumeBtn = new JButton("RESUME");
		resumeBtn.setBounds(150,140,250,100);
		resumeBtn.setFont(font);
		this.add(resumeBtn);
		// resume버튼을 RESUME으로 표시하고, 배치할 좌표를 계산하여 배치한다.
		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
		// 폰트를 설정해준다.
		// SettingPanel에 add하여 버튼을 넣어준다.
		
		optionBtn = new JButton("OPTION");
		optionBtn.setBounds(150,270,250,100);
		optionBtn.setFont(font);
		this.add(optionBtn);
		// option버튼을 OPTION으로 표시하고, 배치할 좌표를 계산하여 배치한다.
		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
		// 폰트를 설정해준다.			
		// SettingPanel에 add하여 버튼을 넣어준다.
		
		exitBtn = new JButton("EXIT");
		exitBtn.setBounds(150,400,250,100);
		exitBtn.setFont(font);
		this.add(exitBtn);
		// exit버튼을 EXIT으로 표시하고, 배치할 좌표를 계산하여 배치한다.
		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
		// 폰트를 설정해준다.			
		// SettingPanel에 add하여 버튼을 넣어준다.
		
		ActionListener listener = new ActionListener() {
			//버튼을 눌렀을 때 화면이 다시 표시되기 위한 액션리스너를 생성한다.

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object obj = e.getSource();
				//버튼 객체를 받아온다.
				
				if(obj == resumeBtn)
				{
					if(resumebtnOnOff == false ) resumebtnOnOff = true;
					else if(resumebtnOnOff == true) resumebtnOnOff = false;
					//resume버튼이 false 이면 true로 true이면 false로 바꿔주어 해당 조건에 맞추어 실행한다.
					
					if(resumebtnOnOff == false) { //resume버튼이 false이면 
						setVisible(false);
						TileGrid.isSettingPanelOn = false;
						//settingPanel을 안보이게 하고, TileGrid의 isSettingPanelOn변수를 false로 바꾸어 TileGrid가 표시되게 한다.
						
					}
					
					else if(resumebtnOnOff == true) { //resume버튼이 true임연
						setVisible(true);
						TileGrid.isSettingPanelOn = true;
						//settingPanel을 보이게 하고, TileGrid의 isSettingPanelOn변수를 true로 바꾸어 TileGrid가 표시되지 않게 한다.
						
						if(TileGrid.isSettingPanelOn == true)
							System.out.println("NO");
					}
				}
				else if(obj == exitBtn)
				{
					
				}
			}
	
		};
		
		resumeBtn.addActionListener(listener);
		//resume버튼에 액션리스너를 연결해준다.
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		g2d.drawImage(settingImage1, 150, 140, null);
		g2d.drawImage(settingImage2, 150, 270, null);
		g2d.drawImage(settingImage3, 150, 400, null);
		
		paintComponents(g);
		this.repaint();
	}
	
	
	
//	public SettingPanel()
//	{
////		setPreferredSize(new Dimension(600, 600)); //크기는  width430, height 320
////		setBackground(Color.white); //배경색은 흰색으로 설정.
//////		setVisible(false); //처음에는 안보이게 설정한다.
////		setLayout(null); // layoutmanager를 null로 해주어 배치를 사용자가 해준다.
////		setBounds(85,180, 430, 320);
//		
////		optionPanel = new JPanel();
////		optionPanel.setBounds(20,20,200,200);
////		optionPanel.setBackground(Color.black);
////		optionPanel.setVisible(false);
////		add(optionPanel);
//		
//		Font font = new Font("Verdana", Font.BOLD,40);
//		//Font 객체를 생성하여 추후에도 사용한다.
//			
//		
//		resumeBtn = new JButton("RESUME");
//		resumeBtn.setBounds(20, 20, 390, 80);
//		resumeBtn.setBackground(Color.LIGHT_GRAY);
//		resumeBtn.setForeground(Color.white);
//		resumeBtn.setFont(font);
//		add(resumeBtn);
//		// resume버튼을 RESUME으로 표시하고, 배치할 좌표를 계산하여 배치한다.
//		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
//		// 폰트를 설정해준다.
//		// SettingPanel에 add하여 버튼을 넣어준다.
//		
//		
//		optionBtn = new JButton("OPTION");
//		optionBtn.setBounds(20, 120, 390, 80);
//		optionBtn.setBackground(Color.LIGHT_GRAY);
//		optionBtn.setForeground(Color.white);
//		optionBtn.setFont(font);
//		add(optionBtn);
//		// option버튼을 OPTION으로 표시하고, 배치할 좌표를 계산하여 배치한다.
//		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
//		// 폰트를 설정해준다.			
//		// SettingPanel에 add하여 버튼을 넣어준다.
//		
//		
//		
//		exitBtn = new JButton("EXIT");
//		exitBtn.setBounds(20, 220, 390, 80);
//		exitBtn.setBackground(Color.LIGHT_GRAY);
//		exitBtn.setForeground(Color.white);
//		exitBtn.setFont(font);
//		add(exitBtn);
//		// exit버튼을 EXIT으로 표시하고, 배치할 좌표를 계산하여 배치한다.
//		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
//		// 폰트를 설정해준다.			
//		// SettingPanel에 add하여 버튼을 넣어준다.
//		
//		
//		
//		
//		settingIcon = new ImageIcon("./img/settingimg.png");
////		settingImage = settingIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//		
//		settingBtn = new JButton();
//		settingBtn.setBounds(500,200,50,50);
//		settingBtn.setIcon(settingIcon);
//		add(settingBtn);
//		
//	} // constructor
//	
//	private class ButtonListener implements ActionListener 
//	{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//
//			Object obj = e.getSource();
//			if(obj == resumeBtn) {
//				
//			}
//			
//			
//		}
//		
//	}
}
