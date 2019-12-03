package root;

import static java.lang.Math.abs;

public class Swap {
	
	TileGrid grid;
	
	public Swap(TileGrid grid) {
		this.grid = grid;
	}
	
	public void swap() {
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				Tile t = grid.GetTile(i,  j);
				int dx, dy;
				int tx, ty;
				tx = t.getX();
				ty = t.getY();
				
				for(int n = 0; n < 4; n++) {
					dx = t.getX() - t.getCol() * t.tileSize;
					dy = t.getY() - t.getRow() * t.tileSize;
					if(dx != 0) t.setX(tx - dx/abs(dx));
					if(dy != 0) t.setY(ty - dy/abs(dy));
				}
			}
		}
	}
	
	public void secondSwap() {
		
	}
}
