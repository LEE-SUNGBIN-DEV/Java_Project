package Model;

import java.util.Random;

public class TileGrid {
	
	public Tile[][] grid;
	public static int WIDTH = 4;
	public static int HEIGHT = 4;

	private Random random = new Random();
	private int random_number;
	private int[][] intGrid;
	
	public TileGrid()
	{
		// create random map
		grid = new Tile[HEIGHT][WIDTH];
		intGrid = new int[HEIGHT][WIDTH];
		for(int i = 1; i < grid.length-1; i++)
		{
			for(int j = 1; j < grid[i].length-1; j++)
			{
				random_number = random.nextInt(2);
				switch(random_number)
				{
				case 0:
					grid[i][j] = new Tile(j*64, i*64, 64, 64, TileType.Grapes);
					intGrid[i][j] = 0;
					break;
				case 1:
					grid[i][j] = new Tile(j*64, i*64, 64, 64, TileType.Lemon);
					intGrid[i][j] = 1;
				}
			}
		}
	}
	
	public Tile GetTile(int xCoord, int yCoord) 
	{
		return grid[xCoord][yCoord];
	}
	
	public int[][] getIntGird()
	{
		return intGrid;
	}

	// move from (x, y) to (x2, y2)
	public void move(int x, int y, int x2, int y2)
	{
		
	}
}
