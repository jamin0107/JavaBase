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
		// 设置特定的线程池，大小为5
		ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
		for (Player p : players) {
			exe.execute(p);// 分配线程
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
			end.await(); // 等待end状态变为0，即为比赛结束
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("Race ends!");
		}
		
		exe.shutdown();
	}

}
