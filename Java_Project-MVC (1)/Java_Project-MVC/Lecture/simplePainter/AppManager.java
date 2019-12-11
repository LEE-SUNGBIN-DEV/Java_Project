package simplePainter;
// ΩÃ±€≈Ê
public class AppManager
{
	private static AppManager s_instance;
	private SimplePainterView _view;
	private DrawingPanelView _drawView;
	
	public DrawingPanelView getDrawView()
	{
		return _drawView;
	}

	public void setDrawView(DrawingPanelView _drawView)
	{
		this._drawView = _drawView;
	}

	private AppManager()
	{
	}
	
	public SimplePainterView getView()
	{
		return _view;
	}
	
	public void setView(SimplePainterView view)
	{
		_view = view;
	}
	
	public static AppManager getInstance()
	{
		if (s_instance == null)
			s_instance = new AppManager();
		
		return s_instance;
	}

}
