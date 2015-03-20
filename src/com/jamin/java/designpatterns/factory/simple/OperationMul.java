package com.jamin.java.designpatterns.factory.simple;

public class OperationMul extends Operation {

	@Override
	public int operation() {
		return getA() * getB();
	}

	
}
