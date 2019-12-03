package root;

public class Match implements Runnable
{
	TileGrid grid;

	public Match(TileGrid grid)
	{
		this.grid = grid;
	}

	public void run()
	{
		while(true)
		{
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 8; j++) {
					
					// 세로줄의 검사
					if (i != 8 && grid.GetTile(i,j).getType() == grid.GetTile(i+1, j).getType()) {
						if (i != 1 && grid.GetTile(i,j).getType() == grid.GetTile(i-1, j).getType()) {
							for (int n = -1; n <= 1; n++) {
								grid.GetTile(i+n, j).setMatch(grid.GetTile(i+n, j).getMatch()+1);
							}
						}
					}

					// 가로줄의 검사
					if (j != 8 && grid.GetTile(i, j).getType() == grid.GetTile(i, j+1).getType()) {
						if (j != 1 && grid.GetTile(i, j).getType() == grid.GetTile(i, j-1).getType()) {
							for (int n = -1; n <= 1; n++) {
								grid.GetTile(i, j+n).setMatch(grid.GetTile(i, j+n).getMatch()+1);
							}
						}
					}
				}
			}
			
			try {
				Thread.sleep(200);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}

}
