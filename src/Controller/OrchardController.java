package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

<<<<<<< HEAD
	
import javax.swing.JOptionPane;

import Model.ResourceData;
=======
import Model.ImageData;
import Model.Match;
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87
import Model.Music;
import Model.TileGrid;
import View.GameBoardPanel;
import View.OrchardView;

public class OrchardController {

	private OrchardView _orchardView;
	private GameBoardPanel _gameBoard;
	private Music backgroundMusic;
	
	private TileGrid grid;
	private Bejeweled bejeweled;
	private Thread bejeweledThread;
	private boolean _functionProcessing;
	
	private ImageData imgData;
	
	public OrchardController() {
		
<<<<<<< HEAD
		backgroundMusic = new Music("BackgroundMusic.mp3", true);
		backgroundMusic.start();
=======
		imgData = new ImageData();
>>>>>>> f4f27b75aea66a5b74ef9f9e59390b6b30261a87
		_orchardView = new OrchardView();
		_orchardView.addStartbtnListener(new startbtnListener());
		_orchardView.addExitbtnListener(new exitbtnListener());
		
		try {
			AuthAPI.connectDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	// 게임 시작화면으로 전환, 배경음악 전환 및 타이머 스타트
	public void gameStart() {

			grid = new TileGrid();

			bejeweled = new Bejeweled(grid);
			bejeweledThread = new Thread(bejeweled);
			
			_gameBoard = new GameBoardPanel(grid);
			_gameBoard.addGameListener(new gameListener());
			_orchardView.changeToGameView(_gameBoard);
			bejeweledThread.start();
			
			backgroundMusic.close();
			backgroundMusic = new Music("ProcessGameMusic.mp3", true);
			backgroundMusic.start();
	}
		
	public void endGame() {
		
		grid = null;
		
		// singleton 활용방안 모색
		_gameBoard = null;
		_orchardView.changeToLoginView();
		
		backgroundMusic.close();
		backgroundMusic = new Music("BackgroundMusic.mp3", true);
		backgroundMusic.start();
	}
	
	private class gameListener implements MouseListener {
		@Override
		public void mousePressed(MouseEvent e) {
			// when bejeweled function isn't processing
			_functionProcessing = bejeweled.functionProcessing;
			System.out.println(_functionProcessing);
			if(!_functionProcessing) {
				grid.addClickCount();
				grid.clickCheck(e.getPoint());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}
	
	private class startbtnListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			boolean isValid;
//			isValid = _orchardView.checkValid();
//			if(isValid) {
				JOptionPane.showMessageDialog(_orchardView,"Do you want to Start game?!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
				gameStart();
//			} else {
//				JOptionPane.showMessageDialog(_orchardView,"Please check your ID or Password!", "Login Failed", JOptionPane.INFORMATION_MESSAGE);
//			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
	private class exitbtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(1);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}
}
