package root;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SoundPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	
	private JButton musicButton;
	private JButton soundeffectButton;
	private boolean isMusic = false;
	private long clipTime = 0;
	

	public SoundPanel(){
		
		
		setBackground(Color.gray);
		File f1 = new File("./sound/backMusic.wav");
		File f2 = new File("./sound/broken.wav");
		SoundThread mu1 = new SoundThread(f1);
		Thread t1= new Thread(mu1) ;
		
		musicButton = new JButton("Backgroudn on");
		musicButton.setBounds(50,50,100,100);
		musicButton.setBorderPainted(false);
		musicButton.setContentAreaFilled(false);
		musicButton.setFocusPainted(false);
		musicButton.addMouseListener(new MouseAdapter() {
		@SuppressWarnings("deprecation")
		@Override
			public void mousePressed(MouseEvent e) {
			
				if (isMusic==false&&t1.isAlive()==true) {
				mu1.getClip().setMicrosecondPosition(clipTime);
				mu1.play();
				isMusic=true;
				} // 음악 재시작
				
				else if(isMusic==false) {
				isMusic=true;
				mu1.play();} //음악 아예 처음 시작
				
				else if (isMusic==true) {
				clipTime= mu1.getClip().getMicrosecondPosition();
				mu1.stop();
				isMusic = false; //음악 일시정지
				}
			}
		});
		this.add(musicButton);//음악은 쓰레드를 전역으로 빼서 일시정지 재시작 기능 구현
		
		soundeffectButton = new JButton("push me!");
		soundeffectButton.setBounds(50,200,100,100);
		soundeffectButton.setBorderPainted(false);
		soundeffectButton.setContentAreaFilled(false);
		soundeffectButton.setFocusPainted(false);
		soundeffectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SoundThread mu = new SoundThread(f2);
				mu.play();
			}
		});
		this.add(soundeffectButton);
		
		}//효과음은 쓰레드 이벤트 발생시 할당해서 자동으로 해제 되게 함
	
}