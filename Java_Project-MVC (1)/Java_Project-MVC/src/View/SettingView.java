package View;

import Model.TileGrid;


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


public class SettingView extends JPanel {
//ȯ�漳�� �г��� �����.
	private JButton settingBtn; //settingBtn�� ������ settingPanel�� �ߴ� ��ư�� �����.
	private JButton resumeBtn; // ����ȭ������ ���ư��� ��ư�� �����.
	private JButton optionBtn; // �ɼ��гη� ���� ��ư�� �����.
	private JButton exitBtn; // ������ �����ϴ� ��ư�� �����.
	
	private JButton musicBtn;
	private JButton modeBtn;
	private JButton backBtn;
	
	private Image settingImage1; //
	private Image settingImage2;
	private Image settingImage3;
	private ImageIcon settingIcon; // ��ư�� �����̹����� ���� ��ü ����.
	
	
	private boolean resumebtnOnOff;
	public static boolean optionbtnOnOff;
	private boolean exitbtnOnOff;

	private OptionView optionPanel;
	
	
//	private ButtonListener buttonL;
	
	public SettingView(JButton btn1, JButton btn2, JButton btn3)
	{
		//SettingPanel �����ڸ� �Ķ���� �����ڷ� �����.
		// �Ķ���Ϳ��� �̹��� ���� 3����, ��ư 3 ���� �޴´�.
//		this.settingImage1 = img1;
//		this.settingImage2 = img2;
//		this.settingImage3 = img3;
		//SettingPanel�� �� �̹����� �� �Ķ������ �̹����� �����Ѵ�.
		
		this.resumeBtn = btn1;
		this.optionBtn = btn2;
		this.exitBtn = btn3;
		//�� ��ư�� �� �Ķ������ ��ư�� �����Ѵ�.
		
		setSize(600, 680);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setVisible(false);
		// SettigPanel�� ũ�⸦ 600x680���� �����ϰ� ������ LIGHT_GRAY�� �������ش�.
		// layoutManager�� null�� �Ͽ� ��ġ�� ����ڰ� �������ش�.
		// ó������ �Ⱥ����ְ� �������ش�.
		
		
//		this.resumeBtn = resumeBtn;
//		resumeBtn.setIcon(new ImageIcon("./img/resumeBtnImg.png"));
//		resumeBtn.setSize(250,100);
//		resumeBtn.setBounds(150,140,250,100);
		
		resumebtnOnOff = false;
	    optionbtnOnOff = false;
//	      this.setOptionbtnOnOff(false);
	    exitbtnOnOff = false;
		//resume��ư�� ������ �� ȭ���� �ٽ� ǥ���ؾ� �ϱ� ���� boolean���� resumebtnOnOff���ٰ� ó���� false�� �������ش�.
		
		Font font = new Font("Verdana", Font.BOLD,40);
		//font ��ü�� �����Ͽ� ���Ŀ� ��� ����Ѵ�.
		
		resumeBtn = new JButton("RESUME");
		resumeBtn.setBounds(150,140,250,100);
		resumeBtn.setFont(font);
		this.add(resumeBtn);
		// resume��ư�� RESUME���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
		// ��Ʈ�� �������ش�.
		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
		
		optionBtn = new JButton("OPTION");
		optionBtn.setBounds(150,270,250,100);
		optionBtn.setFont(font);
		this.add(optionBtn);
		// option��ư�� OPTION���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
		// ��Ʈ�� �������ش�.			
		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
		
		exitBtn = new JButton("EXIT");
		exitBtn.setBounds(150,400,250,100);
		exitBtn.setFont(font);
		this.add(exitBtn);
		// exit��ư�� EXIT���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
		// ��Ʈ�� �������ش�.			
		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
		
		 musicBtn = new JButton("ON");
	     musicBtn.setSize(250,100);
	     modeBtn = new JButton("CLICK");
	     modeBtn.setSize(250,100);
	     backBtn = new JButton("BACK");
	     backBtn.setSize(250,100);
	      
	      
	     optionPanel = new OptionView(resumeBtn, optionBtn, exitBtn, musicBtn, modeBtn, backBtn);
	     
//	      setOptionPanel(new OptionPanel());
	      this.add(optionPanel);
		
		
		
		ActionListener listener = new ActionListener() {
			//��ư�� ������ �� ȭ���� �ٽ� ǥ�õǱ� ���� �׼Ǹ����ʸ� �����Ѵ�.

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object obj = e.getSource();
				//��ư ��ü�� �޾ƿ´�.
				
				if(obj == resumeBtn)
				{
					if(resumebtnOnOff == false ) resumebtnOnOff = true;
					else if(resumebtnOnOff == true) resumebtnOnOff = false;
					//resume��ư�� false �̸� true�� true�̸� false�� �ٲ��־� �ش� ���ǿ� ���߾� �����Ѵ�.
					
					if(resumebtnOnOff == false) { //resume��ư�� false�̸� 
						setVisible(false);
						TileGrid.isSettingPanelOn = false;
						//settingPanel�� �Ⱥ��̰� �ϰ�, TileGrid�� isSettingPanelOn������ false�� �ٲپ� TileGrid�� ǥ�õǰ� �Ѵ�.
						
					}
					
					else if(resumebtnOnOff == true) { //resume��ư�� true�ӿ�
						setVisible(true);
						TileGrid.isSettingPanelOn = true;
						//settingPanel�� ���̰� �ϰ�, TileGrid�� isSettingPanelOn������ true�� �ٲپ� TileGrid�� ǥ�õ��� �ʰ� �Ѵ�.
						
						if(TileGrid.isSettingPanelOn == true)
							System.out.println("NO");
						
					}
				}
				else if(obj == optionBtn) {
					if (optionbtnOnOff == false) {
		            	   System.out.println("OPTIONbtn >> ON ");
		            	   optionbtnOnOff = true;
//		                  setOptionbtnOnOff(true);
		               } else if (optionbtnOnOff == true) {
		            	   System.out.println("OPTIONbtn >> FALSE ");
		            	   optionbtnOnOff = false;
//		                  setOptionbtnOnOff(false);
		               }

		               if (optionbtnOnOff == false) {
		                  resumeBtn.setVisible(true);
		                  exitBtn.setVisible(true);
		                  optionBtn.setVisible(true);
		                  
//		            	  optionPanel.backbtnOnOff = true;
		            	  
		                  optionPanel.setVisible(false);
		               } else if (optionbtnOnOff == true) {
		            	   System.out.println("�ɼǹ�ư Ŭ��");
		                  resumeBtn.setVisible(false);
		                  exitBtn.setVisible(false);
		                  optionBtn.setVisible(false);
		                  
//		                  optionPanel.backbtnOnOff = false;
		                  
		                  musicBtn.setVisible(true);
		                  modeBtn.setVisible(true);
		                  backBtn.setVisible(true);
		                  
		                  optionPanel.setVisible(true);
		               }
				}
				else if(obj == exitBtn)
				{
					System.exit(1);
				}
			}
	
		};
		
		resumeBtn.addActionListener(listener);
		//resume��ư�� �׼Ǹ����ʸ� �������ش�.
		optionBtn.addActionListener(listener);
		//option��ư�� �׼Ǹ����ʸ� �������ش�.
		exitBtn.addActionListener(listener);
		//exit��ư�� �׼Ǹ����ʸ� �������ش�.
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
////		setPreferredSize(new Dimension(600, 600)); //ũ���  width430, height 320
////		setBackground(Color.white); //������ ������� ����.
//////		setVisible(false); //ó������ �Ⱥ��̰� �����Ѵ�.
////		setLayout(null); // layoutmanager�� null�� ���־� ��ġ�� ����ڰ� ���ش�.
////		setBounds(85,180, 430, 320);
//		
////		optionPanel = new JPanel();
////		optionPanel.setBounds(20,20,200,200);
////		optionPanel.setBackground(Color.black);
////		optionPanel.setVisible(false);
////		add(optionPanel);
//		
//		Font font = new Font("Verdana", Font.BOLD,40);
//		//Font ��ü�� �����Ͽ� ���Ŀ��� ����Ѵ�.
//			
//		
//		resumeBtn = new JButton("RESUME");
//		resumeBtn.setBounds(20, 20, 390, 80);
//		resumeBtn.setBackground(Color.LIGHT_GRAY);
//		resumeBtn.setForeground(Color.white);
//		resumeBtn.setFont(font);
//		add(resumeBtn);
//		// resume��ư�� RESUME���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
//		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
//		// ��Ʈ�� �������ش�.
//		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
//		
//		
//		optionBtn = new JButton("OPTION");
//		optionBtn.setBounds(20, 120, 390, 80);
//		optionBtn.setBackground(Color.LIGHT_GRAY);
//		optionBtn.setForeground(Color.white);
//		optionBtn.setFont(font);
//		add(optionBtn);
//		// option��ư�� OPTION���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
//		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
//		// ��Ʈ�� �������ش�.			
//		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
//		
//		
//		
//		exitBtn = new JButton("EXIT");
//		exitBtn.setBounds(20, 220, 390, 80);
//		exitBtn.setBackground(Color.LIGHT_GRAY);
//		exitBtn.setForeground(Color.white);
//		exitBtn.setFont(font);
//		add(exitBtn);
//		// exit��ư�� EXIT���� ǥ���ϰ�, ��ġ�� ��ǥ�� ����Ͽ� ��ġ�Ѵ�.
//		// ������ light_gray�� ������, �۾� ���� ������� ǥ���Ѵ�.
//		// ��Ʈ�� �������ش�.			
//		// SettingPanel�� add�Ͽ� ��ư�� �־��ش�.
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
