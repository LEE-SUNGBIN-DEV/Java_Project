package Test;

public class Item implements Runnable{

	public static final int WIDTH = 8;
	public static final int HEIGHT = 10;
	
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
		
		
	}
}
