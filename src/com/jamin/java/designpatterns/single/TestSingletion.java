package com.jamin.java.designpatterns.single;

public class TestSingletion {

	public static void main(String[] args) {
		for(int i =0 ; i <=10 ; i++){
			new Thread(new Runnable() {

				@Override
				public void run() {
					Singleton.getInstance().say();
				}
			}).start();
			new Thread(new Runnable() {

				@Override
				public void run() {
					Singleton.getInstance().say();
				}
			}).start();

		}
	

		
	}
}
