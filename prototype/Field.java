package prototype;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.*;
import java.awt.List;


public class Field {
	public Field(int i, int j) {
		this.x = (double)i;
		this.y = (double)j;
		terrainInfo = null;
		itemInfo = null;
		bubbleInfo = null;
		characterList = new LinkedList();
	}
	Terrain terrainInfo;
	Item itemInfo;
	Bubble bubbleInfo;
	java.util.List<Character> characterList;
	double width;
	double height;
	
	public static void main(String args[]) {
			
		new KeyListenerTest();
		
	}
}

class KeyListenerTest extends Frame {
	
    public KeyListenerTest() {
    	
        setTitle("테스팅 폼");
        setSize(200, 200);
        setVisible(true);
        addWindowListener(new WindowHandler());
        Panel p = new Panel();
        // List에 focus를 주기위함.
        List l = new List(5);
        // 10 X 10 형태의 타일맵 생성
     	// 인덱스 (1, 1)부터 시작
        Field field[][] = new Field[11][11];
        for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				field[i][j] = new Field(i, j);
			}
		}
     	// speed = 1, range = 1, count = 1인 기본 캐릭터를 (1,1) 타일에 생성
        Character player = new Character();
        field[1][1].characterList.add(player);
        
        p.add(l);
        add(p);
        l.addKeyListener(new KeyListener() { // List에 액션리스너를 달음.
 
            public void keyTyped(KeyEvent e) {
                
            }
 
            @Override
            public void keyReleased(KeyEvent e) {
            }
 
            // 모든 키에 반응하지만 대소문자 구분을 못한다.
            public void keyPressed(KeyEvent e) {
            	switch(e.getKeyCode()) {
    			case KeyEvent.VK_RIGHT:
    				if(player.xLocate < 10.5) {
    					player.xLocate += player.speed;
    					System.out.println("오른쪽으로 한칸 이동했습니다. 현재좌표: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("오른쪽 벽입니다.");
    				break;
    			case KeyEvent.VK_LEFT:
    				if(player.xLocate > 0.5) {
    					player.xLocate -= player.speed;
    					System.out.println("왼쪽으로 한칸 이동했습니다. 현재좌표: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("왼쪽 벽입니다.");
    				break;
    			case KeyEvent.VK_UP:
    				if(player.yLocate > 0.5) {
    					player.yLocate -= player.speed;
    					System.out.println("위쪽으로 한칸 이동했습니다. 현재좌표: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("위쪽 벽입니다.");
    				break;
    			case KeyEvent.VK_DOWN:
    				if(player.yLocate < 10.5) {
    					player.yLocate += player.speed;
    					System.out.println("아래쪽으로 한칸 이동했습니다. 현재좌표: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("아랫쪽 벽입니다.");
    				break;
    			case KeyEvent.VK_SPACE:
    				player.attack();
    				break;			
            	}
            }
        });        
 
    }
    
    static class WindowHandler extends WindowAdapter
    {
          public void windowClosing(WindowEvent e)
          {
                System.out.println("윈도우 창 닫기");
                System.exit(0);
          }
    }
    
	private void print(String str) {
		System.out.print(str);
	}
	private void println(String str) {
		System.out.println(str);
	}
	private void println(double str) {
		System.out.println(str);
	}
}
