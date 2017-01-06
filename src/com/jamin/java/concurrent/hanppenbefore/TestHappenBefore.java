package com.jamin.java.concurrent.hanppenbefore;

/**
 * ѧϰ���� <br>
 * http://www.blogjava.net/xylz/archive/2010/07/03/325168.html<br>
 * http://www.infoq.com/cn/articles/java-memory-model-2/<br>
 * ��as-if-serial������£�JMM��ѭ����ԭ�� ��ǰ�����д���û��������ʱ��JMM����ѡ�����ָ�����š�<br>
 * ����ʵ�����߳������д���û�������ԣ����ܻᷢ��ָ�����ŵ������<br>
 * ����ͻ����(1,0)(0,0)(1,1)(0,0)������Ϊ����򵥣����Բ�һ���ܳ���ȫ����� Happen-before<br>
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
				//���ּ��ʼ���
				System.out.println(x + "---------------" + y);
			} else {
				System.out.println(x + " " + y);
			}
		}
	}

}
