package Model;

import static java.lang.Math.abs;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

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

	public static void matchCheck(TileGrid grid) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 6; j++) {
				// 세로줄의 검사
				if (i != 8 && grid.GetTile(i,j).getType() == grid.GetTile(i+1, j).getType()) {
					if (i != 1 && grid.GetTile(i,j).getType() == grid.GetTile(i-1, j).getType()) {

						for (int n = -1; n <= 1; n++) {
							grid.GetTile(i+n, j).setMatch(true);
						}
					}
				}

				// 가로줄의 검사
				if (j != 6 && grid.GetTile(i, j).getType() == grid.GetTile(i, j+1).getType()) {
					if (j != 1 && grid.GetTile(i, j).getType() == grid.GetTile(i, j-1).getType()) {

						for (int n = -1; n <= 1; n++) {
							grid.GetTile(i, j+n).setMatch(true);
						}
					}
				}
			}
		}
	}
	
	public static void matchCheck(TileGrid grid, Timer timer)
	{
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 6; j++) {
				// 세로줄의 검사
				if (i != 8 && grid.GetTile(i,j).getType() == grid.GetTile(i+1, j).getType()) {
					if (i != 1 && grid.GetTile(i,j).getType() == grid.GetTile(i-1, j).getType()) {
													
						for (int n = -1; n <= 1; n++) {
							grid.GetTile(i+n, j).setMatch(true);
						}
						timer.getCurrentTime();
					}
				}

				// 가로줄의 검사
				if (j != 6 && grid.GetTile(i, j).getType() == grid.GetTile(i, j+1).getType()) {
					if (j != 1 && grid.GetTile(i, j).getType() == grid.GetTile(i, j-1).getType()) {

						for (int n = -1; n <= 1; n++) {
							grid.GetTile(i, j+n).setMatch(true);
						}
						timer.getCurrentTime();
					}
				}
			}
		}
	}
	
	public static void secondSwap(TileGrid grid) {
		//second Swap : 매치 되지 않았다면 역스왑
		int score = 0;
		for (int i=1;i<=8;i++) {
			for (int j=1;j<=6;j++) {
				if(grid.GetTile(i, j).getMatch() == true) {
					score ++;
				}
			}
		}

		if (grid.isSwap() == true) {
			if (score == 0) {
				swapTileInfo(grid.getGrid(), grid.getY0(), grid.getX0(), grid.getY(), grid.getX());
			}
		}
		grid.setSwap(false);
	}
	
	

	public static void updateGrid(TileGrid grid)
	{
		Random random = new Random();
		////updateGrid
		for (int i = 8; i > 0; i--) {
			for (int j = 1; j <= 6; j++) {
				if (grid.GetTile(i, j).getMatch() == true) {
					for (int n = i; n > 0; n--) {
						if (grid.GetTile(n, j).getMatch() == false) {

							Calculator.swapTileInfo(grid.getGrid(), n, j,  i, j);
							break;
						}
					}
				}
			}
		}


		for (int j = 1; j <= 6; j++) {
			for (int i = 8, n = 0; i > 0; i--) {
				if (grid.GetTile(i, j).getMatch() == true) {
					int randomNumber = random.nextInt(5) + 1;
					switch(randomNumber)
					{
					case 1:
						grid.GetTile(i, j).setType(TileType.Banana);
						break;
					case 2:
						grid.GetTile(i, j).setType(TileType.Grapes);
						break;
					case 3:
						grid.GetTile(i, j).setType(TileType.Lemon);
						break;
					case 4:
						grid.GetTile(i, j).setType(TileType.Orange);
						break;
					case 5:
						grid.GetTile(i, j).setType(TileType.Pear);
						break;
					}

					try {
						grid.GetTile(i, j).setBi(ImageIO.read(new File(grid.GetTile(i, j).getType().getPath())));
					} catch (IOException e) {
						e.printStackTrace();
					}
					grid.GetTile(i, j).setImage(grid.GetTile(i, j).getBi().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
					grid.GetTile(i, j).setY(-50 * n++); // tilesize = 50
					grid.GetTile(i, j).setMatch(false);
					grid.GetTile(i, j).setAlpha(1.0f);
				}
			}
		}
	}
}
