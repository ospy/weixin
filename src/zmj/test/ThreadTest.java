package zmj.test;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Thread threadMain = Thread.currentThread();
		System.out.println(threadMain.getName());
		Thread thread1 = new Thread(new GetTokenThread());
		thread1.start();
		threadMain.sleep(90000);
		System.out.println(thread1.isAlive());
//		thread1.start();
		Thread thread2 = new SubThread();
		//thread2.start();
		thread2.sleep(2000);
	}

}
