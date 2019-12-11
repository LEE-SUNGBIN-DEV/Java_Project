package Model;

public class Timer implements Runnable {

	private int currentTime;
	private int deltaTime;
	private int totalTime;
	private boolean loop;
	private Thread timerThread;
	
	public Timer() {
		currentTime = 1;
		deltaTime = 0;
		totalTime = 1;
		loop = true;
		
		timerThread = new Thread(this);
	}
	
	@Override
	public void run() {
		while(loop) {
			totalTime += 1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public int getCurrentTime() {
		currentTime = totalTime;
		return currentTime;
	}
	
	// 최근 getCurrentTime이 호출된 시점으로부터의 deltaTime을 반환
	public int getDeltaTime() {
		deltaTime = totalTime - currentTime;
		return deltaTime;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	
	public void start() {
		timerThread.start();
	}
	
	public void stop() {
		loop = false;
	}
}