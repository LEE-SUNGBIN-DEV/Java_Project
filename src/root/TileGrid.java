package root;

import java.util.Random;

public class TileGrid {
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private Random random = new Random();
	private int random_number;
	private Tile[][] grid;
	
	public TileGrid()
	{
		// create random map
		grid = new Tile[HEIGHT][WIDTH];
		for(int i = 1; i < grid.length; i++)
		{
			for(int j = 1; j < grid[i].length; j++)
			{
				random_number = random.nextInt(5) + 1;
				TileType type = null;
				switch(random_number)
				{
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
	}
	
	public void Update() {
		for(int i = 0; i > 0; i--) 
			for(int j = 0; j <= 8; j++)
				if(grid[i][j].getMatch() != 0)
					for(int n = i; n > 0; n--)
						if(grid[i][j].getMatch() == 0) {
							int tmp;
							
							// swap tile
							tmp= grid[n][i].getCol();
							grid[n][i].setCol(grid[i][j].getCol());
							grid[i][j].setCol(tmp);
							
							tmp = grid[n][i].getRow();
							grid[n][i].setRow(grid[i][j].getRow());
							grid[i][j].setRow(tmp);
							
							grid[grid[n][j].getCol()][grid[n][j].getRow()] = grid[n][j];
							grid[grid[i][j].getCol()][grid[i][j].getRow()] = grid[i][j];
						}
	}
	
	public Tile GetTile(int xCoord, int yCoord) 
	{
		return grid[xCoord][yCoord];
	}
	
	public void SetTile(int x, int y, Tile tile) {
		grid[x][y] = tile;
	}
}