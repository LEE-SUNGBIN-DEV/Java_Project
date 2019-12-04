package root;

import static java.lang.Math.abs;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements Runnable {
	
	private File file;
	private int x0, y0, x, y;
	private int click;
	private Point pos;
	private TileGrid grid;
	private boolean isSwap, isMoving;
	private Thread th;
	private File f2;
	
	private Random random = new Random();
	
	public GameBoard(TileGrid grid)
	{
		th = new Thread(this);
		f2 = new File("sound/broken.wav");
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		this.grid = grid;
		isSwap = isMoving = false;
		click = 0;
		th.start();
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (!isSwap && !isMoving) click++;
				pos = e.getPoint();
				//System.out.println(pos.x + " " + pos.y);
				
				// mouse click
				if (click == 1)
				{
					// x좌표는 열*size
					// y좌표는 행*size
					x0 = pos.x / Tile.tileSize;
					y0 = pos.y / Tile.tileSize;
				}
				if (click == 2)
				{
					x = pos.x / Tile.tileSize;
					y = pos.y / Tile.tileSize;

					if (abs(x - x0) + abs(y - y0) == 1)
					{				
						System.out.println("들어왓지롱~");

						// swap col, row value
						int tmp;
						tmp= grid.GetTile(y0,  x0).getCol();

						grid.GetTile(y0, x0).setCol(grid.GetTile(y, x).getCol());
						grid.GetTile(y, x).setCol(tmp);
						
						tmp= grid.GetTile(y0,  x0).getRow();
						grid.GetTile(y0, x0).setRow(grid.GetTile(y, x).getRow());
						grid.GetTile(y, x).setRow(tmp);
					
						Tile tmpTile = grid.GetTile(y0, x0);
						grid.SetTile(y0, x0, grid.GetTile(y, x));
						grid.SetTile(y, x, tmpTile);
						
						isSwap = true;
						click = 0;
					}
					else {
						x0 = x;
						y0 = y;
						click = 1;
					}
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});	
	}
	
	public void run()
	{
		while(true) {
			///////// match
			if(isMoving == false){
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
			}
			/////////
			
			// moving animaion
			isMoving = false;
			for(int i = 1; i <= 8; i++) {
				for(int j = 1; j <= 8; j++) {
					Tile t = grid.GetTile(i,  j);
					int tx, ty;
					int dx, dy;
					tx = t.getX();
					ty = t.getY();
					
					dx = tx - t.getCol() * t.tileSize;
					dy = ty - t.getRow() * t.tileSize;
					if(dx != 0) { t.setX(tx - dx/abs(dx)); repaint();}
					if(dy != 0) { t.setY(ty - dy/abs(dy)); repaint();}
					if(dx != 0 || dy != 0) isMoving = true;
					
				}
			}
			
			// delete animation
			if(isMoving == false) {
			for(int i = 1; i <= 8; i++) {
				for(int j = 1; j <= 8; j++) {
					Tile t = grid.GetTile(i, j);
					if(t.getMatch() >= 1) {
						if(t.getAlpha()>=0.008f) {
							t.setAlpha(t.getAlpha()-0.008f);
							isMoving = true;
							repaint();
						}
					}
					if(t.getAlpha() <= 0.011f) {
//						t.setMatch(0);
//						SoundThread mu = new SoundThread(f2);
//						mu.play();
					}
					
				}
			}
			}
			
			if(isMoving == false)
			{
				int score = 0;
				for (int i=1;i<=8;i++) {
					for (int j=1;j<=8;j++) {
						score += grid.GetTile(i, j).getMatch();
					}
				}
			
				if (isSwap == true) {
					if (score == 0) {
						int tmp;
						tmp= grid.GetTile(y0,  x0).getCol();

						//System.out.println("Before Col: " + tmp);
						//System.out.println("Before Row: " + grid.GetTile(x0, y0).getRow());
						grid.GetTile(y0, x0).setCol(grid.GetTile(y, x).getCol());
						grid.GetTile(y, x).setCol(tmp);
						//System.out.println("After Col: " + grid.GetTile(x0, y0).getCol());
						
						tmp= grid.GetTile(y0,  x0).getRow();
						grid.GetTile(y0, x0).setRow(grid.GetTile(y, x).getRow());
						grid.GetTile(y, x).setRow(tmp);
						//System.out.println("After Row: " + grid.GetTile(x0, y0).getRow());
					
						Tile tmpTile = grid.GetTile(y0, x0);
						grid.SetTile(y0, x0, grid.GetTile(y, x));
						grid.SetTile(y, x, tmpTile);
						
						System.out.println("매치되지 않아서 돌려보냄");
					}
					
				}
				isSwap = false;
			//if (grid[i][j].alpha>10) {grid[i][j].alpha-=10; isMoving=true;}
			}
			/////////
			//update grid
			if(isMoving == false) {
				for (int i = 8; i > 0; i--) {
					for (int j = 1; j <= 8; j++) {
						if (grid.GetTile(i, j).getMatch()>=1) {
							for (int n = i; n > 0; n--) {
								if (grid.GetTile(n, j).getMatch() == 0) {
									System.out.println("스왑전 : " + grid.GetTile(n, j).getRow() + " " + grid.GetTile(n, j).getCol());
									System.out.println("스왑전 : " + grid.GetTile(i, j).getRow() + " " + grid.GetTile(i, j).getCol());
									int tmp;							
									
									tmp= grid.GetTile(n,  j).getRow();
									grid.GetTile(n, j).setRow(grid.GetTile(i, j).getRow());
									grid.GetTile(i, j).setRow(tmp);
									
									tmp= grid.GetTile(n,  j).getCol();
									grid.GetTile(n, j).setCol(grid.GetTile(i, j).getCol());
									grid.GetTile(i, j).setCol(tmp);
									
									System.out.println("스왑후 :" + grid.GetTile(n, j).getRow() + " " + grid.GetTile(n, j).getCol());
									System.out.println("스왑후 :" + grid.GetTile(i, j).getRow() + " " + grid.GetTile(i, j).getCol());
									
									Tile tmpTile = grid.GetTile(n, j);
									grid.SetTile(n, j, grid.GetTile(i, j));
									grid.SetTile(i, j, tmpTile);
									
									/*
									 */
									
									break;
								} // if
							} // for n
						} // if
					}
				}


				for (int j = 1; j <= 8; j++) {
					for (int i = 8, n = 0; i > 0; i--) {
						if (grid.GetTile(i, j).getMatch()>=1) {
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
			}
			////////
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

//		try {
//			g.drawImage(ImageIO.read(new File("img/background.png")).getScaledInstance(600, 600, Image.SCALE_SMOOTH), 0, 0, null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				Graphics2D g2d = (Graphics2D)g;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,grid.GetTile(i, j).getAlpha()));
				//System.out.println(grid.GetTile(i, j).getRow() + " " + grid.GetTile(i, j).getCol());
				g2d.drawImage(grid.GetTile(i,  j).getImage(), grid.GetTile(i, j).getX(), grid.GetTile(i, j).getY(), null);
			}
		}
	}
	
	public void update(Graphics g) {
		super.update(g);
		paint(g);
	}
	
}
