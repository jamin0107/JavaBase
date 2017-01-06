package com.jamin.java.concurrent.hanppenbefore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用锁实现的简单的类似于AtomicInteger<br>
 * Lock锁的效率要高于synchronized
 * @author Jamin
 *
 */
public class TestLock {
	
	private int value;

	private Lock lock = new ReentrantLock();

	public TestLock() {
		super();
	}

	public TestLock(int value) {
		this.value = value;
	}

	public final int get() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}
	}

	public final void set(int newValue) {
		lock.lock();
		try {
			value = newValue;
		} finally {
			lock.unlock();
		}

	}

	public final int getAndSet(int newValue) {
		lock.lock();
		try {
			int ret = value;
			value = newValue;
			return ret;
		} finally {
			lock.unlock();
		}
	}

	public final boolean compareAndSet(int expect, int update) {
		lock.lock();
		try {
			if (value == expect) {
				value = update;
				return true;
			}
			return false;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndIncrement() {
		lock.lock();
		try {
			return value++;
		} finally {
			lock.unlock();
		}
	}

	public final int getAndDecrement() {
		lock.lock();
		try {
			return value--;
		} finally {
			lock.unlock();
		}
	}

	public final int incrementAndGet() {
		lock.lock();
		try {
			return ++value;
		} finally {
			lock.unlock();
		}
	}

	public final int decrementAndGet() {
		lock.lock();
		try {
			return --value;
		} finally {
			lock.unlock();
		}
	}

	public String toString() {
		return Integer.toString(get());
	}

	public static void main(String[] args) {
		TestLock testLock = new TestLock(10);
		System.out.println(testLock.incrementAndGet());
	}
}
