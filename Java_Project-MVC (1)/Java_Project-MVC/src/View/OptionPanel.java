package View;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {

	private JButton resumeBtn;
	private JButton optionBtn;
	private JButton exitBtn;
	
	private JButton musicBtn;
	private JButton modeBtn;
	private JButton backBtn;

	private boolean musicbtnOnOff;
	private boolean modebtnOnOff;
	public static boolean backbtnOnOff;

	public OptionPanel(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn6) {

      setSize(600, 680);
      setLayout(null);
      setVisible(false);
      
      this.resumeBtn = btn1;
      this.optionBtn = btn2;
      this.exitBtn = btn3;
      this.musicBtn = btn4;
      this.modeBtn = btn5;
      this.backBtn = btn6;
      
      
      
      musicbtnOnOff = false;
      modebtnOnOff = false;
      backbtnOnOff = false;
//      setBackbtnOnOff(false);

      Font font = new Font("Verdana", Font.BOLD, 40);

      musicBtn = new JButton("ON");
      musicBtn.setBounds(150, 140, 250, 100);
      musicBtn.setFont(font);
      this.add(musicBtn);

      modeBtn = new JButton("CLICK");
      modeBtn.setBounds(150, 270, 250, 100);
      modeBtn.setFont(font);
      this.add(modeBtn);

      backBtn = new JButton("BACK");
      backBtn.setBounds(150, 400, 250, 100);
      backBtn.setFont(font);
      this.add(backBtn);

      ActionListener listener = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            Object obj = e.getSource();

            if (obj == musicBtn) {

               if (musicbtnOnOff == false) {
                  musicbtnOnOff = true;
               } else if (musicbtnOnOff == true) {
                  musicbtnOnOff = false;
               }

               if (musicbtnOnOff == false) {
                  musicBtn.setText("OFF");
                  // 소리 끄기
               } else if (musicbtnOnOff == true) {
                  musicBtn.setText("ON");
                  // 소리 켜기
               }

            } else if (obj == modeBtn) {

               if (modebtnOnOff == false) {
                  modebtnOnOff = true;
               } else if (modebtnOnOff == true) {
                  modebtnOnOff = false;
               }

               if (modebtnOnOff == false) {
                  modeBtn.setText("CLICK");
                  // 클릭 모드 (기본)
               } else if (modebtnOnOff == true) {
                  modeBtn.setText("DRAG");
                  // 드래그 모드
               }

            } else if (obj == backBtn) {

               if (backbtnOnOff == false) {
            	   backbtnOnOff = true;
//                  setBackbtnOnOff(true);
               } else if (backbtnOnOff == true) {
            	   backbtnOnOff = false;
//                  setBackbtnOnOff(false);
               }

               if (backbtnOnOff == false) {
            	   backbtnOnOff = true;
            	   
                  musicBtn.setVisible(true);
                  modeBtn.setVisible(true);
                  backBtn.setVisible(true);
                  // 옵션 패널 그대로
               } else if (backbtnOnOff == true) {
            	   backbtnOnOff = false;
            	   System.out.println("backbtn2");
//                  musicBtn.setVisible(false);
//                  modeBtn.setVisible(false);
//                  backBtn.setVisible(false);
                  
                  resumeBtn.setVisible(true);
                  optionBtn.setVisible(true);
                  exitBtn.setVisible(true);
                  
                  SettingPanel.optionbtnOnOff = false;
                  
//                  setVisible(false);
                  
                  // 셋팅 패널로 돌아가기
               }

            }
         }

      };

      musicBtn.addActionListener(listener);
      modeBtn.addActionListener(listener);
      backBtn.addActionListener(listener);
      
   }

   public JButton getBackBtn() {
      return backBtn;
   }

   @Override
   public void paint(Graphics g) {
      Graphics2D g2d = (Graphics2D) g.create();
      g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
      paintComponents(g);
      this.repaint();
   }
   
   public boolean isBackbtnOnOff() {
      return backbtnOnOff;
   }

   public void setBackbtnOnOff(boolean backbtnOnOff) {
      this.backbtnOnOff = backbtnOnOff;
   }
}