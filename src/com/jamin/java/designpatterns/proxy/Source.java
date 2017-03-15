package com.jamin.java.designpatterns.proxy;

public class Source implements Sourceable{

	@Override
	public void request(String id) {
		System.out.println("request server + " + id);
	}

	
}
