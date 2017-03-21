package com.jamin.java.designpatterns.observer;

public class Process implements Observer{

	
	
	ObserverMgr obmgr = null;
	
	public Process() {
		//×¢²á¹Û²ìÕß
		obmgr = new ObserverMgr();
		obmgr.registerObserver(this);
	}
	
	@Override
	public void onReceive(int i) {
		System.out.println("onReceive = " + i );
	}

	
	public void startThread(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i < 10; i ++){
					obmgr.broadcast(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}
	
}
