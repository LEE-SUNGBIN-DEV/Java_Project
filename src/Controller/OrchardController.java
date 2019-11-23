package Controller;

import View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Model.*;

public class OrchardController {

	private OrchardModel 	model;
	private OrchardView 	view;
	
	private boolean isClicked;
	private int 	oldX;
	private int 	oldY;
	
	public OrchardController(OrchardModel model, OrchardView view)
	{
		this.model = model;
		this.view = view;
	}
	
	void startGame()
	{
		view.addMouseListener(new SwapMouseListener());
		view.addMouseMotionListener(new SwapMouseListener());
		//view.Update(model.map.getIntGird());
	}
	
	class SwapMouseListener implements MouseListener, MouseMotionListener
	{
		// MouseMotionListener Methods
		@Override
		public void mouseDragged(MouseEvent e)
		{
			// why 50?
			if(isClicked)
			{
				if(e.getX() - oldX > model.tileLength) // right
					Swap.swapTile(oldX/50, oldY/50, oldX/50 + 1, oldY/50, model.map);
				
				if(e.getX() - oldX < model.tileLength)
					Swap.swapTile(oldX/50, oldY/50, oldX/50 + 1, oldY/50, model.map);
				
				if(e.getY() - oldY > model.tileLength)
					Swap.swapTile(oldX/50, oldY/50, oldX/50, oldY/50 + 1, model.map);
				
				if(e.getY() - oldY < model.tileLength)
					Swap.swapTile(oldX/50, oldY/50, oldX/50, oldY/50 - 1, model.map);
				isClicked = false;
				System.out.println("swaped");
				//view.Update(model.map.getIntGird());
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) 
		{
			
		}
		
		// MouseListener Methods
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// nothing happen
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			isClicked = true;
			oldX = e.getX();
			oldY = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			isClicked = false;
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// 과일들 강조효과
		}

		@Override
		public void mouseExited(MouseEvent e) 
		{
			// 과일들 강조효과 해제
		}
		
	}
	
	public static void main(String[] args)
	{
		OrchardModel 	model = new OrchardModel();
		OrchardView 	view  = new OrchardView();
		OrchardController controller = new OrchardController(model, view);

		controller.startGame();
	}
}
