package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

import View.OrchardView;

public final class ImageData {
	// ProcessGameView
	private static Image backgroundBufferedImage2;
	private static Image processBufferedImage;
	private static Image gameBoardBufferedImage;
	// LoginView
	//private Image backgroundBufferedImage; == ProcessGameView.backgroundBufferedImage
	private static Image loginWindow;
	private static Image registerButtonImage;
	private static Image helpButtonImage;
	private static Image title;
	private static Image titleBackground;
	//
	
	public ImageData() {
		// ProcessGameView
		backgroundBufferedImage2 = new ImageIcon("./img/Background2.jpg").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		processBufferedImage = new ImageIcon("./img/ProcessGameScreen.png").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH - 120, OrchardView.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
		gameBoardBufferedImage = new ImageIcon("./img/Texture.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		
		// LoginView
		title = new ImageIcon("./img/OrchardTitle.png").getImage().getScaledInstance(400, 100, Image.SCALE_SMOOTH);
		titleBackground = new ImageIcon("./img/OrchardTitleBackground.png").getImage().getScaledInstance(420, 120, Image.SCALE_SMOOTH);
        loginWindow = new ImageIcon("./img/trans.PNG").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		//backgroundBufferedImage = new ImageIcon("./img/Background2.jpg").getImage()
		//		.getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		registerButtonImage = new ImageIcon("./img/registerbtn.png").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
		helpButtonImage = new ImageIcon("./img/helpbtn.jpg").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
	}

	public static Image getBackgroundBufferedImage2() {
		return backgroundBufferedImage2;
	}

	public static void setBackgroundBufferedImage2(Image backgroundBufferedImage2) {
		ImageData.backgroundBufferedImage2 = backgroundBufferedImage2;
	}

	public static Image getProcessBufferedImage() {
		return processBufferedImage;
	}

	public static void setProcessBufferedImage(Image processBufferedImage) {
		ImageData.processBufferedImage = processBufferedImage;
	}

	public static Image getGameBoardBufferedImage() {
		return gameBoardBufferedImage;
	}

	public static void setGameBoardBufferedImage(Image gameBoardBufferedImage) {
		ImageData.gameBoardBufferedImage = gameBoardBufferedImage;
	}

	public static Image getLoginWindow() {
		return loginWindow;
	}

	public static void setLoginWindow(Image loginWindow) {
		ImageData.loginWindow = loginWindow;
	}

	public static Image getRegisterButtonImage() {
		return registerButtonImage;
	}

	public static void setRegisterButtonImage(Image registerButtonImage) {
		ImageData.registerButtonImage = registerButtonImage;
	}

	public static Image getHelpButtonImage() {
		return helpButtonImage;
	}

	public static void setHelpButtonImage(Image helpButtonImage) {
		ImageData.helpButtonImage = helpButtonImage;
	}

	public static Image getTitle() {
		return title;
	}

	public static void setTitle(Image title) {
		ImageData.title = title;
	}

	public static Image getTitleBackground() {
		return titleBackground;
	}

	public static void setTitleBackground(Image titleBackground) {
		ImageData.titleBackground = titleBackground;
	}
	
	

}
