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
		
		public MyPanel(){ // ������ ���� panel�� ���� ����
			addKeyListener(new KeyListener(){ 
				public void keyPressed(KeyEvent e){
					double speed = 3;
					System.out.println("key is pressed");
					int keycode = e.getKeyCode();	// �Է¹��� Ű�� ���� ���������� ��ȯ
					switch(keycode){
					case KeyEvent.VK_LEFT : x-=20*speed; repaint(); break; 
					case KeyEvent.VK_RIGHT : x+= 20*speed; repaint();	break;
					case KeyEvent.VK_DOWN : y+= 20*speed; repaint(); break;
					case KeyEvent.VK_UP : y-= 20*speed; repaint(); break;
					} 
				} 
				@Override 
				public void keyReleased(KeyEvent arg0) {
					//System.out.println("Ű�� ��������! ");
				} 
				@Override
				public void keyTyped(KeyEvent arg0) { 
					//System.out.println("Ű�� ��������! ");
				}
			}); 
			this.requestFocus();
			setFocusable(true);
		}
		
		// �� panel�� �׷��� ����
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
		
		// �гμ���
		panel1.setSize(500, 400); 
		panel1.setBackground(Color.white);
		panel2.setSize(500, 100);
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(new FlowLayout());
		
		// �г�1������ �̹����гη� ������ ���� Ŭ���� ó�� 
		
		// �г�2����
		button1 = new JButton("move left"); 
		button2 = new JButton("move right"); 
		panel2.add(button1);
		panel2.add(button2); 
		button1.addActionListener(this); 
		button2.addActionListener(this); 
		
		// ���� ����
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH); 
		setVisible(true);
		} 
	
	@Override
	public void actionPerformed(ActionEvent g) {
		if (g.getSource() == button1) { 
			System.out.println("�������� �̵� �Էµ�");
			x -= 20;
			repaint(); 
		} 
		if (g.getSource() == button2) {
			System.out.println("���������� �̵� �Էµ�");
			x += 20;
			repaint(); 
		}
	} 
	
	
	
	public static void main(String[] args) {
		new Test(); 
	}
}

