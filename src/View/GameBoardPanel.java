package View;

import Model.TileGrid;
import Model.Tile;


import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel {

	private Tile[][] grid;
	
	public GameBoardPanel(TileGrid grid) {
	
		setBounds(47, 135, 400, 500);
		this.grid = grid.getGrid();
	}
	

	@Override
	public void paint(Graphics g) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 6; j++) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, grid[i][j].getAlpha()));
				g2d.drawImage(grid[i][j].getImage(), grid[i][j].getX(), grid[i][j].getY(), null);
			}
		}
		this.repaint();
	}
	
	public void addGameListener(MouseListener listener) {
		this.addMouseListener(listener);
	}
}