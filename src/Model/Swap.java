package Model;

public class Swap {
	

	public static void swapTile(int x, int y, int x2, int y2, TileGrid map)
	{
		boolean isStable;
		boolean isRollback = false;
		
		if(x2 < 0 || y2 < 0 || x2 >= TileGrid.WIDTH || y2 >= TileGrid.HEIGHT) return;
		
		map.move(x, y, x, y2);
		map.move(x2,  y2, x, y);
		
		isStable = isRollback;
		
		
	}
	
	
	void moveDone()
	{
		
	}
}
