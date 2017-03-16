package com.jamin.java.designpatterns.bridge;

public class MyBridge extends Bridge{

	@Override
	public void connectDB() {
		getSource().connectDB();
	}
	
	
	public static void main(String[] args) {
		Sourceable source = new Source1();
		MyBridge myBridge = new MyBridge();
		myBridge.setSource(source);
		myBridge.connectDB();
		
		Sourceable source2 = new Source2();
		MyBridge myBridge2 = new MyBridge();
		myBridge2.setSource(source2);
		myBridge2.connectDB();
	}
}
