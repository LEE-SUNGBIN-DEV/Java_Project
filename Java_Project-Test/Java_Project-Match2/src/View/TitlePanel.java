package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel
{
	private JLabel 	  title;
	private Font	  titleFont;
	private final int WIDTH  = 720;
	private final int HEIGHT = 70;
	
	public TitlePanel()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.yellow);
	
		titleFont = new Font("Bauhaus 93", Font.BOLD, 50);
		title = new JLabel("Orchard");
		title.setForeground(new Color(20, 20, 255, 200));
		title.setFont(titleFont);
		add(title);
	}
	
}
