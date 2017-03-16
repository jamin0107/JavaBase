package com.jamin.java.designpatterns.bridge;

public class Source1 implements Sourceable{

	@Override
	public void connectDB(){
		System.out.println("connect mysql");
	}
}
