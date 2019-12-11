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

public class TileGrid {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 10;

	
	private Random random = new Random();
	private int random_number;
	private Tile[][] grid;
	private int x, y;
	private int x0, y0;
	private int click;
	private Image img;
	private double deleteCheck;
	private int deleteCnt;
	
	private boolean isSwap;
	
	private Timer _gameTimer;
	
	public TileGrid() {
		
		click = 0;
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
					img = Model.ResourceData.bananaImg;
					break;
				case 2:
					type = TileType.Apple;
					img = Model.ResourceData.appleImg;
					break;
				case 3:
					type = TileType.Lemon;
					img = Model.ResourceData.lemonImg;
					break;
				case 4:
					type = TileType.Orange;
					img = Model.ResourceData.orangeImg;
					break;
				case 5:
					type = TileType.Pear;
					img = Model.ResourceData.pearImg;
					break;
				}
				grid[i][j] = new Tile(i, j, type, img);
			}
		}
	}

	public void clickCheck(Point pos) {
		
		// mouse click
		if (click == 1) {
			// xÁÂÇ¥´Â ¿­*size
			// yÁÂÇ¥´Â Çà*size
			x0 = pos.x / Tile.tileSize;
			y0 = pos.y / Tile.tileSize;
		}
		if (click == 2) {
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
		if(click > 3) {
			x0 = x;
			y0 = y;
			click = 1;
		}
	}
	
	public void addClickCount() {
		click++;
		System.out.println(click);
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