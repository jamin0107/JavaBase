package com.jamin.java.designpatterns.proxy;

public class SourceProxy implements Sourceable {

	Source source;
	
	public SourceProxy(){
		source = new Source();
	}
	
	
	
	@Override
	public void request(String id) {
		before();
		source.request(id + "(check)");
		after();
	}



	private void after() {
		System.out.println("response after server");
		
	}



	private void before() {
		System.out.println("check id before request server");
	}
	
	
	public static void main(String[] args) {
		Sourceable source = new SourceProxy();
		source.request("15");
	}
}
