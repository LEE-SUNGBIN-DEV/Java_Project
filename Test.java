package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test extends JFrame implements ActionListener{ 
	static int x = 230, y = 40;
	JPanel panel1 = new MyPanel();
	JPanel panel2 = new JPanel(); 
	JButton button1, button2; 
	
	class MyPanel extends JPanel {
		
		public MyPanel(){ // 움직일 도형 panel에 대한 설정
			addKeyListener(new KeyListener(){ 
				public void keyPressed(KeyEvent e){
					double speed = 3;
					System.out.println("key is pressed");
					int keycode = e.getKeyCode();	// 입력받은 키의 값을 정수형으로 반환
					switch(keycode){
					case KeyEvent.VK_LEFT : x-=20*speed; repaint(); break; 
					case KeyEvent.VK_RIGHT : x+= 20*speed; repaint();	break;
					case KeyEvent.VK_DOWN : y+= 20*speed; repaint(); break;
					case KeyEvent.VK_UP : y-= 20*speed; repaint(); break;
					} 
				} 
				@Override 
				public void keyReleased(KeyEvent arg0) {
					//System.out.println("키가 눌려졌다! ");
				} 
				@Override
				public void keyTyped(KeyEvent arg0) { 
					//System.out.println("키가 눌려졌다! ");
				}
			}); 
			this.requestFocus();
			setFocusable(true);
		}
		
		// 이 panel의 그래픽 설정
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.black); 
			g.fillOval(x, y, 40, 40); 
		} 
	} 
	
	public Test() {
		setSize(500, 400);
		setTitle("move Circle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// 패널설정
		panel1.setSize(500, 400); 
		panel1.setBackground(Color.white);
		panel2.setSize(500, 100);
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(new FlowLayout());
		
		// 패널1설정은 이미지패널로 위에서 따로 클래스 처리 
		
		// 패널2설정
		button1 = new JButton("move left"); 
		button2 = new JButton("move right"); 
		panel2.add(button1);
		panel2.add(button2); 
		button1.addActionListener(this); 
		button2.addActionListener(this); 
		
		// 최종 실행
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH); 
		setVisible(true);
		} 
	
	@Override
	public void actionPerformed(ActionEvent g) {
		if (g.getSource() == button1) { 
			System.out.println("왼쪽으로 이동 입력됨");
			x -= 20;
			repaint(); 
		} 
		if (g.getSource() == button2) {
			System.out.println("오른쪽으로 이동 입력됨");
			x += 20;
			repaint(); 
		}
	} 
	
	
	
	public static void main(String[] args) {
		new Test(); 
	}
}

