package prototype;

public class Bubble {
	public Bubble(int range) { // 인자가 한 개일 땐, 둘 중 하나를 기본값으로 전달
		this.range = range;
		System.out.println("폭발반경이 " + range + "이고, 지연시간이 " + delay + "초인 폭탄이 생성되었습니다.");
	}
	
	private int range;
	private int delay;
	
	public void bomb() {
		try {
			Thread.sleep(delay*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 지형지물, 장애물 무시
		println(delay*1000 + "sec 후 폭탄이 터졌습니다.");
		println("폭발 범위: " + range);
	}
	
	private void print(String str) {
		System.out.print(str);
	}
	private void println(String str) {
		System.out.println(str);
	}
}
