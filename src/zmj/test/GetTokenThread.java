package zmj.test;

import org.junit.Test;

public class GetTokenThread implements Runnable {
//	public class GetTokenThread {

	@Test
	public void run() {
		System.out.println("----GetTokenThread start-----");
		for (int i = 0; i < 10; i++) {
			System.out.println("GetTokenThread i="+i);
			try {
				Thread.sleep(2*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----GetTokenThread end-----");
	}

}
