package com.jamin.java.designpatterns.decorator;

public class Source implements Sourceable{

	@Override
	public void doLogin(String name, String password) {
		System.out.println("login by name + " + name + ", password = " + password);
		
	}

	
}
