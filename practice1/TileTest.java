package practice1;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

public class TileTest extends JPanel{
	private Image img;
	
	public TileTest(Image img) {
		setPreferredSize (new Dimension(20, 20));
		this.img = img;
		File f = new File("D:\\study\\2학년 2학기\\자바\\Orchard\\src\\prototype\\tile2.png");
		System.out.println(f.exists()); // 파일이 있는지 확인
	}
	
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(img, 0, 0, d.width, d.height, null);
	}
}
