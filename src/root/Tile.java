package root;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {

	public static final int tileSize = 42;
	private int x, y;
	private int col, row;
	private int match;
	private float alpha;
	private TileType type;
	private Image image;
	private BufferedImage bi;
	
	public int getMatch() {
		return match;
	}

	public void setMatch(int match) {
		this.match = match;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public Tile(int i, int j, TileType type)
	{
		this.type = type;
		try {
			bi = ImageIO.read(new File(type.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = bi.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		col = i;
		row = j;
		x = i * tileSize;
		y = j * tileSize;
		alpha = 1.0f;
		match = 0;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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

	public int getTileSize() {
		return tileSize;
	}
	

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
}
