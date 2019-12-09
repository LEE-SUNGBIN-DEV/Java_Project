package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class HintThread implements Runnable {
	private int combo;
	private TileGrid grid;
	private Timer timer;
	private boolean hintFlag;
	private boolean stop;

	public HintThread(TileGrid grid) {
		this.grid = grid;
		combo = 0;
		stop = false;

		timer = new Timer();
	}

	public int getTotalTime() {
		return timer.getTotalTime();
	}

	public void run() {
		synchronized(this) {
			timer.start();
			hintFlag = true;

			while(!stop) { 

				if(timer.getDeltaTime() >= 7)
				{
					for (int j = 1; j <= 6; j++) {
						for (int i = 1; i <= 8; i++) {   
							// 위, 아래, 왼, 오  swap시  match되는  tile 탐색, 첫번  tile 발견 후 break   
							if (Hint.leftCheck(i,j, grid)||Hint.rightCheck(i,j, grid)||Hint.upCheck(i,j, grid)||Hint.downCheck(i,j, grid)) {
								System.out.println(i + ", " + j);
								timer.getCurrentTime();
								hintFlag = true;
								break;
							} hintFlag = false;
						} if(hintFlag) break;
					}
				}

				Calculator.matchCheck(grid, timer);

				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					System.out.println(e);
				}

			}// entire while
		}
	} // run

	public void stop() {
		this.timer.stop();
		this.stop = false;
	}
}
