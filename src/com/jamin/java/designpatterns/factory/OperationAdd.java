package com.jamin.java.designpatterns.factory;

public class OperationAdd extends Operation {

	@Override
	public int operation() {
		return getA() + getB();
	}

	
}
