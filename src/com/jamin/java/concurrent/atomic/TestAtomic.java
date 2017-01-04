package com.jamin.java.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * http://www.blogjava.net/xylz/archive/2010/07/01/324988.html
 * ≤‚ ‘‘≠◊”–‘
 * @author Jamin
 * 
 */
public class TestAtomic {

	static AtomicInteger atomicInteger = new AtomicInteger(0);
	static int a;
	
	public static void main(String[] args) {
		testAtomic();
//		testSpeed();
	}
	
	
	/**
	 * 
	 */
	private static void testSpeed(){

		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 100000000; i++){
			a++;
		}
		
		
		long end = System.currentTimeMillis() - start;
		System.out.println("a++ coast = " + end);
		
		long start2 = System.currentTimeMillis();
		
		for(int i = 0 ; i < 100000000; i++){
			atomicInteger.incrementAndGet();
		}
		
		long end2 = System.currentTimeMillis() - start2;
		System.out.println("atomicInteger++ coast = " + end2);
	}
	
	private static void testAtomic(){
		for(int i = 0 ;i < 1000 ; i++){
			Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i = 0 ; i < 100; i++){
						a++;
						System.out.println("a = " + a);
					}
					
				}
			});
			thread1.start();
		}
		
		
		for(int i = 0 ;i < 1000 ; i++){
			Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i = 0 ; i < 100; i++){
						System.out.println("atomicInteger = " + atomicInteger.incrementAndGet());
					}
					
				}
			});
			thread1.start();
		}

	}
}
