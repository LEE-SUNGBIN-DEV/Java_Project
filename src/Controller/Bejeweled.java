package Controller;

import static java.lang.Math.abs;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Model.Calculator;
import Model.Music;
import Model.Tile;
import Model.TileGrid;
import Model.TileType;

public class Bejeweled implements Runnable {

	private Random random;
	private TileGrid _grid;
	private Tile[][] _gridMatrix;
	private int totalMatch;
	public boolean functionProcessing;
	
	public Bejeweled(TileGrid grid) {
		_grid = grid;
		_gridMatrix = grid.getGrid();
		functionProcessing = false;
		random = new Random();
		
	}
	
	@Override
	public void run() {
		while(true) {
			/*
			 * �������: 1) matchCheck() �Լ� ȣ�� ����, ����� �Է��� �޴� ��Ȳ 2) �ִϸ��̼� ���� ����� �Է��� �޴´ٸ�
			 * 
			 * 
			 * */
			
			// total Match�� �� ����Ŭ���� 0���� �ʱ�ȭ
			totalMatch = 0;
			// match�� Ÿ�ϵ��� �ִ��� �˻�
			matchCheck();
			functionProcessing = true;
			if(totalMatch > 0) {
				// ��ġ�� ���� ��� �ϳ� ������, ����� �Է��� �ƴ� ��: 
				// Tile���� ���� ���ܳ��� TileGrid�� ������Ʈ �Ǿ��� �� ��ġ�� ���� ���� ��
				if(!_grid.isSwap()) {
					deleteAnimation();
					updateGrid();
				}
				
				// ��ġ�� ���� ��� �ϳ� �ְ�, ����� �Է��� ��: 
				// ����� Swap Animation ���� �����Ǵ� ��Ȳ
				else if(_grid.isSwap()) {
					movingAnimation();
					deleteAnimation();
					updateGrid();
					_grid.setSwap(false);
				}
			}
			else {
			// ��ġ�� ���� �ϳ��� ������, ����� �Է��� ��:
			// ����� �Է����� Swap�� �߻������� ��ġ�Ǵ� ���� ���, ��, Second Swap Animation
				if(_grid.isSwap()) {
					movingAnimation();
					secondSwap();
				}
			}
			functionProcessing = false;
		}
	}
	
	public boolean isFunctionProcessing() {
		return functionProcessing;
	}

	public void matchCheck() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 6; j++) {
				// �������� �˻�
				if (i != 8 && _gridMatrix[i][j].getType() == _gridMatrix[i+1][j].getType()) {
					if (i != 1 && _gridMatrix[i][j].getType() == _gridMatrix[i-1][j].getType()) {
						// ��ġ�� ���� �ϳ��� ������ �� Ÿ�ϵ��� match ������ ������Ʈ�ϰ� match�� Ÿ�� ������ŭ score���� ����
						for (int n = -1; n <= 1; n++) {
							_gridMatrix[i+n][j].setMatch(_gridMatrix[i+n][j].getMatch()+1);
							totalMatch++;
						}
					}
				}

				// �������� �˻�
				if (j != 6 && _gridMatrix[i][j].getType() == _gridMatrix[i][j+1].getType()) {
					if (j != 1 && _gridMatrix[i][j].getType() == _gridMatrix[i][j-1].getType()) {

						for (int n = -1; n <= 1; n++) {
							_gridMatrix[i][j+n].setMatch(_gridMatrix[i][j+n].getMatch()+1);
							totalMatch++;
						}
					}
				}
			}
		}
	}
	
	public void deleteAnimation() {
		Tile[][] gridMatrix = _grid.getGrid();
		for(int cnt = 0 ; cnt < 100; cnt++)
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 6; j++) {
				Tile t = gridMatrix[i][j];
				if (t.getMatch() >= 1) {
					if (t.getAlpha() >= 0.03f) {
						t.setAlpha(t.getAlpha() - 0.02f);
						// �ִϸ����� ������ ���� ������ sleep
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		Music deleteEffectSound = new Music("removeSound.mp3", false);
		deleteEffectSound.start();
		
	}
	
	public void updateGrid() {
		int updateColCount = 0;
		
		////updateGrid
		for (int i = 8; i > 0; i--) {
			for (int j = 1; j <= 6; j++) {
				if (_gridMatrix[i][j].getMatch()>=1) {	
					for (int n = i; n > 0; n--) {
						if (_gridMatrix[n][j].getMatch() == 0) {
							Calculator.swapTileInfo(_grid.getGrid(), n, j,  i, j);	
							break;
						}
					}
				}
			}
		}
		
		Image img = null;
		for (int j = 1; j <= 6; j++) {
			for (int i = 8, n = 0; i > 0; i--) {
				if (_gridMatrix[i][j].getMatch()>=1) {
					int randomNumber = random.nextInt(5) + 1;
					switch(randomNumber)
					{
					case 1:
						_grid.GetTile(i, j).setType(TileType.Banana);
						img = Model.ResourceData.bananaImg;
						break;
					case 2:
						_gridMatrix[i][j].setType(TileType.Apple);
						img = Model.ResourceData.appleImg;
						break;
					case 3:
						_gridMatrix[i][j].setType(TileType.Lemon);
						img = Model.ResourceData.lemonImg;
						break;
					case 4:
						_gridMatrix[i][j].setType(TileType.Orange);
						img = Model.ResourceData.orangeImg;
						break;
					case 5:
						_gridMatrix[i][j].setType(TileType.Pear);
						img = Model.ResourceData.pearImg;
						break;
					}

					_gridMatrix[i][j].setImage(img);
					_gridMatrix[i][j].setY(-42 * n++); // tilesize = 42
					if(updateColCount < n) updateColCount = n;
					_gridMatrix[i][j].setMatch(0);
					_gridMatrix[i][j].setAlpha(1.0f);
				}
			}
		}
		for(int i = 0; i < updateColCount; i++)
			movingAnimation();
	}
	
	public void movingAnimation() {
		Tile[][] gridMatrix = _grid.getGrid();
		for(int cnt = 0; cnt < 50; cnt++)
		{
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 6; j++) {
					Tile t = gridMatrix[i][j];
					int tx, ty;
					int dx, dy;
					tx = t.getX();
					ty = t.getY();
	
					dx = tx - t.getCol() * Tile.tileSize;
					dy = ty - t.getRow() * Tile.tileSize;
					if (dx != 0) {
						t.setX(tx - dx / abs(dx));
					}
					if (dy != 0) {
						t.setY(ty - dy / abs(dy));
					}
				}
			}
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void secondSwap() {
		Calculator.swapTileInfo(_grid.getGrid(), _grid.getY0(), _grid.getX0(), _grid.getY(), _grid.getX());
		movingAnimation();
		_grid.setSwap(false);
	}
}
