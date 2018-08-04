/**
 * 
 */
package com.learning.thread_interrupts.main;

/**
 * @author Akshay
 * This class shows if the thread is not sleeping or joined and is interrupted, it does not throw an exception
 *
 */
public class WithoutInterruptedExceptionMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting new threaad...");
		Thread t1 = new SimpleThread();
		t1.start();
		//Give t1 a chance to run
		
		Thread.sleep(5000);
		t1.interrupt();

	}

}

class SimpleThread extends Thread{
	@Override
	public void run() {
		while(!this.isInterrupted()) {
			System.out.println("I am not interrupted yet!!!");
		}
		System.out.println("Out of loop...");
	}
	
}
