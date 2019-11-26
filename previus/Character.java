package practice2;

import static practice2.Manager.*;
import org.newdawn.slick.opengl.Texture;

public class Character {
	
	private float x, y, width, height;
	private float speed;
	private Texture fileName;
	private Tile startTile;
	
	public Character(Texture fileName, Tile startTile, float width, float height, float speed) {
		this.fileName = fileName;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public void Draw() {
		DrawQuadTex(fileName, x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
