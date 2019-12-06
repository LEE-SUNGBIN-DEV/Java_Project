package root;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingPanel extends JPanel {

	private JButton resumeBtn;
	private JButton optionBtn;
	private JButton exitBtn;
	private JPanel optionPanel;
	
	public SettingPanel()
	{
		setPreferredSize(new Dimension(430, 320));
		setBackground(Color.white);
		setLayout(null);
		
//		optionPanel = new JPanel();
//		optionPanel.setBounds(20,20,200,200);
//		optionPanel.setBackground(Color.black);
//		optionPanel.setVisible(false);
//		add(optionPanel);
		
		resumeBtn = new JButton("RESUME");
		resumeBtn.setBounds(20, 20, 390, 80);
		resumeBtn.setBackground(Color.LIGHT_GRAY);
		resumeBtn.setForeground(Color.white);
		
		
		optionBtn = new JButton("OPTION");
		optionBtn.setBounds(20, 120, 390, 80);
		optionBtn.setBackground(Color.LIGHT_GRAY);
		optionBtn.setForeground(Color.white);
		
		exitBtn = new JButton("EXIT");
		exitBtn.setBounds(20, 220, 390, 80);
		exitBtn.setBackground(Color.LIGHT_GRAY);
		exitBtn.setForeground(Color.white);
		
	}
}
