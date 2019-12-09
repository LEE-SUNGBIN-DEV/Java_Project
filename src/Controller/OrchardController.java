package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.ImageData;
import Model.HintThread;
import Model.Music;
import Model.TileGrid;
import View.GameBoardPanel;
import View.OrchardView;

public class OrchardController {

	private OrchardView _orchardView;
	private GameBoardPanel _gameBoard;
	private Music backgroundMusic;
	
	private TileGrid grid;
	private HintThread match;
	private Thread matchThread;
	
	private ImageData imgData;
	
	public OrchardController() {
		
		imgData = new ImageData();
		_orchardView = new OrchardView();
		_orchardView.addStartbtnListener(new startbtnListener());
		_orchardView.addExitbtnListener(new exitbtnListener());
		
		backgroundMusic = new Music("BackgroundMusic.mp3", true);
		backgroundMusic.start();
	}
	
	
	// 게임 시작화면으로 전환, 배경음악 전환 및 타이머 스타트
	public void gameStart() {

			grid = new TileGrid();
			match = new HintThread(grid);
			matchThread = new Thread(match);
			matchThread.start();
			
			_gameBoard = new GameBoardPanel(grid);
			_gameBoard.addGameListener(new gameListener());
			_orchardView.changeToGameView(_gameBoard);

			backgroundMusic.close();
			backgroundMusic = new Music("ProcessGameMusic.mp3", true);
			backgroundMusic.start();
			
	}
		
	public void endGame() {
		
		grid = null;
		
		// singleton 활용방안 모색
		match.stop();
		match = null;
		
		_gameBoard = null;
		_orchardView.changeToLoginView();
		
		backgroundMusic.close();
		backgroundMusic = new Music("BackgroundMusic.mp3", true);
		backgroundMusic.start();
	}
	
	private class gameListener implements MouseListener {
		@Override
		public void mousePressed(MouseEvent e) {
			grid.addCheckCount();
			grid.clickCheck(e.getPoint());
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
		}

		@Override
		public void mousePressed(MouseEvent e) {
			gameStart();
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
