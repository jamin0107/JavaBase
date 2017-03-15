package com.jamin.java.designpatterns.decorator;

public class Decorator implements Sourceable {

	Source source;

	public Decorator(Source source) {
		this.source = source;
	}

	@Override
	public void doLogin(String name, String password) {
		password = "password(***" + password + "*** after check and md5)";
		System.out.println("Check password and md5");
		this.source.doLogin(name, password);
		System.out.println("after login call back");
	}

	public static void main(String[] args) {
		Decorator decorator = new Decorator(new Source());
		decorator.doLogin("admin", "admin");
	}
}
