package test;

import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import test.KeyListenerTest.WindowHandler;


/*

 		Map Structure
 		
 	1 2 3 4 5 6 7 8 9 10		
1	# # # # # # # # # #				<��ȣ ����>
2	#        		  # 			  #    : ��������
3	#   # #  	# #   #			      *    : ĳ���� ���� ��ġ
4	#   # #  	# #	  #		    	number : ��ǥ		   
5	#         		  #		     
6	#        		  #		       <���� ���� ��ǥ>	  
7	#         	# #   #				(3, 3), (3, 4)		(7, 3), (7, 4)
8	#   *      	# #   #				(4, 3), (4, 4)		(8, 3), (8, 4)
9	#         		  #
10	# # # # # # # # # #									(7, 7), (7, 8)
														(8, 7), (8, 8)


*/


public class TutorialMap {
	int[][] terrianLocation;
	Tile[][] tile;
	public TutorialMap() {
		 // 11 X 11 �������� ����
		 this.terrianLocation = new int[][] {
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
			 {0}, {0}, {0}, {1}, {1}, {0}, {0}, {1}, {1}, {0}, {0},
			 {0}, {0}, {0}, {1}, {1}, {0}, {0}, {1}, {1}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {1}, {1}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {1}, {1}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
			 {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
		 };
		 
		 // �������� ������ ������ Ÿ�ϸ� ����
		 for(int i = 1; i < 11; i++) {
				for(int j = 1; j < 11; j++) {
					tile[i][j] = new Tile(i, j);
					if(i == 1 || j == 1 || i == 10 || j == 10) {
						tile[i][j].wallInfo = true;
						continue;
					}
					if(terrianLocation[i][j] == 1) {
						tile[i][j].terrainInfo = true;	// ���������� ������(Ʃ�丮�� �ʿ����� ��� ���������� �μ� �� ����)
					}
				}
			}
		 
		 // ĳ������ ��ġ ����
		 Character player = new Character();
		 tile[3][8].characterList.add(player);
	}
	
	public static void main(String args[]) {
		
		new KeyListenerTest();
		
	}
}

class KeyListenerTest extends Frame {
	
    public KeyListenerTest() {
    	
        setTitle("�׽��� ��");
        setSize(200, 200);
        setVisible(true);
        addWindowListener(new WindowHandler());
        Panel p = new Panel();
        // List�� focus�� �ֱ�����.
        List l = new List(5);
        // 10 X 10 ������ Ÿ�ϸ� ����
     	// �ε��� (1, 1)���� ����
        Field field[][] = new Field[11][11];
        for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				field[i][j] = new Field(i, j);
			}
		}
     	// speed = 1, range = 1, count = 1�� �⺻ ĳ���͸� (1,1) Ÿ�Ͽ� ����
        Character player = new Character();
        field[1][1].characterList.add(player);
        
        p.add(l);
        add(p);
        l.addKeyListener(new KeyListener() { // List�� �׼Ǹ����ʸ� ����.
 
            public void keyTyped(KeyEvent e) {
                
            }
 
            @Override
            public void keyReleased(KeyEvent e) {
            }
 
            // ��� Ű�� ���������� ��ҹ��� ������ ���Ѵ�.
            public void keyPressed(KeyEvent e) {
            	switch(e.getKeyCode()) {
    			case KeyEvent.VK_RIGHT:
    				if(player.xLocate < 10.5) {
    					player.xLocate += player.speed;
    					System.out.println("���������� ��ĭ �̵��߽��ϴ�. ������ǥ: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("������ ���Դϴ�.");
    				break;
    			case KeyEvent.VK_LEFT:
    				if(player.xLocate > 0.5) {
    					player.xLocate -= player.speed;
    					System.out.println("�������� ��ĭ �̵��߽��ϴ�. ������ǥ: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("���� ���Դϴ�.");
    				break;
    			case KeyEvent.VK_UP:
    				if(player.yLocate > 0.5) {
    					player.yLocate -= player.speed;
    					System.out.println("�������� ��ĭ �̵��߽��ϴ�. ������ǥ: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("���� ���Դϴ�.");
    				break;
    			case KeyEvent.VK_DOWN:
    				if(player.yLocate < 10.5) {
    					player.yLocate += player.speed;
    					System.out.println("�Ʒ������� ��ĭ �̵��߽��ϴ�. ������ǥ: (" + player.xLocate + ", " + player.yLocate + ")");
    				}
    				else
    					println("�Ʒ��� ���Դϴ�.");
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
                System.out.println("������ â �ݱ�");
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

