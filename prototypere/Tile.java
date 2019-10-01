package test;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.*;
import java.awt.List;

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
	
}


