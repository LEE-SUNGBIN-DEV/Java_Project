package View;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.ResourceData;

@SuppressWarnings("serial")
public class StartView extends JPanel {

//	private Image backgroundBufferedImage;
//	private Image loginWindow;
//	private Image registerButtonImage;
//	private Image helpButtonImage;
//	private Image title;
//	private Image titleBackground;
	
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton startbtn;

	private JButton exitbtn;

	public StartView() {

		setSize(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT);
		setLayout(null);
		
//        title = new ImageIcon("./img/OrchardTitle.png").getImage().getScaledInstance(400, 100, Image.SCALE_SMOOTH);
//		titleBackground = new ImageIcon("./img/OrchardTitleBackground.png").getImage().getScaledInstance(420, 120, Image.SCALE_SMOOTH);
//        loginWindow = new ImageIcon("./img/trans.PNG").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
//		backgroundBufferedImage = new ImageIcon("./img/Background2.jpg").getImage()
//				.getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
//		registerButtonImage = new ImageIcon("./img/registerbtn.png").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
//		helpButtonImage = new ImageIcon("./img/helpbtn.jpg").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
		
		idField = new JTextField();
		idField.setOpaque(false);
		idField.setBounds(210, 330, 180, 23);
		JLabel idInputLabel = new JLabel();
		idInputLabel.setLayout(new BorderLayout());
		idInputLabel.add(idField);
		add(idField);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setBounds(210, 380, 180, 23);
		JLabel passwordInputLabel = new JLabel();
		passwordInputLabel.setLayout(new BorderLayout());
		passwordInputLabel.add(passwordField);
		add(passwordField);

		startbtn = new JButton();
		startbtn.setBounds(270, 440, 60, 30);
		startbtn.setOpaque(false);
		startbtn.setBorderPainted(false);
		startbtn.setFocusable(false);
		startbtn.setContentAreaFilled(false);
		add(startbtn);

		exitbtn = new JButton("exit");
		exitbtn.setBounds(520, 10, 70, 20);
		exitbtn.setBorderPainted(false);
		exitbtn.setFocusable(false);
		add(exitbtn);
	}


	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceData.backgroundBufferedImage, 0, 0, null);
		g.drawImage(ResourceData.titleBackground, 95, 105, null);
		g.drawImage(ResourceData.title, 100, 110, null);
		g.drawImage(ResourceData.registerButtonImage, 200, 500, null);
		g.drawImage(ResourceData.helpButtonImage, 300, 500, null);
		g.drawImage(ResourceData.loginWindow, 175, 230, null);
		paintComponents(g);

		this.repaint();
	}

	public void addStartbtnListener(MouseListener listener) {
		startbtn.addMouseListener(listener);
	}
	
	public void addExitbtnListner(MouseListener listener) {
		exitbtn.addMouseListener(listener);
	}
}
