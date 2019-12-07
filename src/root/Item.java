package root;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Item implements Runnable{

	public static final int WIDTH = 8;
	public static final int HEIGHT = 10;
	TileGrid grid;
	private Random random = new Random();
	
	public Item(TileGrid grid) {
		this.grid = grid;
	}
	
	
	public static void useItem(Tile[][] grid, int x, int y, int x0, int y0) {
		
		//�޼ҵ带 �ٸ� Ŭ�������� ����ϱ� ���� useItem �޼ҵ带 �����Ѵ�. 
		//Tile �迭 grid, ù��° Ŭ���� ��ǥ�� x0, y0 , �ι�° Ŭ���� ��ǥ�� x, y �� ���ڷ� �޴´�.
		
		
		
		//���� ����� �������� ���
		if(grid[y0][x0].getType() == TileType.Horizontal || (grid[y][x].getType() == TileType.Horizontal)) {
			//ù��° Ŭ������ Ÿ�� Ÿ���� ��������� �������̰ų� �ι�° Ŭ������ Ÿ��Ÿ���� ��������� �������� ��쿡 �����Ѵ�.
			System.out.println("I find it");
			if(grid[y0][x0].getType() == TileType.Horizontal)
			{
				for(int k=1; k<=WIDTH-1; k++)
				{
					grid[y0][k].setMatch(grid[y0][k].getMatch()+1);
				}
			} // ù��° Ŭ���� ��������� �������� ��� �ش� ���� ���� ��ġ���� ���� 1 ������Ų��.
			
			if(grid[y][x].getType() == TileType.Horizontal)
			{
				for(int k=1; k<=WIDTH-1; k++)
				{
					grid[y][k].setMatch(grid[y][k].getMatch()+1);
				}
			} // 2��° Ŭ���� ��������� �������� ��� �ش� ���� ���� ��ġ���� ���� 1 ������Ų��.
		}

		//���� ����� �������� ���
		if(grid[y0][x0].getType() == TileType.Vertical || grid[y][x].getType() == TileType.Vertical) {
			//ù��° Ŭ������ Ÿ�� Ÿ���� ���� ����� �������̰ų� �ι�° Ŭ������ Ÿ��Ÿ���� ���� ����� �������� ��쿡 �����Ѵ�.
			
			System.out.println("I find it 2");
			if(grid[y0][x0].getType() == TileType.Vertical)
			{
				for(int k=1; k<=HEIGHT-1; k++)
				{
					grid[k][x0].setMatch(grid[k][x0].getMatch()+1);
				}
			} // ù��° Ŭ���� ��������� �������� ��� �ش� ���� ���� ��ġ���� ���� 1 ������Ų��.
			if(grid[y][x].getType() == TileType.Vertical)
			{
				for(int k=1; k<=HEIGHT-1; k++)
				{
					grid[k][x].setMatch(grid[k][x].getMatch()+1);
				}
			} // 2��° Ŭ���� ��������� �������� ��� �ش� ���� ���� ��ġ���� ���� 1 ������Ų��.
		}

		//cross�������� ���
		if(grid[y0][x0].getType() == TileType.Cross || grid[y][x].getType() == TileType.Cross) 
		{
			//ù��° Ŭ������ Ÿ�� Ÿ���� ����, ����  ���� ����� �������̰ų� �ι�° Ŭ������ Ÿ��Ÿ���� ����, ���� ���� ����� �������� ��쿡 �����Ѵ�.
			
			if(grid[y0][x0].getType() == TileType.Cross) // ù��° Ŭ���� ���� cross�������� ���
			{
				System.out.println("cross == >");
				for(int k=1; k<=HEIGHT-1; k++)
				{
					grid[k][x0].setMatch(grid[k][x0].getMatch()+1);
				}
				for(int k=1; k<=WIDTH-1; k++)
				{
					grid[y0][k].setMatch(grid[y0][k].getMatch()+1);
				}
			} //ù��° Ŭ������ Ÿ�� Ÿ���� ����, ����  ���� ����� �������� ��� �ش� ��� ���� ���μ��� ��ġ������ ���� 1������Ų��.
			

			if(grid[y][x].getType() == TileType.Cross)
			{
				for(int k=1; k<=HEIGHT-1; k++)
				{
					grid[k][x].setMatch(grid[k][x].getMatch()+1);
				}
				for(int k=1; k<=WIDTH-1; k++)
				{
					grid[y][k].setMatch(grid[y][k].getMatch()+1);
				}
			} //�ι�° Ŭ������ Ÿ�� Ÿ���� ����, ����  ���� ����� �������� ��� �ش� ��� ���� ���μ��� ��ġ������ ���� 1������Ų��.
			
		} // cross�������� ���
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			int i = random.nextInt(6) + 1;
			int j = random.nextInt(6) + 1;
			int n = 0;

			if (grid.GetTile(i, j).getMatch()<1) {
				int randomNumber = random.nextInt(3) + 1;
				switch(randomNumber)
				{
				case 1:
					grid.GetTile(i, j).setType(TileType.Vertical);
					break;
				case 2:
					grid.GetTile(i, j).setType(TileType.Horizontal);
					break;
				case 3:
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
				grid.GetTile(i, j).setY(-50 * n++); // tilesize = 50
				grid.GetTile(i, j).setMatch(0);
				grid.GetTile(i, j).setAlpha(1.0f);
			}
			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}	// entire while
	}
}
