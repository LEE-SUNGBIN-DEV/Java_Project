package practice2;

import org.lwjgl.opengl.Display;
import static practice2.Manager.*;

public class Boot {
	
	
	
	
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
