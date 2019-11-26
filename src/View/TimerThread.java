package View;
import javax.swing.JLabel;
import java.awt.*;

public class TimerThread extends JLabel implements Runnable{

	Thread myThread;
	int nStart1,nStart2;
	int nSleepTime1, nSleepTime2;
	boolean pause_flag;
	boolean stop_flag;
	
	public TimerThread()
	{
		
	} // constructor
	
	public TimerThread(String arg) 
	{
		super(arg);
		initInstanceDatas();
	} // parameter constructor
	
	private void initInstanceDatas()
	{
		myThread = null;
		nStart1 = 60;
		nStart2 = 99;
		nSleepTime1 = 1000;
		nSleepTime2 = 10;
		pause_flag = true;
		stop_flag = false;
	}
	
	public void setStart(int arg1,int arg2) 		{nStart1 = arg1; nStart2 = arg2;}
	public void setSleepTime(int arg1, int arg2) 	{nSleepTime1 = arg1; nSleepTime2 = arg2;}
	public int getStart1() 							{return nStart1;}
	public int getStart2()							{return nStart2;}
	public int getSleepTime1() 						{return nSleepTime1;}
	public int getSleepTime2()						{return nSleepTime2;}

	public void start() 
	{
		if(myThread == null) myThread = new Thread(this);
		myThread.start();
	}
	
	public void stop()
	{
	}
	
	@Override
	public void run() {
		
		
		while(!stop_flag) 
		{
			for(int i=nStart1 ; i>=0; i--)	
			{
				for(int j=nStart2; j>=0; j--)
				{
					while(pause_flag) {
						if(i == 60) j = 0;
						if(j >= 10)
							 setText(Integer.toString(i) + ":" + Integer.toString(j));
						else setText(Integer.toString(i) + ":0" + Integer.toString(j));
						}//System.out.println("suspend"); }
					if(i == 60) j = 0;
					if(j >= 10)
						 setText(Integer.toString(i) + ":" + Integer.toString(j));
					else setText(Integer.toString(i) + ":0" + Integer.toString(j));
					try { myThread.sleep(nSleepTime2); }
					catch(Exception e) {}
				}
			}
		}
	}

	public void suspend() 
	{
//		synchronized ( this )
//		{
//            if ( stateCode == STATE_SUSPENDED) return;
//            if ( stateCode == STATE_INIT )
//                throw new IllegalStateException("not started yet");
//            if ( stateCode == STATE_STOPPED)
//                throw new IllegalStateException("already stopped");
//            stateCode = STATE_SUSPENDED;
//        }
		
		pause_flag = true;
	}


	public void resume() 
	{
//        synchronized ( this ){
//            if ( stateCode == STATE_STARTED || stateCode == STATE_INIT) return;
//            if ( stateCode == STATE_STOPPED)
//                throw new IllegalStateException("already stopped");
//            stateCode = STATE_STARTED;
//            thisThread.interrupt(); 
//        }
		pause_flag = false;
    }
}

