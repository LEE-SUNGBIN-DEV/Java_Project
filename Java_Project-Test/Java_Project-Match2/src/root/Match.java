package root;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Match implements Runnable {
	TileGrid grid;
	private Random random = new Random();

	public Match(TileGrid grid) {
		this.grid = grid;
	}

	public void run() {
		System.out.println("ㅋㅋ");
		while(true) {
			////match : 매치는 항상 검사
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 6; j++) {
					// 세로줄의 검사
					if (i != 8 && grid.GetTile(i,j).getType() == grid.GetTile(i+1, j).getType()) {
						if (i != 1 && grid.GetTile(i,j).getType() == grid.GetTile(i-1, j).getType()) {
							for (int n = -1; n <= 1; n++) {
								grid.GetTile(i+n, j).setMatch(grid.GetTile(i+n, j).getMatch()+1);
							}
						}
					}

					// 가로줄의 검사
					if (j != 6 && grid.GetTile(i, j).getType() == grid.GetTile(i, j+1).getType()) {
						if (j != 1 && grid.GetTile(i, j).getType() == grid.GetTile(i, j-1).getType()) {
							for (int n = -1; n <= 1; n++) {
								grid.GetTile(i, j+n).setMatch(grid.GetTile(i, j+n).getMatch()+1);
							}
						}
					}
				}
			}
			
			// 애니메이팅이 종료 되었다면
			if(grid.isAnimating() == false) {
				//second Swap : 매치 되지 않았다면 역스왑
				int score = 0;
				for (int i=1;i<=8;i++) {
					for (int j=1;j<=6;j++) {
						score += grid.GetTile(i, j).getMatch();
					}
				}

				if (grid.isSwap() == true) {
					if (score == 0) {
						int tmp;
						tmp= grid.GetTile(grid.getY0(), grid.getX0()).getCol();

						//System.out.println("Before Col: " + tmp);
						//System.out.println("Before Row: " + grid.GetTile(x0, y0).getRow());
						grid.GetTile(grid.getY0(), grid.getX0()).setCol(grid.GetTile(grid.getY(), grid.getX()).getCol());
						grid.GetTile(grid.getY(), grid.getX()).setCol(tmp);
						//System.out.println("After Col: " + grid.GetTile(x0, y0).getCol());

						tmp= grid.GetTile(grid.getY0(), grid.getX0()).getRow();
						grid.GetTile(grid.getY0(), grid.getX0()).setRow(grid.GetTile(grid.getY(), grid.getX()).getRow());
						grid.GetTile(grid.getY(), grid.getX()).setRow(tmp);
						//System.out.println("After Row: " + grid.GetTile(x0, y0).getRow());

						Tile tmpTile = grid.GetTile(grid.getY0(), grid.getX0());
						grid.SetTile(grid.getY0(), grid.getX0(), grid.GetTile(grid.getY(), grid.getX()));
						grid.SetTile(grid.getY(), grid.getX(), tmpTile);

						System.out.println("매치되지 않아서 돌려보냄");
					}

				}
				grid.setSwap(false);

				////updateGrid
				for (int i = 8; i > 0; i--) {
					for (int j = 1; j <= 6; j++) {
						if (grid.GetTile(i, j).getMatch()>=1) {
							for (int n = i; n > 0; n--) {
								if (grid.GetTile(n, j).getMatch() == 0) {

									Calculator.swapTileInfo(grid.getGrid(), n, j,  i, j);
									break;
								}
							}
						}
					}
				}


				for (int j = 1; j <= 6; j++) {
					for (int i = 8, n = 0; i > 0; i--) {
						if (grid.GetTile(i, j).getMatch()>=1) {
							int randomNumber = random.nextInt(8) + 1;
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
							case 6:
								grid.GetTile(i, j).setType(TileType.Vertical);
								break;
							case 7:
								grid.GetTile(i, j).setType(TileType.Horizontal);
								break;
							case 8:
								grid.GetTile(i, j).setType(TileType.Cross);
								break;
							}

							try {
								grid.GetTile(i, j).setBi(ImageIO.read(new File(grid.GetTile(i, j).getType().getPath())));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							grid.GetTile(i, j).setImage(grid.GetTile(i, j).getBi().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
							grid.GetTile(i, j).setY(-42 * n++); // tilesize = 42
							grid.GetTile(i, j).setMatch(0);
							grid.GetTile(i, j).setAlpha(1.0f);
						}
					}
				}
			}// isAnimating >> secondSwap & updateGrid

			try {
				Thread.sleep(200);
			} catch(InterruptedException e) {
				System.out.println(e);
			}

		}// entire while
	} // run
}
