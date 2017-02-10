package com.jamin.java.concurrent.lock;

public class TestProductQueue {

	public static void main(String[] args) {
		
		ProductQueue<String> productQueue = new ProductQueue<>();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("take wait");
					System.out.println(productQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} , "waitThread1");
		thread.start();
		
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("put");
					productQueue.put("abc");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} , "waitThread2");
		thread1.start();
	
	}
}
