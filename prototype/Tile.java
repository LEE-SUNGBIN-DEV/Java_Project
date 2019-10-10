package prototype;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.List;
import java.awt.image.*;

// This is prototype program of Orchard Project
public class Tile {
	public Tile(int i, int j) {
		this.x = (double)i;
		this.y = (double)j;
		
		terrainInfo = false; // 지형 처리 코드 추가 in Map Class
		wallInfo = false;
		itemInfo = false;
		bubbleInfo = false;
		characterList = new LinkedList();
	}
	
	double x, y;			// 타일의 중심 좌표(Tile 인스터스 인덱스가 중심좌표로 설정)
	boolean terrainInfo;
	boolean wallInfo;
	boolean itemInfo;
	boolean bubbleInfo;
	java.util.List<Character> characterList;
	Image TileImage = new ImageIcon("tile1.png").getImage();
	
}


