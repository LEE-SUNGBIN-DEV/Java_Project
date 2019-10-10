package practice2;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import static practice2.Manager.*;
public class Boot {	
	
	private Character tmpChar;
	
	public Boot() { 
			
		BeginSession();
		
		//Texture t1 = LoadTexture("./img/testTile.png", "PNG");
		//Texture t2 = LoadTexture("./img/testTile.png", "PNG");
		//Texture t1 = QuickLoad("testTile");
		//Texture t2 = QuickLoad("testTile");
		//Tile tile1 = new Tile(0, 0, 64, 64, TileType.Dirt);
		//Tile tile2 = new Tile(0, 64, 64, 64, TileType.Dirt);
	
		int map[][] = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		TileGrid grid = new TileGrid(map);
		
		// 캐릭터 초기생성
		tmpChar = new Character(QuickLoad("character"), grid.map[10][10], 64, 64, 10);
		
		while(!Display.isCloseRequested()) {
			
			//DrawQuadTex(tile1.getTexture(), tile1.getX(), tile1.getY(), tile1.getWidth(), tile1.getHeight());
			//DrawQuadTex(tile2.getTexture(), tile2.getX(), tile2.getY(), tile2.getWidth(), tile2.getHeight());
			
			// 맵 생성 후 loop문 안에서 반드시 Draw() 메소드를 호출해줘야함
			grid.Draw();
			tmpChar.Draw();
			
			pollInput();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy(); 
	}


	public void pollInput() {
	        
	    if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
	        System.out.println("SPACE KEY IS DOWN");
	    }
	         
	    while (Keyboard.next()) {
	    	//Key Pressed Event
	        if (Keyboard.getEventKeyState()) {
	            if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
	            	System.out.println("Up Key Pressed");
	            	tmpChar.setY(tmpChar.getY() - tmpChar.getSpeed());
	            }
		        if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
		            System.out.println("Down Key Pressed");
		            tmpChar.setY(tmpChar.getY() +	 tmpChar.getSpeed());
		        }
		        if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
		            System.out.println("Left Key Pressed");
		            tmpChar.setX(tmpChar.getX() - tmpChar.getSpeed());
		        }
		        if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
		        	System.out.println("Right Key Pressed");
		        	tmpChar.setX(tmpChar.getX() + tmpChar.getSpeed());
		        }
		    }
	        // Key Released Event
	        /*else {
	        	if (Keyboard.getEventKey() == Keyboard.KEY_A) {
	        		System.out.println("A Key Released");
		        }
		        if (Keyboard.getEventKey() == Keyboard.KEY_S) {
		          	System.out.println("S Key Released");
		        }
		        if (Keyboard.getEventKey() == Keyboard.KEY_D) {
		        	System.out.println("D Key Released");
		        }
	        }*/
	    }
    }
	
	public static void main(String[] args) {
		new Boot();
	}
}
