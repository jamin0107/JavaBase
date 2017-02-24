package com.jamin.java.designpatterns.chain;

public class DeptHandler extends ConsumeHandler {

	@Override
	public void doHandler() {
		System.out.println("dept agree");
		if (getNextHandler() != null) {
			getNextHandler().doHandler();
		}
	}

}
