package Test;

import static java.lang.Math.abs;

public class Calculator {
	
	public static  void swapTileInfo(Tile[][] grid, int x, int y, int x0, int y0) {
		Tile tmpTile;
		int tmp;

		tmp = grid[x][y].getCol();
		grid[x][y].setCol(grid[x0][y0].getCol());
		grid[x0][y0].setCol(tmp);
		
		tmp = grid[x][y].getRow();
		grid[x][y].setRow(grid[x0][y0].getRow());
		grid[x0][y0].setRow(tmp);
		
		tmpTile = grid[x][y];
		grid[x][y] = grid[x0][y0];
		grid[x0][y0] = tmpTile;
	}
	
	
	public void secondSwap() {
		
	}
}
