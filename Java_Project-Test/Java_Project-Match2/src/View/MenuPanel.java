package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MenuPanel extends JPanel 
{
	private final int  WIDTH  = 200;
	private final int  HEIGHT = 720;
	private TimerPanel timer;
	
	public MenuPanel()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.CYAN);
		
		timer = new TimerPanel();
		add(timer);
	}

}
