package Practice;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character {
	public Character() {
		this.range = 1;
		this.count = 1;
		this.speed = 1;
		this.xLocate = 1.0;
		this.yLocate = 1.0;
	}
	
	private int range;
	private int count;
	public int speed; // +1 or -1 per sec. if speed is 1, you can move 1 range per second.
	public double xLocate, yLocate;
	
	public void attack() {
		Bubble bubble = new Bubble(range);
		locateBubble(xLocate, yLocate, bubble);
		bubble.bomb();
	}
	public void locateBubble(double x, double y, Bubble newBubble) {
		println("(" + x + "," + y + ")¿¡ ÆøÅºÀ» ¼³Ä¡Çß½À´Ï´Ù.");
	}
	public void move(KeyEvent e) {
		
	}
	
	private void print(String str) {
		System.out.print(str);
	}
	private void println(String str) {
		System.out.println(str);
	}
}
