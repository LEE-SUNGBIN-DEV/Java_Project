package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

import javax.swing.ImageIcon;

import View.OrchardView;

public final class ResourceData {
	
	// startView
	public static Image backgroundBufferedImage = new ImageIcon("./res/img/backgroundImage.jpg").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
	public static Image title = new ImageIcon("./res/img/startView/OrchardTitle.png").getImage().getScaledInstance(400, 100, Image.SCALE_SMOOTH);
	public static Image titleBackground = new ImageIcon("./res/img/startView/OrchardTitleBackground.png").getImage().getScaledInstance(420, 120, Image.SCALE_SMOOTH);
    public static Image loginWindow = new ImageIcon("./res/img/startView/loginWindow.png").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);;
	public static Image registerButtonImage = new ImageIcon("./res/img/startView/registerbtn.png").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
	public static Image helpButtonImage = new ImageIcon("./res/img/startView/helpbtn.png").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
	
	// processView
	public static Image processBufferedImage = new ImageIcon("./res/img/gameView/processGameScreen.png").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH - 120, OrchardView.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
	public static Image gameBoardBufferedImage = new ImageIcon("./res/img/gameView/gameBoard.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);

	public static Image appleImg = new ImageIcon("./res/img/fruits/apple.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image bananaImg = new ImageIcon("./res/img/fruits/banana.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image lemonImg = new ImageIcon("./res/img/fruits/lemon.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image orangeImg = new ImageIcon("./res/img/fruits/orange.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image pearImg = new ImageIcon("./res/img/fruits/pear.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

	public static Image appleHintImg = new ImageIcon("./res/img/fruits/appleHint.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image bananaHintImg = new ImageIcon("./res/img/fruits/bananaHint.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image lemonHintImg = new ImageIcon("./res/img/fruits/lemonHint.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image orangeHintImg = new ImageIcon("./res/img/fruits/orangeHint.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static Image pearHintImg = new ImageIcon("./res/img/fruits/pearHint.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	// settingView
	
	
	private static BufferedImage imageToBufferedImage(Image image) {

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();

		return bufferedImage;

	}

	public static Image makeColorTransparent(BufferedImage im, final Color color) {
		ImageFilter filter = new RGBImageFilter() {

			// the color we are looking for... Alpha bits are set to opaque
			public int markerRGB = color.getRGB() | 0xFF000000;

			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					// Mark the alpha bits as zero - transparent
					return 0x00FFFFFF & rgb;
				} else {
					// nothing to do
					return rgb;
				}
			}
		};

		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}
}
