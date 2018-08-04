package com.learning.daemon_threads.main;
/**
 * This class demonstrates that main thread does not die until all non daemon threads die
 * 
 * @author Akshay
 *
 */
public class NonDaemonThreadMain {

	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
		//Give thread a chance to run
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ending parent");

	}

}

class MyRunnable1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Started MyRunnable...");
		while(true) {
			System.out.println("In the infinite loop...");
		}
		//System.out.println("Ended MyRunnable...");
		
	}
	
}
