package com.jamin.java.concurrent.readerandwriter;

/*
 * ����д������
 * 
 * */

class Buffer {
	public int buffer[] = new int[10];// ���ڱ�ʶ����Ļ�����
	public boolean flag = false;// ���ڱ�ʶ��������״̬
	public int i;// ��ʾ�򻺳���д��λ��
}

class Writer implements Runnable // ���ܻ��ж����
{
	private Buffer buffer;

	public Writer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true)// ��ѭ����ʾ��ͣ��������д����
		{
			synchronized (buffer)// ��������ͬ�������,���涼�ǶԹ������ݵĲ���,ֻ����һ���̲߳���
			{
				while (buffer.flag)
					// �����������flag=true,��ʾ�������ݿ������Ѿ�д�����ݻ�û�б�������,�����д�Ļ�,��Ҫ�ȴ�����Ҳ�ǿ��ƶ�һ��дһ�εĹؼ�
					try {
						buffer.wait();
					} catch (Exception ex) {
					}
				buffer.buffer[buffer.i] = buffer.i;// ���������򻺳�������д�����ݵĲ���
				buffer.i = ((buffer.i + 1) % buffer.buffer.length);// ��ֹ���ݵ����
				buffer.flag = true;
				buffer.notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
			}
		}
	}
}

class Reader implements Runnable {
	private Buffer buffer;

	public Reader(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true) // ��ʾ ���߲�ͣ�ڽ��ж�����
		{
			synchronized (buffer) {
				while (!buffer.flag)
					try {
						buffer.wait();
					} catch (Exception ex) {
					}
				for (int i = 0; i < buffer.i; i++) {
					System.out.print(buffer.buffer[i]);
				}
				System.out.println();
				buffer.flag = false;
				buffer.notifyAll();

			}
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
			} // ��仰û��ʲô��˼,ֻ��Ϊ�����������һ��,�������������û����������,�Ӳ��Ӷ�һ����
		}
	}
}

public class ReaderandWriter {

	public static void main(String args[]) {
		Buffer buffer = new Buffer();
		Thread t1 = new Thread(new Writer(buffer));
		Thread t2 = new Thread(new Writer(buffer));
		Thread t3 = new Thread(new Reader(buffer));
		Thread t4 = new Thread(new Reader(buffer));
		t1.start();
		//t2.start();
		t3.start();
		t4.start();

	}
}
/*
 * ����ĳ�����ֻ��һ�����ߺ�һ��д�ߵ���� ��û���κδ���,д��ûд��һ������,���߾Ͷ�ȡ����һ��
 * ����ʵ����,�̵߳ĸ������ܻ��кܶ���,���ж�����ߺͶ��д�ߵ������,����Ĵ����ֻ�����һ���µ�����---
 * �Ǿ�����дһ���������,�����Ƕ�һ�ζ�д���,�⽫����ְ�ȫ������,������������һ��Ϊʲô������������
 * �����������������ߺ�����д��,����ִ�е��߳��Ƕ���,����д��wait ��,����ִ����������е�һ��д��,Ȼ��д�߿�ʼִ��
 * ��д��ִ����ɺ�,�����ֿ�ʼҪ�����߳�,��Ϊ������������̺߳�һ��д�̶߳��ڵȴ�����,������ѵ�������д�߳�,��Ϊ�����õ���
 * if(buffer.flag) �����wait ֮ǰ���Ѿ��жϹ���,���Ի�ֱ��ִ����������,��ô�����ڶ���һ�ε������,������д������,���д���̸߳���
 * �Ļ�, ��ô�ͻ���ָ��� ������,���������if(buffer.flag)Ҫ�ĳ�while(buufer.flag) buffer.notify
 * Ҫ�ĳ�buffer.notifyAll();��������ȷ��
 * 
 * 
 * ����ĳ���������whiie(flag) notifyAll ����,����,���� д���̻߳�����߳��ж��ٸ�,�����Ƿ���ͬ,���Ƕ������ض�һ��дһ����˳����
 * 
 * 2011/10/24 19:21:45
 */
