package Test;

public class Item implements Runnable{

	public static final int WIDTH = 8;
	public static final int HEIGHT = 10;
	
	public static void useItem(Tile[][] grid, int x, int y, int x0, int y0) {
		
		//메소드를 다른 클래스에서 사용하기 위해 useItem 메소드를 생성한다. 
		//Tile 배열 grid, 첫번째 클릭시 좌표값 x0, y0 , 두번째 클릭시 좌표값 x, y 를 인자로 받는다.
		
		
		
		//가로 지우는 아이템일 경우
		if(grid[y0][x0].getType() == TileType.Horizontal || (grid[y][x].getType() == TileType.Horizontal)) {
			//첫번째 클릭시의 타일 타입이 가로지우는 아이템이거나 두번째 클릭시의 타일타입이 가로지우는 아이템일 경우에 실행한다.
			System.out.println("I find it");
			if(grid[y0][x0].getType() == TileType.Horizontal)
			{
				for(int k=1; k<=WIDTH-1; k++)
				{
					grid[y0][k].setMatch(grid[y0][k].getMatch()+1);
				}
			} // 첫번째 클릭이 가로지우는 아이템인 경우 해당 행의 가로 매치값을 전부 1 증가시킨다.
			
			if(grid[y][x].getType() == TileType.Horizontal)
			{
				for(int k=1; k<=WIDTH-1; k++)
				{
					grid[y][k].setMatch(grid[y][k].getMatch()+1);
				}
			} // 2번째 클릭이 가로지우는 아이템인 경우 해당 행의 가로 매치값을 전부 1 증가시킨다.
		}

		//세로 지우는 아이템일 경우
		if(grid[y0][x0].getType() == TileType.Vertical || grid[y][x].getType() == TileType.Vertical) {
			//첫번째 클릭시의 타일 타입이 세로 지우는 아이템이거나 두번째 클릭시의 타일타입이 세로 지우는 아이템일 경우에 실행한다.
			
			System.out.println("I find it 2");
			if(grid[y0][x0].getType() == TileType.Vertical)
			{
				for(int k=1; k<=HEIGHT-1; k++)
				{
					grid[k][x0].setMatch(grid[k][x0].getMatch()+1);
				}
			} // 첫번째 클릭이 세로지우는 아이템인 경우 해당 열의 세로 매치값을 전부 1 증가시킨다.
			if(grid[y][x].getType() == TileType.Vertical)
			{
				for(int k=1; k<=HEIGHT-1; k++)
				{
					grid[k][x].setMatch(grid[k][x].getMatch()+1);
				}
			} // 2번째 클릭이 세로지우는 아이템인 경우 해당 열의 세로 매치값을 전부 1 증가시킨다.
		}

		//cross아이템인 경우
		if(grid[y0][x0].getType() == TileType.Cross || grid[y][x].getType() == TileType.Cross) 
		{
			//첫번째 클릭시의 타일 타입이 가로, 세로  전부 지우는 아이템이거나 두번째 클릭시의 타일타입이 가로, 세로 전부 지우는 아이템일 경우에 실행한다.
			
			if(grid[y0][x0].getType() == TileType.Cross) // 첫번째 클릭한 값이 cross아이템인 경우
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
			} //첫번째 클릭시의 타일 타입이 가로, 세로  전부 지우는 아이템일 경우 해당 행과 열의 가로세로 매치값들을 전부 1증가시킨다.
			

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
			} //두번째 클릭시의 타일 타입이 가로, 세로  전부 지우는 아이템일 경우 해당 행과 열의 가로세로 매치값들을 전부 1증가시킨다.
			
		} // cross아이템인 경우
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}
}
