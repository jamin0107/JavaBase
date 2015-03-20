package com.jamin.java.designpatterns.factory;

public class OperationMul extends Operation {

	@Override
	public int operation() {
		return getA() * getB();
	}

	
}
