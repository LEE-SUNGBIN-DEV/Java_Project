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
	Image TileImage = new ImageIcon("tile1.png").getImage();
	
}


