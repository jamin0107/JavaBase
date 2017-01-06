package com.jamin.java.concurrent.hanppenbefore;

/**
 * 学习资料 <br>
 * http://www.blogjava.net/xylz/archive/2010/07/03/325168.html<br>
 * http://www.infoq.com/cn/articles/java-memory-model-2/<br>
 * 在as-if-serial的情况下，JMM遵循串行原则， 当前后两行代码没有依赖性时，JMM可以选择进行指令重排。<br>
 * 所以实例中线程里两行代码没有依赖性，可能会发生指令重排的情况。<br>
 * 结果就会出现(1,0)(0,0)(1,1)(0,0)但是因为代码简单，所以不一定能出现全部情况 Happen-before<br>
 * 
 * @author Jamin
 */
public class TestHappenBefore {

	static int x = 0, y = 0, a = 0, b = 0;

	// The field aaaa can be either final or volatile, not both
	// static final volatile int aaaa = 1;

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 1100; i++) {
			x = y = a = b = 0;
			Thread one = new Thread() {
				public void run() {
					a = 1;
					x = b;
				}
			};
			Thread two = new Thread() {
				public void run() {
					b = 1;
					y = a;
				}
			};
			one.start();
			two.start();
			one.join();
			two.join();
			if (x == 1 && y == 1) {
				//出现几率极低
				System.out.println(x + "---------------" + y);
			} else {
				System.out.println(x + " " + y);
			}
		}
	}

}
