/**
 * 
 */
package com.learning.thread_interrupts.main;

/**
 * @author Akshay
 * This class shows if the thread is sleeping and is interrupted, it throws an exception
 *
 */
public class InterruptedExceptionMainSleep {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting new threaad...");
		Thread t1 = new SimpleThread1();
		t1.start();
		//Give t1 a chance to run
		Thread.sleep(5000);
		System.out.println("Interrupting threaad...");
		t1.interrupt();

	}

}

class SimpleThread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Started child thread...");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ended child thread...");
	}
	
}
