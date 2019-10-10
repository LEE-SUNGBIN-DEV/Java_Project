package practice2;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

public class Boot {
	
	public static final int WIDTH = 960, HEIGHT = 960;
	
	public static void BeginSession() {
		Display.setTitle("Orchard Test...");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	
	public static void DrawQuad(float x, float y, float width, float height) {
		glBegin(GL_QUADS);	// CeateBox
		glVertex2f(x, y); // Top Left Corner
		glVertex2f(x+width, y); // Top Right Corner
		glVertex2f(x+width, y+height); // Bottom Right Corner
		glVertex2f(x, y+height); // Bottom Left Corner
		glEnd();			// CreateBox
	}
	
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity(); // what is this method?
	}
	
	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}
	
	public static Texture QuickLoad(String name) {
		Texture tex = null;
		tex = LoadTexture("./img/" + name + ".png", "PNG");
		
		return tex;
	}
	
	public Boot() { 
			
		BeginSession();
		
		//Texture t1 = LoadTexture("./img/testTile.png", "PNG");
		//Texture t2 = LoadTexture("./img/testTile.png", "PNG");
		//Texture t1 = QuickLoad("testTile");
		//Texture t2 = QuickLoad("testTile");
		//Tile tile1 = new Tile(0, 0, 64, 64, TileType.Dirt);
		//Tile tile2 = new Tile(0, 64, 64, 64, TileType.Dirt);
	
		Tile tile[] = new Tile[225];
		float tileX = 0;
		float tileY = 0;
		for(int i = 0; i < 225; i++) {
			if(i%15 == 0 && i != 0) {
				tileY += 64;
				tileX = 0;
			}
			tile[i] = new Tile(tileX, tileY, 64, 64, TileType.Dirt);
			tileX += 64;
		}
		while(!Display.isCloseRequested()) {
		
			//DrawQuadTex(tile1.getTexture(), tile1.getX(), tile1.getY(), tile1.getWidth(), tile1.getHeight());
			//DrawQuadTex(tile2.getTexture(), tile2.getX(), tile2.getY(), tile2.getWidth(), tile2.getHeight());
			
			for(int i = 0; i < 225; i++) {
				DrawQuadTex(tile[i].getTexture(), tile[i].getX(), tile[i].getY(), tile[i].getWidth(), tile[i].getHeight());
			}
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy(); 
	}


	
	public static void main(String[] args) {
		new Boot();
	}
}
