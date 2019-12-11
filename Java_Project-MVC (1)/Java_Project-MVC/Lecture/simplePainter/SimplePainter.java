package simplePainter;

import javax.swing.JFrame;

public class SimplePainter
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Simple Painter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		SimplePainterView primary = new SimplePainterView();
		SimplePainterController controller = new SimplePainterController();
		
		
		frame.getContentPane().add(primary);
		
		frame.pack();
		frame.setVisible(true);
	}

}
