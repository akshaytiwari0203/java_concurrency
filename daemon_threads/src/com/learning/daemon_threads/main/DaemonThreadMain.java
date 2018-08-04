package com.learning.daemon_threads.main;
/**
 * This class demonstrates that daemon threads die once the main thread dies
 * 
 * @author Akshay
 *
 */
public class DaemonThreadMain {

	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.setDaemon(true);
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

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Started MyRunnable...");
		while(true) {
			System.out.println("In the infinite loop...");
		}
		//System.out.println("Ended MyRunnable...");
		
	}
	
}
