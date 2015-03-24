package com.jamin.java.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Player implements Runnable {

	private int id;
	private CountDownLatch begin;
	private CountDownLatch end;

	public Player(int i, CountDownLatch begin, CountDownLatch end) {
		// TODO Auto-generated constructor stub
		super();
		this.id = i;
		this.begin = begin;
		this.end = end;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			begin.await(); // �ȴ�begin��״̬Ϊ0
			double time = Math.random() * 2000;
			Thread.sleep((long) time); // �������ʱ�䣬���˶�Ա���ʱ��
			System.out.println("Play" + id + " arrived in " + time + "ms");
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			end.countDown(); // ʹend״̬��1�����ռ���0
		}
	}
}