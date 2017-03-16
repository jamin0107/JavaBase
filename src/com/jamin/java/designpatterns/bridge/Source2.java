package com.jamin.java.designpatterns.bridge;

public class Source2  implements Sourceable{
	
	
	@Override
	public void connectDB(){
		System.out.println("connect oracle");
	}
	
}
