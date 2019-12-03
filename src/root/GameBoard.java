package root;

import static java.lang.Math.abs;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

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
	
	public GameBoard(TileGrid grid)
	{
		th = new Thread(this);
		f2 = new File("./sound/broken.wav");
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		this.grid = grid;
		isSwap = isMoving = false;
		click = 0;
		th.start();
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!isSwap && !isMoving) click++;
				pos = e.getPoint();
				System.out.println(pos.x + " " + pos.y);
				
				// mouse click
				if (click == 1)
				{
					x0 = pos.x / Tile.tileSize;
					y0 = pos.y / Tile.tileSize;
				}
				if (click == 2)
				{
					x = pos.x / Tile.tileSize;
					y = pos.y / Tile.tileSize;

					if (abs(x - x0) + abs(y - y0) == 1)
					{				
						System.out.println("µé¾î¿ÓÁö·Õ~");

						// swap col, row value
						int tmp;
						tmp= grid.GetTile(x0,  y0).getCol();

						System.out.println("Before Col: " + tmp);
						System.out.println("Before Row: " + grid.GetTile(x0, y0).getRow());
						grid.GetTile(x0, y0).setCol(grid.GetTile(x, y).getCol());
						grid.GetTile(x, y).setCol(tmp);
						System.out.println("After Col: " + grid.GetTile(x0, y0).getCol());
						
						tmp= grid.GetTile(x0,  y0).getRow();
						grid.GetTile(x0, y0).setRow(grid.GetTile(x, y).getRow());
						grid.GetTile(x, y).setRow(tmp);
						System.out.println("After Row: " + grid.GetTile(x0, y0).getRow());
					
						Tile tmpTile = grid.GetTile(x0, y0);
						grid.SetTile(x0, y0, grid.GetTile(x, y));
						grid.SetTile(x, y, tmpTile);
						
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
			public void mousePressed(MouseEvent e) {
				
				
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
	
	public void run() {
	
		while(true) {
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
			if(!isMoving)
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
						t.setMatch(0);
//						SoundThread mu = new SoundThread(f2);
//						mu.play();
					}
					
				}
			}
			
			int score=0;
			for (int i=1;i<=8;i++) {
				for (int j=1;j<=8;j++) {
					score+=grid.GetTile(i, j).getMatch();	
				}
			}

			if (isSwap && !isMoving) {
				if (score == 0) {
//					swap(grid[y0][x0],grid[y][x]); 
					int tmp;
					tmp= grid.GetTile(x0,  y0).getCol();

					grid.GetTile(x0, y0).setCol(grid.GetTile(x, y).getCol());
					grid.GetTile(x, y).setCol(tmp);
					
					tmp= grid.GetTile(x0,  y0).getRow();
					grid.GetTile(x0, y0).setRow(grid.GetTile(x, y).getRow());
					grid.GetTile(x, y).setRow(tmp);
				
					Tile tmpTile = grid.GetTile(x0, y0);
					grid.SetTile(x0, y0, grid.GetTile(x, y));
					grid.SetTile(x, y, tmpTile);
					
					isSwap= false;
				}
			}
			
			//if (grid[i][j].alpha>10) {grid[i][j].alpha-=10; isMoving=true;}
			try {
				Thread.sleep(5);
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
				System.out.println(grid.GetTile(i, j).getRow() + " " + grid.GetTile(i, j).getCol());
				g2d.drawImage(grid.GetTile(i,  j).getImage(), grid.GetTile(i, j).getX(), grid.GetTile(i, j).getY(), null);
			}
		}
	}
	
	public void update(Graphics g) {
		super.update(g);
		paint(g);
	}
	
}
