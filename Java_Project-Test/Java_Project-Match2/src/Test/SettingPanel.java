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
//ȯ�漳�� �г��� �����.
	private JButton settingBtn; //settingBtn�� ������ settingPanel�� �ߴ� ��ư�� �����.
	private JButton resumeBtn; // ����ȭ������ ���ư��� ��ư�� �����.
	private JButton optionBtn; // �ɼ��гη� ���� ��ư�� �����.
	private JButton exitBtn; // ������ �����ϴ� ��ư�� �����.
	private JPanel optionPanel; //�ɼ��г��� �����.
	private Image settingImage; //
	private ImageIcon settingIcon; // ��ư�� �����̹����� ���� ��ü ����.
	
	private ButtonListener buttonL;
	
	public SettingPanel(SettingPanel settingPanel)
	{
		
	}
	
	public SettingPanel()
	{
		setPreferredSize(new Dimension(600, 600)); //ũ���  width430, height 320
		setBackground(Color.white); //������ ������� ����.
//		setVisible(false); //ó������ �Ⱥ��̰� �����Ѵ�.
		setLayout(null); // layoutmanager�� null�� ���־� ��ġ�� ����ڰ� ���ش�.
		setBounds(85,180, 430, 320);
		
//		optionPanel = new JPanel();
//		optionPanel.setBounds(20,20,200,200);
//		optionPanel.setBackground(Color.black);
//		optionPanel.setVisible(false);
//		add(optionPanel);
		
		Font font = new Font("Verdana", Font.BOLD,40);
		//Font ��ü�� �����Ͽ� ���Ŀ��� ����Ѵ�.
			
		
		resumeBtn = new JButton("RESUME");
		resumeBtn.setBounds(20, 20, 390, 80);
		resumeBtn.setBackground(Color.LIGHT_GRAY);
		resumeBtn.setForeground(Color.white);
		resumeBtn.setFont(font);
		add(resumeBtn);
		// resume��ư�� RESUME���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
		// ��Ʈ�� �������ش�.
		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
		
		
		optionBtn = new JButton("OPTION");
		optionBtn.setBounds(20, 120, 390, 80);
		optionBtn.setBackground(Color.LIGHT_GRAY);
		optionBtn.setForeground(Color.white);
		optionBtn.setFont(font);
		add(optionBtn);
		// option��ư�� OPTION���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
		// ��Ʈ�� �������ش�.			
		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
		
		
		
		exitBtn = new JButton("EXIT");
		exitBtn.setBounds(20, 220, 390, 80);
		exitBtn.setBackground(Color.LIGHT_GRAY);
		exitBtn.setForeground(Color.white);
		exitBtn.setFont(font);
		add(exitBtn);
		// exit��ư�� EXIT���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
		// ��Ʈ�� �������ش�.			
		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
		
		
		
		
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
