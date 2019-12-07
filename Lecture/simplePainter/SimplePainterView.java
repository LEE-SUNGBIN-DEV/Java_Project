package simplePainter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SimplePainterView extends JPanel
{
	private DrawingPanelView drawView;
	private JPanel			optionPanel, menuBasePanel;
	private JPanel			menuPanel, messagePanel;
	public JButton[]		btnMenuArray;
	public JLabel			lblSizeNWidth;
	public JTextField		txtSizeNWidth;
	public JButton			btnColor;
	public JCheckBox		chkFill;
	
	public SimplePainterView()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(710,710));
		setLayout(null);
		AppManager.getInstance().setView(this);
		
		drawView = new DrawingPanelView();
		add(drawView);
		
		messagePanel = new JPanel();
		messagePanel.setBackground(Color.white);
		messagePanel.setBounds(560,0,147,500);
		messagePanel.setLayout(null);
		messagePanel.setBorder(BorderFactory.createTitledBorder("MESSAGE"));
		add(messagePanel);
		
		menuBasePanel = new JPanel();
		menuBasePanel.setBackground(Color.white);
		menuBasePanel.setBounds(5,510,700,195);
		menuBasePanel.setLayout(null);
		menuBasePanel.setBorder(BorderFactory.createLineBorder(Color.pink));
		add(menuBasePanel);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.white);
		menuPanel.setBounds(10,10,350,175);
		menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		menuPanel.setLayout(new GridLayout(2, 4));
		menuBasePanel.add(menuPanel);
		
		btnMenuArray = new JButton[8]; // 배열 생성
		for (int i = 0; i<8; i++)
		{
			btnMenuArray[i] = new JButton(SimplePainterConstants.MENU[i]);
			btnMenuArray[i].setBackground(SimplePainterConstants.MENU_COLOR[0]);
			btnMenuArray[i].setForeground(SimplePainterConstants.MENU_COLOR[1]);
			menuPanel.add(btnMenuArray[i]);
		}
		
		optionPanel = new JPanel();
		optionPanel.setBackground(Color.white);
		optionPanel.setBounds(370,10,320,175);
		optionPanel.setBorder(BorderFactory.createTitledBorder("OPTION"));
		optionPanel.setLayout(null);
		menuBasePanel.add(optionPanel);
		
		lblSizeNWidth = new JLabel("SIZE");
		lblSizeNWidth.setBounds(20,20,40,20);
		optionPanel.add(lblSizeNWidth);
		
		txtSizeNWidth = new JTextField();
		txtSizeNWidth.setBounds(65,20,40,20);
		optionPanel.add(txtSizeNWidth);
		
		btnColor = new JButton("COLOR");
		btnColor.setBounds(20,50,100,50);
		optionPanel.add(btnColor);
		
		chkFill = new JCheckBox("FILL");
		chkFill.setBackground(Color.white);
		chkFill.setBounds(20,110,60,40);
		optionPanel.add(chkFill);
	}
	
	public void addMenuButtonListener(ActionListener listener)
	{
		for(int i=0; i<8; i++)
		{
			btnMenuArray[i].addActionListener(listener);
		}
	}
	
	public void addMouseListener(MouseListener listener)
	{
		for(int i=0; i<8; i++)
		{
			btnMenuArray[i].addMouseListener(listener);
		}
	}
	
	public void addColorButtonListener(ActionListener listener)
	{
		btnColor.addActionListener(listener);
	}
	
	public void setVisibleAllOptionComponents(boolean flag)
	{
		lblSizeNWidth.setVisible(flag);
		txtSizeNWidth.setVisible(flag);
		btnColor.setVisible(flag);
		chkFill.setVisible(flag);
	}
}
