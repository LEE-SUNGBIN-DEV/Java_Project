package Test;

import javax.swing.JFrame;

public class SettingExam {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Setting Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		SettingPanel primary = new SettingPanel();
		frame.getContentPane().add(primary);
		
		frame.pack();
		frame.setVisible(true);
		

		
	}

}
