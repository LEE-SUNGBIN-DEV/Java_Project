package Model;

import static java.lang.Math.abs;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TileGrid implements Runnable {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 10;

	
	private Random random = new Random();
	private int random_number;
	private Tile[][] grid;
	private int x, y;
	private int x0, y0;
	private int click =0;
	
	private double deleteCheck;
	private int deleteCnt;
	
	private boolean isMoving;
	private boolean isAnimating;
	private boolean isSwap;
	
	private Timer _gameTimer;
	
	public TileGrid() {
		
		deleteCheck = 1;
		deleteCnt = 0;
		
		// create random map
		grid = new Tile[HEIGHT][WIDTH];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				random_number = random.nextInt(5) + 1;
				TileType type = null;
				switch (random_number) {
				case 1:
					type = TileType.Banana;
					break;
				case 2:
					type = TileType.Grapes;
					break;
				case 3:
					type = TileType.Lemon;
					break;
				case 4:
					type = TileType.Orange;
					break;
				case 5:
					type = TileType.Pear;
					break;
				}
				grid[i][j] = new Tile(i, j, type);
			}
		}
		Thread gridThread = new Thread(this);
		gridThread.start();
	}

	public void clickCheck(Point pos) {

		// mouse click
		if (click == 1) {
			// x좌표는 열*size
			// y좌표는 행*size
//			timer.getCurrentTime();
			x0 = pos.x / Tile.tileSize;
			y0 = pos.y / Tile.tileSize;
		}
		if (click == 2) {
//			timer.getCurrentTime();
			x = pos.x / Tile.tileSize;
			y = pos.y / Tile.tileSize;
			if (abs(x - x0) + abs(y - y0) == 1) {
				Calculator.swapTileInfo(grid, y, x, y0, x0);
				isSwap = true;
				click = 0;
			} else {
				x0 = x;
				y0 = y;
				click = 1;
			}
		}
	}
	
	public void addCheckCount() {
		if (!isSwap && !isMoving)
			click++;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				
				// moving animaion
				isAnimating = true;
				isMoving = false;
				for (int i = 1; i <= 8; i++) {
					for (int j = 1; j <= 6; j++) {
						Tile t = grid[i][j];
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
						if (dx != 0 || dy != 0) {
							isMoving = true;
						}
					}
				}

				// delete animation
				if (isMoving == false) {
					
					for (int i = 1; i <= 8; i++) {
						for (int j = 1; j <= 6; j++) {
							Tile t = grid[i][j];
							if (t.getMatch() >= 1) {
								
								if (t.getAlpha() >= 0.008f) {
									t.setAlpha(t.getAlpha() - 0.008f);
									isMoving = true;
								}
								
								if (t.getAlpha() == 0.000f)
								{
									isMoving = true;
								}
							}
						}
					}
					
					if(isMoving == true) {
						
						if(deleteCheck >= 0.008) {
							deleteCheck = deleteCheck - 0.008;
						}
						
						if(deleteCheck <= 0.008) {
							Music removeSound = new Music("removeSound.mp3", false);
							removeSound.start();
							deleteCnt++;
							System.out.println("delete : " + deleteCnt);
							deleteCheck = 1;
						}
					}
				}

				if (isMoving == false)
					isAnimating = false; // 무빙이 없다면 애니메이팅 종료를 알림 -> Match 쓰레드에서 기능 실행
				Thread.sleep(3);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public boolean isSwap() {
		return isSwap;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public boolean isAnimating() {
		return isAnimating;
	}

	public void setAnimating(boolean isAnimating) {
		this.isAnimating = isAnimating;
	}

	public Tile[][] getGrid() {
		return grid;
	}

	public void setSwap(boolean isSwap) {
		this.isSwap = isSwap;
	}

	public Tile GetTile(int xCoord, int yCoord) {
		return grid[xCoord][yCoord];
	}

	public void SetTile(int x, int y, Tile tile) {
		grid[x][y] = tile;
	}
}