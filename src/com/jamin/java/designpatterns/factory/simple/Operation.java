package com.jamin.java.designpatterns.factory.simple;

public abstract class Operation {

	private int a;
	private int b;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public abstract int operation();
	
}
