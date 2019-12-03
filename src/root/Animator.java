package root;

public class Animator {

	public static void deleteTile(TileGrid grid) {
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				Tile t = grid.GetTile(i,  j);
				if(t.getMatch() != 0)
					if(t.getAlpha() > 10) {
						t.setAlpha(t.getAlpha() - 10);
						// isMoving = true;
					}
			}
		}
	}
}
