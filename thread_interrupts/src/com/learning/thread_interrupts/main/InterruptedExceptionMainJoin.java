/**
 * 
 */
package com.learning.thread_interrupts.main;

/**
 * @author Akshay
 * This class shows if the thread joined and is interrupted, it throws an exception
 *
 */
public class InterruptedExceptionMainJoin {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting new threaad...");
		Thread t2 = new SimpleThread2();
		t2.start();
		//Give t1 a chance to run
		Thread.sleep(5000);
		System.out.println("Interrupting threaad...");
		t2.interrupt();

	}

}

class SimpleThread2 extends Thread{
	@Override
	public void run() {
		System.out.println("Started SimpleThread2...");
		Thread t3 = new SimpleThread3();
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("SimpleThread2 interrupted...");
			e.printStackTrace();
		}
	}
	
}

class SimpleThread3 extends Thread{
	@Override
	public void run() {
		System.out.println("Started SimpleThread3...");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ended SimpleThread3...");
	}
	
}
