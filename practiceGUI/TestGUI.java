package testGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.*;

public class TestGUI extends JFrame implements ActionListener{ 
	static int x = 10, y = 20;
	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	int player_Status = 0, cnt = 0; 
	int score = 0;
	int speed = 1;
	JLabel gridLabel;
	JLabel scoreLabel;
	JPanel panel1 = new MyPanel();
	JPanel panel2 = new JPanel(); 
	JButton button1, button2; 
	
	class MyPanel extends JPanel implements KeyListener, Runnable {
		Thread th;

		public MyPanel(){ // ������ ���� panel�� ���� ����
			this.requestFocus();
			setFocusable(true);

			start();
		}
		
		public void keyProcess() {
			if(KeyUp == true) {
				if( y > 0 ) y -= speed;
				//ĳ���Ͱ� �������� ȭ�� ���� �� �Ѿ�� �մϴ�.
				
				player_Status = 0;
				//�̵�Ű�� �������� �÷��̾� ���¸� 0���� �����ϴ�.
			}
			if(KeyDown == true) {
				if( y < 500 ) y += speed;
				//ĳ���Ͱ� �������� ȭ�� �Ʒ��� �� �Ѿ�� �մϴ�.
				player_Status = 0;
				//�̵�Ű�� �������� �÷��̾� ���¸� 0���� �����ϴ�.
			}
			if(KeyLeft == true) {
				if ( x > 0 ) x -= speed;
				//ĳ���Ͱ� �������� ȭ�� �������� �� �Ѿ�� �մϴ�.
				player_Status = 0;
				//�̵�Ű�� �������� �÷��̾� ���¸� 0���� �����ϴ�.
			}
			if(KeyRight == true) {
				if ( x + 25 < 500 ) x += speed;
				//ĳ���Ͱ� �������� ȭ�� ���������� �� �Ѿ�� �մϴ�.
				player_Status = 0;
				//�̵�Ű�� �������� �÷��̾� ���¸� 0���� �����ϴ�.
			}
		}	
		public void keyPressed(KeyEvent e){ //���������� ���� keyEvent�� �ٷ� ó������ �ʰ�, boolean ������ �Ű��� ���� ó��
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP :
			KeyUp = true;
			break;
			case KeyEvent.VK_DOWN :
			KeyDown = true;
			break;
			case KeyEvent.VK_LEFT :
			KeyLeft = true;
			break;
			case KeyEvent.VK_RIGHT :
			KeyRight = true;
			break;
			}
		} 
		@Override 
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP :
			KeyUp = false;
			break;
			case KeyEvent.VK_DOWN :
			KeyDown = false;
			break;
			case KeyEvent.VK_LEFT :
			KeyLeft = false;
			break;
			case KeyEvent.VK_RIGHT :
			KeyRight = false;
			break;
			} 
		}
		@Override
		public void keyTyped(KeyEvent e) { 
			//System.out.println("Ű�� ��������! ");
			
		}
		public void start() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addKeyListener(this);
			
			
			th = new Thread(this);
			th.start();
		}
		
		public void run() {
			try{
				while(true) {
					keyProcess();
					repaint();
					
					Thread.sleep(10);
				}
			}catch(Exception e) {}
		}
		
		// �� panel�� �׷��� ����
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.black); 
			g.fillRect(x, y, 25, 25); 
				
			update(g);
		}
		
		public void update(Graphics g) {
			draw_Player();
		}
		
		public void draw_Player(){ 
			switch (player_Status){ 
			case 0 : // ����
			gridLabel.setText("(" + x + ", " + y + ")");
			break;
			}
		}
	} 
	
	public TestGUI() {
			init();
			new MyPanel();
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
	public void init() { // Frame init
		setSize(500, 600);
		setTitle("testing..");
		setLayout(new BorderLayout());

		// �гμ���
		panel1.setSize(500, 500); 
		panel1.setBackground(Color.white);
		panel2.setSize(500, 100);
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(new FlowLayout());
		
		// �г�1������ �̹����гη� ������ ���� Ŭ���� ó�� 
		
		// �г�2����
		scoreLabel = new JLabel("Score: " + score);
		gridLabel = new JLabel("(" + x + ", " + y + ")");
		scoreLabel.setForeground(Color.white);
		gridLabel.setForeground(Color.white);
		panel2.add(scoreLabel);
		panel2.add(gridLabel); 
		
		// ���� ����
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH); 
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new TestGUI(); 
	}
}

