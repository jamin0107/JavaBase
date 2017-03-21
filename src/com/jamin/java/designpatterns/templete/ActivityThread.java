package com.jamin.java.designpatterns.templete;

public class ActivityThread {
	
	

	public static void main(String[] args) {
		ActivityThread myThread = new ActivityThread();
		MyActivity myActivity = new MyActivity();
		myThread.performLaunchActivity(myActivity);
		myThread.performDestroyActivity(myActivity);
	}
	
	
	public void performLaunchActivity(MyActivity activity){
		activity.onCreate();
	}
	
	
	public void performDestroyActivity(MyActivity activity){
		activity.onDestory();
	}
	
}
