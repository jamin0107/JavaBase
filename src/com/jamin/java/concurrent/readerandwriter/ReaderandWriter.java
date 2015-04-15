package com.jamin.java.concurrent.readerandwriter;

/*
 * 读者写者问题
 * 
 * */

class Buffer {
	public int buffer[] = new int[10];// 用于标识共享的缓冲区
	public boolean flag = false;// 用于标识缓冲区的状态
	public int i;// 表示向缓冲区写的位置
}

class Writer implements Runnable // 可能会有多个读
{
	private Buffer buffer;

	public Writer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true)// 用循环表示不停地向里面写东西
		{
			synchronized (buffer)// 这里面是同步代码块,里面都是对共享数据的操作,只能有一个线程操作
			{
				while (buffer.flag)
					// 如果共享数据flag=true,表示共享数据块里面已经写入数据还没有被读出来,如果再写的话,就要等待，这也是控制读一次写一次的关键
					try {
						buffer.wait();
					} catch (Exception ex) {
					}
				buffer.buffer[buffer.i] = buffer.i;// 这里面是向缓冲区里面写入数据的操作
				buffer.i = ((buffer.i + 1) % buffer.buffer.length);// 防止数据的溢出
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
		while (true) // 表示 读者不停在进行读操作
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
			} // 这句话没有什么意思,只是为了让输出会慢一点,在这个程序里面没有其他作用,加不加都一个样
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
 * 上面的程序在只有一个读者和一个写者的情况 下没有任何错误,写者没写进一个数据,读者就读取数据一次
 * 而在实际中,线程的个数可能会有很多种,在有多个读者和多个写者的情况下,上面的代码又会现在一个新的问题---
 * 那就是在写一个而读多次,或者是读一次而写多次,这将会出现安全性问题,下面我们讨论一下为什么出现这种问题
 * 假设现在有两个读者和两个写者,现在执行的线程是读者,两个写者wait 中,读者执行完后唤醒其中的一个写者,然后写者开始执行
 * 当写者执行完成后,下面又开始要唤醒线程,因为上面的两个读线程和一个写线程都在等待当中,如果唤醒的是再是写线程,因为里面用的是
 * if(buffer.flag) 这个在wait 之前就已经判断过了,所以会直接执行下面的语句,那么就是在读了一次的情况下,而连接写了两次,如果写的线程更多
 * 的话, 那么就会出现更多 的问题,所以上面的if(buffer.flag)要改成while(buufer.flag) buffer.notify
 * 要改成buffer.notifyAll();这样就正确了
 * 
 * 
 * 上面的程序由于由whiie(flag) notifyAll 控制,所以,无论 写者线程或读者线程有多少个,无论是否相同,它们都将遵守读一个写一个的顺序了
 * 
 * 2011/10/24 19:21:45
 */
