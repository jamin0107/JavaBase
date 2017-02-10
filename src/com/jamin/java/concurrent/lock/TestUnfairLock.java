package com.jamin.java.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * unfairlock 非公平锁
 * @author Jamin
 *
 */
public class TestUnfairLock {

	public TestUnfairLock() {

	}

	public static void main(String[] args) {
		Service service = new Service();
		ThreadClass tcArray[] = new ThreadClass[20];
		for (int i = 0; i < 20; i++) {
			tcArray[i] = new ThreadClass(service);
			tcArray[i].start();
		}

	}
}

class Service {
	public ReentrantLock lock = new ReentrantLock(false);

	public Service() {
	}

	public void getThreadName() {
		System.out.println(Thread.currentThread().getName() + " 已经被锁定");
	}

}

class ThreadClass extends Thread {
	private Service service;

	public ThreadClass(Service service) {
		this.service = service;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " 抢到了锁");
		service.lock.lock();
		service.getThreadName();
		service.lock.unlock();
	}

}
