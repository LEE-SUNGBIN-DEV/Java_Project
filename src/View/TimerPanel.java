package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class TimerPanel extends JPanel 
{
	private JLabel 		timerLabel;
	private Thread 		th;
	private TimerThread lblMark;
	private JPanel		btnPanel;
	private JButton		btnStart;
	private JButton	 	btnPause;
	public  boolean		process;
	
	//private JLabel lblMark;
	
	private ButtonListener btnListener;
	
	// Constructor
	public TimerPanel() 
	{
		setPreferredSize(new Dimension(190,180));
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		process = false;
		btnListener = new ButtonListener();
		
		timerLabel = new JLabel("Timer");
		timerLabel.setForeground(Color.black);
		timerLabel.setFont(new Font("Bauhaus 93",Font.BOLD,30));
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(timerLabel, BorderLayout.NORTH);
		
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.white);
		add(btnPanel, BorderLayout.SOUTH);
		
		btnStart = new JButton("START");
		btnStart.addActionListener(btnListener);
		btnStart.setBackground(Color.lightGray);
		btnStart.setForeground(Color.white);
		btnPanel.add(btnStart);
		
		btnPause = new JButton("PAUSE");
		btnPause.addActionListener(btnListener);
		btnPause.setBackground(Color.LIGHT_GRAY);
		btnPause.setForeground(Color.white);
		btnPanel.add(btnPause);
		
		lblMark = new TimerThread("00:00");
		lblMark.setBounds(20,100,130,40);
		lblMark.setFont(new Font("Verdana",Font.ITALIC,30));
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMark);
		
		th = new Thread(lblMark, "timerThread");
		
		th.start();
	}
	

	// Button Listener
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Object obj = e.getSource();
			
			if(obj == btnStart)
			{
				if(process == false)
				{
					lblMark.resume();
					lblMark.setStart(60,99);
					lblMark.setSleepTime(1000, 10);
				}
				else
				{
					lblMark.resume();
				}
			}
			if(obj == btnPause) 
			{
				lblMark.suspend();
			}
		}
		
	}
}
