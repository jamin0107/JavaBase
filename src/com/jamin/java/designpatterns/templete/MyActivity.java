package com.jamin.java.designpatterns.templete;

public class MyActivity extends Activity{

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("MyActivity onCreate setContentView");
	}
	
	@Override
	public void onDestory() {
		super.onDestory();
		System.out.println("MyActivity onDestory");
	}
}
