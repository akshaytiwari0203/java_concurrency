package com.learning.producer_consumer_wait_notify.main;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		List<Integer> taskQueue = new LinkedList<>();
		Thread producer = new Thread(new Producer(taskQueue));
		Thread consumer = new Thread(new Consumer(taskQueue));
		
		producer.start();
		consumer.start();

	}

}

class Producer implements Runnable{
	
	List<Integer> taskQueue;
	
	Producer(List<Integer> taskQueue){
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (taskQueue) {
				while(taskQueue.size()==10) {
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Integer task = taskQueue.size();
				taskQueue.add(task);
				System.out.println("Produced: "+ task);
				taskQueue.notify();
			}
			
		}
		
	}
	
}

class Consumer implements Runnable{
	
	List<Integer> taskQueue;
	
	Consumer(List<Integer> taskQueue){
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (taskQueue) {
				while(taskQueue.size()==0) {
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Integer task = taskQueue.remove(0);
				System.out.println("Removed: "+ task);
				taskQueue.notify();
			}
			
		}
		
	}
	
}
