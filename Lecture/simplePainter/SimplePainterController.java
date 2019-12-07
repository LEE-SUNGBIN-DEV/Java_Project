package simplePainter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class SimplePainterController
{
	SimplePainterView _view;
	DrawingPanelView _drawView;
	
	public SimplePainterController()
	{
		this._view = AppManager.getInstance().getView();
		this._drawView = AppManager.getInstance().getDrawView();
		
		this._view.addMouseListener(new Hovering());
		this._view.addMenuButtonListener(new MenuButtonListener());
		this._view.addColorButtonListener(new ColorButtonListener());
	}
	
	public SimplePainterController(SimplePainterView view)
	{
		this._view = view;
		this._view.addMouseListener(new Hovering());
		this._view.addMenuButtonListener(new MenuButtonListener());
	} // SimplePainterController
	
	private class ColorButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();

			if(obj == _view.btnColor)
			{
				Color c = _drawView.getDrawColor();
				c = JColorChooser.showDialog(_view, "COLOR CHOOSER", Color.black);
				_drawView.setDrawColor(c);
			}
		}
		
	}
	
	private class MenuButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			
			_view.setVisibleAllOptionComponents(true);
			
			for(int i=0; i<8; i++)
			{
				if(obj == _view.btnMenuArray[i])
				{
					_drawView.setDrawMode(i);
					switch(i)
					{
					case SimplePainterConstants.DOT:
						_view.lblSizeNWidth.setText("SIZE");
						_view.chkFill.setVisible(false);
						break;
					case SimplePainterConstants.LINE:
						_view.lblSizeNWidth.setText("WIDTH");
						_view.chkFill.setVisible(false);
						break;
					case SimplePainterConstants.RECT:
						_view.lblSizeNWidth.setText("WIDTH");
						break;
					case SimplePainterConstants.OVAL:
						_view.lblSizeNWidth.setText("WIDTH");
						break;
					}
					break;
				}
			} // for
			
		} // actionPerformed
		
	} // MenuButtonListener
	
	private class Hovering implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			JButton btn = (JButton)e.getSource();
			btn.setBackground(SimplePainterConstants.MENU_COLOR[2]);
			btn.setForeground(SimplePainterConstants.MENU_COLOR[3]);
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			{
				JButton btn = (JButton)e.getSource();
				btn.setBackground(SimplePainterConstants.MENU_COLOR[0]);
				btn.setForeground(SimplePainterConstants.MENU_COLOR[1]);
			}
		}
	} // Hovering

}//SimplePainterController
