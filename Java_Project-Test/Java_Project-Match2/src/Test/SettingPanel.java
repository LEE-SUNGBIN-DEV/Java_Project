package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private Image settingImage; //
	private ImageIcon settingIcon; // 버튼에 세팅이미지를 넣을 객체 생성.
	
	private ButtonListener buttonL;
	
	public SettingPanel(SettingPanel settingPanel)
	{
		
	}
	
	public SettingPanel()
	{
		setPreferredSize(new Dimension(600, 600)); //크기는  width430, height 320
		setBackground(Color.white); //배경색은 흰색으로 설정.
//		setVisible(false); //처음에는 안보이게 설정한다.
		setLayout(null); // layoutmanager를 null로 해주어 배치를 사용자가 해준다.
		setBounds(85,180, 430, 320);
		
//		optionPanel = new JPanel();
//		optionPanel.setBounds(20,20,200,200);
//		optionPanel.setBackground(Color.black);
//		optionPanel.setVisible(false);
//		add(optionPanel);
		
		Font font = new Font("Verdana", Font.BOLD,40);
		//Font 객체를 생성하여 추후에도 사용한다.
			
		
		resumeBtn = new JButton("RESUME");
		resumeBtn.setBounds(20, 20, 390, 80);
		resumeBtn.setBackground(Color.LIGHT_GRAY);
		resumeBtn.setForeground(Color.white);
		resumeBtn.setFont(font);
		add(resumeBtn);
		// resume버튼을 RESUME으로 표시하고, 배치할 좌표를 계산하여 배치한다.
		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
		// 폰트를 설정해준다.
		// SettingPanel에 add하여 버튼을 넣어준다.
		
		
		optionBtn = new JButton("OPTION");
		optionBtn.setBounds(20, 120, 390, 80);
		optionBtn.setBackground(Color.LIGHT_GRAY);
		optionBtn.setForeground(Color.white);
		optionBtn.setFont(font);
		add(optionBtn);
		// option버튼을 OPTION으로 표시하고, 배치할 좌표를 계산하여 배치한다.
		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
		// 폰트를 설정해준다.			
		// SettingPanel에 add하여 버튼을 넣어준다.
		
		
		
		exitBtn = new JButton("EXIT");
		exitBtn.setBounds(20, 220, 390, 80);
		exitBtn.setBackground(Color.LIGHT_GRAY);
		exitBtn.setForeground(Color.white);
		exitBtn.setFont(font);
		add(exitBtn);
		// exit버튼을 EXIT으로 표시하고, 배치할 좌표를 계산하여 배치한다.
		// 배경색을 light_gray로 설정후, 글씨 색을 흰색으로 표시한다.
		// 폰트를 설정해준다.			
		// SettingPanel에 add하여 버튼을 넣어준다.
		
		
		
		
		settingIcon = new ImageIcon("./img/settingimg.png");
		settingImage = settingIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		settingBtn = new JButton();
		settingBtn.setBounds(500,200,50,50);
		settingBtn.setIcon(settingIcon);
		add(settingBtn);
		
	} // constructor
	
	private class ButtonListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {


			Object obj = e.getSource();
			if(obj == resumeBtn) {
				
			}
			
			
		}
		
	}
}
