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
	
	private boolean isSwap, isMoving, isAnimating;

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
		isAnimating = true;
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
			// moving animaion
			isAnimating = true;
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
//						if(t.getAlpha() <= 0.011f) {
//							SoundThread mu = new SoundThread(f2);
//							mu.play();
//						}

					}
				}
			}
			
			if(isMoving == false) isAnimating = false; // 무빙이 없다면 애니메이팅 종료를 알림 -> Match 쓰레드에서 기능 실행

			try {
				Thread.sleep(4);
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
	
	public boolean getIsAnimating() {
		return isAnimating;
	}

	public void setIsAnimating(boolean isAnimating) {
		this.isAnimating = isAnimating;
	}
	
	public boolean getIsSwap() {
		return isSwap;
	}

	public void setIsSwap(boolean isSwap) {
		this.isSwap = isSwap;
	}

	public boolean getIsMoving() {
		return isMoving;
	}

	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	
	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
