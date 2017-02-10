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
					System.out.println("��Ҫ��һ�����ź� Thread1");
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�õ�һ�����ź� Thread1");
				reentrantLock.unlock();
			}
		} , "waitThread1");
		thread.start();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					reentrantLock.lock();
					System.out.println("���õ����� Thread2");
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
				System.out.println("�ҷ���һ���ź� Thread2");
				reentrantLock.unlock();
			}
		} , "waitThread1");
		thread1.start();
	}
	
}
