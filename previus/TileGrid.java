package practice2;

import static practice2.Manager.*;

public class TileGrid {
	
	public Tile[][] map;
	
	
	// map 정보가 주어지지 않을 때, 기본 타일맵 생성
	public TileGrid() {
		map = new Tile[15][15];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Dirt);
			}
		}
	}
	
	// map 정보가 주어질 때
	public TileGrid(int[][] newMap) {
		map = new Tile[15][15];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if( newMap[i][j] == 0 ) {
					map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Dirt);
				}
				else
					map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Tree);
			}
		}
	}
	public void Draw() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}
}
