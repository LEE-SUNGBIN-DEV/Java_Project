package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

import View.OrchardView;

public final class ImageData {
	// ProcessGameView
	private static Image backgroundBufferedImage2 = new ImageIcon("./img/Background2.jpg").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH, OrchardView.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
	private static Image processBufferedImage = new ImageIcon("./img/ProcessGameScreen.png").getImage().getScaledInstance(OrchardView.SCREEN_WIDTH - 120, OrchardView.SCREEN_HEIGHT - 80, Image.SCALE_SMOOTH);
	private static Image gameBoardBufferedImage = new ImageIcon("./img/Texture.png").getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
	private static Image loginWindow = new ImageIcon("./img/trans.PNG").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);;
	private static Image registerButtonImage = new ImageIcon("./img/registerbtn.png").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
	private static Image helpButtonImage = new ImageIcon("./img/helpbtn.jpg").getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH);
	private static Image title = new ImageIcon("./img/OrchardTitle.png").getImage().getScaledInstance(400, 100, Image.SCALE_SMOOTH);
	private static Image titleBackground = new ImageIcon("./img/OrchardTitleBackground.png").getImage().getScaledInstance(420, 120, Image.SCALE_SMOOTH);
    
	//
	
	public ImageData() {
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
