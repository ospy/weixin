package zmj.test;

public class GetTokenThread implements Runnable {
//	public class GetTokenThread {

	public void run() {
		System.out.println("----GetTokenThread start-----");
		for (int i = 0; i < 10; i++) {
			System.out.println("GetTokenThread i="+i);
			try {
				Thread.sleep(5*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----GetTokenThread end-----");
	}

}
