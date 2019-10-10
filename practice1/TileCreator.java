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
		
		frame.pack(); // 윈도우를 디스플레이: 프레임 부속 컴포넌트들을 크기 맞게 조정
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 이벤트
	}
}


