package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class OrchardBoard extends JPanel
{
	private BufferedImage img[][] = new BufferedImage[4][4];
	private JPanel board = new JPanel();
	
	public OrchardBoard()
	{
		setBackground(Color.blue);
		board = new JPanel();
		board.setBackground(Color.white);
		board.setPreferredSize(new Dimension(510, 640));
		board.setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		
		
	}
	
	public void Update(int[][] intGrid)
	{
		for(int i = 1; i < intGrid.length - 1; i++)
		{
			for(int j = 1; j < intGrid[i].length - 1; j++)
			{
				System.out.println();
				switch(intGrid[i][j]) 
				{
				case 0:
					try {
						img[i][j] = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\res\\grapes.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				
				case 1:
					try {
						img[i][j] = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\res\\lemon.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
//	public void paint(Graphics g)
//	{
//		for(int i = 1; i < img.length - 1; i++)
//		{
//			for(int j = 1; j < img[i].length - 1; j++)
//			{
//				g.drawImage(img[i][j],  (i-1)*128 + 20,  (j-1)*128 + 30,  this);
//			}
//		}
//	}
}
