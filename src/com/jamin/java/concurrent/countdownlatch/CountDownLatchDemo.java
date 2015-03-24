package com.jamin.java.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

	private static final int PLAYER_AMOUNT = 5;

	public CountDownLatchDemo() {

	}

	public static void main(String[] args) {
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(PLAYER_AMOUNT);
		Player[] players = new Player[PLAYER_AMOUNT];
		for (int i = 0; i < PLAYER_AMOUNT; i++) {
			players[i] = new Player(i + 1, begin, end);
		}
		// �����ض����̳߳أ���СΪ5
		ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
		for (Player p : players) {
			exe.execute(p);// �����߳�
		}
		System.out.println("Race begins!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("running!");
		begin.countDown();
		try {
			end.await(); // �ȴ�end״̬��Ϊ0����Ϊ��������
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("Race ends!");
		}
		
		exe.shutdown();
	}

}
