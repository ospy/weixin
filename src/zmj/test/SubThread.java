package zmj.test;

public class SubThread extends Thread {
	public void run(){
		System.out.println("----SubThread start-----");
		for (int i = 0; i < 10; i++) {
			System.out.println("SubThread i="+i);
			try {
				Thread.sleep(2*00);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----SubThread end-----");
	}
}
