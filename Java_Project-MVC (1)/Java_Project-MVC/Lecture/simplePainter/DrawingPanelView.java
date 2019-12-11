package simplePainter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanelView extends JPanel
{
	private ArrayList<DrawDataModel> dataList;
	private DrawDataModel drawData;
	private DrawListener drawL;
	private SimplePainterView _view;
	
	public DrawingPanelView()
	{
		setBackground(Color.white);
		setBounds(0,0,550,500);
		setBorder(BorderFactory.createTitledBorder("DRAW"));
		AppManager.getInstance().setDrawView(this);
		
		_view = AppManager.getInstance().getView();
		
		drawL = new DrawListener();
		addMouseListener(drawL);
		addMouseMotionListener(drawL);
		
		dataList = new ArrayList<DrawDataModel>();
		drawData = new DrawDataModel();
	}
	
	public void setDrawColor(Color color)
	{
		drawData.color = color;
	}
	
	public Color getDrawColor()
	{
		return drawData.color;
	}
	
	public void setDrawMode(int mode)
	{
		drawData.nDrawMode = mode;
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		Graphics2D page2 = (Graphics2D)page;
		// now
		page.setColor(drawData.color);
		page2.setStroke(new BasicStroke(drawData.nSizeNWidth));

		switch(drawData.nDrawMode)
		{
		case SimplePainterConstants.LINE:
		page.drawLine(drawData.pt1.x, drawData.pt1.y, drawData.pt2.x, drawData.pt2.y);
		break;
		}
		
		// saved
		for(DrawDataModel data:dataList)
		{
			page.setColor(data.color);
			page2.setStroke(new BasicStroke(data.nSizeNWidth));
			switch(data.nDrawMode)
			{
			case SimplePainterConstants.DOT:
				page.fillOval(data.pt1.x - data.nSizeNWidth/2,
						data.pt1.y-data.nSizeNWidth/2,
						data.nSizeNWidth,
						data.nSizeNWidth);
				break;
			case SimplePainterConstants.LINE:
				page.drawLine(data.pt1.x, data.pt1.y, data.pt2.x, data.pt2.y);
				break;
			}
		}
	}
	
	private class DrawListener implements MouseListener, MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if(drawData.nDrawMode == SimplePainterConstants.LINE)
			{
				drawData.pt2 = e.getPoint();
				drawData.nSizeNWidth = Integer.parseInt(_view.txtSizeNWidth.getText());
				repaint();
			}
		}
		@Override
		public void mouseClicked(MouseEvent e)
		{
			if(drawData.nDrawMode == SimplePainterConstants.DOT)
			{
				drawData.pt1 = e.getPoint();
				drawData.nSizeNWidth = Integer.parseInt(_view.txtSizeNWidth.getText());
				dataList.add(new DrawDataModel(drawData));
				repaint();
			}
		}
		@Override
		public void mousePressed(MouseEvent e)
		{
			if(drawData.nDrawMode == SimplePainterConstants.LINE)
			{
				drawData.pt1 = e.getPoint();
				drawData.pt2 = drawData.pt1;
				drawData.nSizeNWidth = Integer.parseInt(_view.txtSizeNWidth.getText());
				repaint();
			}
		}
		@Override
		public void mouseReleased(MouseEvent e)
		{
			if(drawData.nDrawMode == SimplePainterConstants.LINE)
			{
				drawData.pt2 = e.getPoint();
				drawData.nSizeNWidth = Integer.parseInt(_view.txtSizeNWidth.getText());
				dataList.add(new DrawDataModel(drawData));
				repaint();
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
}
