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

		public MyPanel(){ // 움직일 도형 panel에 대한 설정
			this.requestFocus();
			setFocusable(true);

			start();
		}
		
		public void keyProcess() {
			if(KeyUp == true) {
				if( y > 0 ) y -= speed;
				//캐릭터가 보여지는 화면 위로 못 넘어가게 합니다.
				
				player_Status = 0;
				//이동키가 눌려지면 플레이어 상태를 0으로 돌립니다.
			}
			if(KeyDown == true) {
				if( y < 500 ) y += speed;
				//캐릭터가 보여지는 화면 아래로 못 넘어가게 합니다.
				player_Status = 0;
				//이동키가 눌려지면 플레이어 상태를 0으로 돌립니다.
			}
			if(KeyLeft == true) {
				if ( x > 0 ) x -= speed;
				//캐릭터가 보여지는 화면 왼쪽으로 못 넘어가게 합니다.
				player_Status = 0;
				//이동키가 눌려지면 플레이어 상태를 0으로 돌립니다.
			}
			if(KeyRight == true) {
				if ( x + 25 < 500 ) x += speed;
				//캐릭터가 보여지는 화면 오른쪽으로 못 넘어가게 합니다.
				player_Status = 0;
				//이동키가 눌려지면 플레이어 상태를 0으로 돌립니다.
			}
		}	
		public void keyPressed(KeyEvent e){ //이전버전과 같이 keyEvent를 바로 처리하지 않고, boolean 변수를 매개로 거쳐 처리
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
			//System.out.println("키가 눌려졌다! ");
			
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
		
		// 이 panel의 그래픽 설정
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
			case 0 : // 평상시
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
	public void init() { // Frame init
		setSize(500, 600);
		setTitle("testing..");
		setLayout(new BorderLayout());

		// 패널설정
		panel1.setSize(500, 500); 
		panel1.setBackground(Color.white);
		panel2.setSize(500, 100);
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(new FlowLayout());
		
		// 패널1설정은 이미지패널로 위에서 따로 클래스 처리 
		
		// 패널2설정
		scoreLabel = new JLabel("Score: " + score);
		gridLabel = new JLabel("(" + x + ", " + y + ")");
		scoreLabel.setForeground(Color.white);
		gridLabel.setForeground(Color.white);
		panel2.add(scoreLabel);
		panel2.add(gridLabel); 
		
		// 최종 실행
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH); 
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new TestGUI(); 
	}
}

