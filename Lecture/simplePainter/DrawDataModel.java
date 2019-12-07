package simplePainter;

import java.awt.Color;
import java.awt.Point;

public class DrawDataModel
{
	public int		nDrawMode;
	public Point	pt1, pt2;
	public int		nSizeNWidth;
	public Color	color;
	public boolean	bFill;
	
	public DrawDataModel()
	{
		nDrawMode = SimplePainterConstants.NONE;
		pt1 = new Point();
		pt2 = new Point();
		nSizeNWidth = 1;
		color = Color.black;
		bFill = false;
	}
	
	public DrawDataModel(DrawDataModel obj)
	{
		nDrawMode = obj.nDrawMode;
		pt1 = obj.pt1;
		pt2 = obj.pt2;
		nSizeNWidth = obj.nSizeNWidth;
		color = obj.color;
		bFill = obj.bFill;
	}
}
