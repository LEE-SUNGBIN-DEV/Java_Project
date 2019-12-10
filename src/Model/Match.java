package Model;

import static java.lang.Math.abs;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Match implements Runnable {
	private int combo;
	private TileGrid grid;
	private Timer timer;
	private boolean hintFlag;
	private Random random = new Random();
	private int score;
	private boolean stop;

	public Match(TileGrid grid) {
		this.grid = grid;
		combo = 0;
		score = 0;
		stop = false;

		timer = new Timer();
	}

	public int getTotalTime() {
		return timer.getTotalTime();
	}

	public void run() {
		while(!stop) {
			
			score = 0;
			checkMatch();
			
//			if(score == 0 && (grid.getIsSwap() == false)) {
//				System.out.println("1");
//				movingAnimation();
//				
//			}
			
			if(score > 0 && (grid.getIsSwap() == false)) {
				System.out.println("2");
				movingAnimation();
				deleteAnimation();
				updateGrid();	
			}

			else if(score > 0 && (grid.getIsSwap() == true)) {
				System.out.println("3");
				movingAnimation();
				deleteAnimation();
				updateGrid();
				grid.setIsSwap(false);
				
			}

			else if(score == 0 && (grid.getIsSwap() == true)) {
				System.out.println("4");
				movingAnimation();
				secondSwap();
				movingAnimation();
				grid.setIsSwap(false);
				
			}
			
			
		}//while
	}// run

	public void checkMatch() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 6; j++) {
				// 세로줄의 검사
				if (i != 8 && grid.GetTile(i,j).getType() == grid.GetTile(i+1, j).getType()) {
					if (i != 1 && grid.GetTile(i,j).getType() == grid.GetTile(i-1, j).getType()) {

						for (int n = -1; n <= 1; n++) {
							grid.GetTile(i+n, j).setMatch(grid.GetTile(i+n, j).getMatch()+1);
							score++;
						}
					}
				}

				// 가로줄의 검사
				if (j != 6 && grid.GetTile(i, j).getType() == grid.GetTile(i, j+1).getType()) {
					if (j != 1 && grid.GetTile(i, j).getType() == grid.GetTile(i, j-1).getType()) {

						for (int n = -1; n <= 1; n++) {
							grid.GetTile(i, j+n).setMatch(grid.GetTile(i, j+n).getMatch()+1);
							score++;
						}
					}
				}
			}
		}
	}

	public void deleteAnimation() {
		try {
			for(int cnt = 0; cnt < 125; cnt++) {
				for (int i = 1; i <= 8; i++) {
					for (int j = 1; j <= 6; j++) {
						Tile t = grid.GetTile(i, j);
						if (t.getMatch() >= 1) {
							if (t.getAlpha() >= 0.008f) {
								t.setAlpha(t.getAlpha() - 0.008f);
							}
						}
					}
				}
				Thread.sleep(3);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void movingAnimation() {
		try {
			for(int cnt = 0; cnt<50; cnt++) {
				for (int i = 1; i <= 8; i++) {
					for (int j = 1; j <= 6; j++) {
						Tile t = grid.GetTile(i, j);
						int tx, ty;
						int dx, dy;
						tx = t.getX();
						ty = t.getY();

						dx = tx - t.getCol() * Tile.tileSize;
						dy = ty - t.getRow() * Tile.tileSize;
						if (dx != 0) {
							t.setX(tx - dx / abs(dx));
						}
						if (dy != 0) {
							t.setY(ty - dy / abs(dy));
						}
					}
				}
				Thread.sleep(3);
			}

		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void updateGrid() {
		int updateColCount = 0;
		
		for (int i = 8; i > 0; i--) {
			for (int j = 1; j <= 6; j++) {
				if (grid.GetTile(i, j).getMatch()>=1) {
					for (int n = i; n > 0; n--) {
						if (grid.GetTile(n, j).getMatch() == 0) {

							Calculator.swapTileInfo(grid.getGrid(), n, j,  i, j);
							break;
						}
					}
				}
			}
		}
		
		for (int j = 1; j <= 6; j++) {
			for (int i = 8, n = 0; i > 0; i--) {
				if (grid.GetTile(i, j).getMatch()>=1) {
					int randomNumber = random.nextInt(5) + 1;
					switch(randomNumber)
					{
					case 1:
						grid.GetTile(i, j).setType(TileType.Banana);
						break;
					case 2:
						grid.GetTile(i, j).setType(TileType.Grapes);
						break;
					case 3:
						grid.GetTile(i, j).setType(TileType.Lemon);
						break;
					case 4:
						grid.GetTile(i, j).setType(TileType.Orange);
						break;
					case 5:
						grid.GetTile(i, j).setType(TileType.Pear);
						break;
					}

					try {
						grid.GetTile(i, j).setBi(ImageIO.read(new File(grid.GetTile(i, j).getType().getPath())));
					} catch (IOException e) {
						e.printStackTrace();
					}
					grid.GetTile(i, j).setImage(grid.GetTile(i, j).getBi().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
					grid.GetTile(i, j).setY(-50 * n++); // tilesize = 50
					if(updateColCount < n) updateColCount = n;
					grid.GetTile(i, j).setMatch(0);
					grid.GetTile(i, j).setAlpha(1.0f);
				}
			}
		}
		
		for(int i = 0; i<updateColCount; i++)
			movingAnimation();
	}


	public void secondSwap() {
		Calculator.swapTileInfo(grid.getGrid(), grid.getY0(), grid.getX0(), grid.getY(), grid.getX());
	}

	public void stop() {
		this.timer.stop();
		this.stop = false;
	}
}
