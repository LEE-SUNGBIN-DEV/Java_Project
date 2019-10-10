package practice1;

import java.awt.Image;
import org.
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TileCreator extends JFrame{
	
	static void initUI( TileCreator tileCreaotr) {
		
	}
	
	public TileCreator() {
		
	}
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./img/" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		
		return icon_new;
	}
	
	public static void main(String args[]) {
		
		String filePath = "./src/prototype/tile2.png";
		ImageIcon tileImage = new ImageIcon(filePath);
		
		JFrame frame = new JFrame("Tile Creator..");
		frame.setLocation(350,  350);
		frame.setVisible(true);
		
		TileTest tile[] = new TileTest[10];
		for(int i = 0; i < 10; i++) {

			tile[i] = new TileTest(tileImage.getImage());
			frame.add(tile[i]);
		}
		
		frame.pack(); // �����츦 ���÷���: ������ �μ� ������Ʈ���� ũ�� �°� ����
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �̺�Ʈ
	}
}


