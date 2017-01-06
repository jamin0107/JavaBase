package com.jamin.java.concurrent.hanppenbefore;


/**
 * http://www.blogjava.net/xylz/archive/2010/07/04/325206.html<br>
 * Volatile 乐观锁 CAS Compare and Swap
 * TODO:还要重写。
 * @author Jamin
 * 
 */
public class TestVolatile extends Thread {

	private static boolean flag = false;
	private int i  = 0;

	public TestVolatile(int i) {
		this.i= i;
	}
	
	
	@Override
	public void run() {
		while (!flag) {
			System.out.println("Thread Run ------- " + System.currentTimeMillis());
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new TestVolatile(1).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
	}

}


