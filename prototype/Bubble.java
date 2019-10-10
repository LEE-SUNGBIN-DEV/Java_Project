package prototype;

public class Bubble {
	public Bubble(int range) { // ���ڰ� �� ���� ��, �� �� �ϳ��� �⺻������ ����
		this.range = range;
		System.out.println("���߹ݰ��� " + range + "�̰�, �����ð��� " + delay + "���� ��ź�� �����Ǿ����ϴ�.");
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
		// ��������, ��ֹ� ����
		println(delay*1000 + "sec �� ��ź�� �������ϴ�.");
		println("���� ����: " + range);
	}
	
	private void print(String str) {
		System.out.print(str);
	}
	private void println(String str) {
		System.out.println(str);
	}
}
