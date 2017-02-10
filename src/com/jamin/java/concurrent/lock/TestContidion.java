package com.jamin.java.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestContidion {

	
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition condition = reentrantLock.newCondition();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					reentrantLock.lock();
					System.out.println("我要等一个新信号 Thread1");
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("拿到一个新信号 Thread1");
				reentrantLock.unlock();
			}
		} , "waitThread1");
		thread.start();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					reentrantLock.lock();
					System.out.println("我拿到锁了 Thread2");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				condition.signalAll();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("我发了一个信号 Thread2");
				reentrantLock.unlock();
			}
		} , "waitThread1");
		thread1.start();
	}
	
}
