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
		
		terrainInfo = false; // ���� ó�� �ڵ� �߰� in Map Class
		wallInfo = false;
		itemInfo = false;
		bubbleInfo = false;
		characterList = new LinkedList();
	}
	
	double x, y;			// Ÿ���� �߽� ��ǥ(Tile �ν��ͽ� �ε����� �߽���ǥ�� ����)
	boolean terrainInfo;
	boolean wallInfo;
	boolean itemInfo;
	boolean bubbleInfo;
	java.util.List<Character> characterList;
	
}


